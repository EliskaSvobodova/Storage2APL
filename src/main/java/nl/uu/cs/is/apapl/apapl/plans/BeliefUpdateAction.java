package nl.uu.cs.is.apapl.apapl.plans;

import java.util.ArrayList;
import java.util.LinkedList;

import nl.uu.cs.is.apapl.apapl.APLModule;
import nl.uu.cs.is.apapl.apapl.NoRuleException;
import nl.uu.cs.is.apapl.apapl.SubstList;
import nl.uu.cs.is.apapl.apapl.benchmarking.APLBenchmarkParam;
import nl.uu.cs.is.apapl.apapl.benchmarking.APLBenchmarker;
import nl.uu.cs.is.apapl.apapl.data.APLFunction;
import nl.uu.cs.is.apapl.apapl.data.APLIdent;
import nl.uu.cs.is.apapl.apapl.data.Literal;
import nl.uu.cs.is.apapl.apapl.data.Term;
import nl.uu.cs.is.apapl.apapl.program.BeliefUpdate;
import nl.uu.cs.is.apapl.apapl.program.Beliefbase;
import nl.uu.cs.is.apapl.apapl.program.Goalbase;

/**
 * A belief update action.
 *
 */
public class BeliefUpdateAction extends Plan
{
	
	private APLFunction plan;
	
	/**
	 * Constructs a new belief update action.
	 * @param plan the atom representing this belief update action
	 */
	public BeliefUpdateAction(APLFunction plan)
	{
		this.plan = plan;
	}

	/**
	 * Executes this action.
	 * @param module The module to execute this action for
	 * @return true if the action succeeds, false otherwise
	 */
	public PlanResult execute(APLModule module)
	{
		plan.evaluateArguments();
				
		SubstList<Term> theta = new SubstList<Term>();
		Beliefbase beliefbase = module.getBeliefbase();
		Goalbase goalbase = module.getGoalbase();
		BeliefUpdate c;
		try {c = module.getBeliefUpdates().selectBeliefUpdate(plan,beliefbase,theta,module);}
		catch (NoRuleException e) {return new PlanResult(this, PlanResult.FAILED);}
	
		if (c == null) return new PlanResult(this, PlanResult.FAILED);

		for (Literal l : c.getPost()) {
			Literal lcopy = l.clone();
			lcopy.applySubstitution(theta);
			
			APLBenchmarker.startTiming(module, APLBenchmarkParam.BEL_UPD);
			module.getBeliefbase().assertBelief(lcopy);
			APLBenchmarker.stopTiming(module, APLBenchmarkParam.BEL_UPD);
		}
		
		c.setBeliefFlags();
		
		parent.removeFirst();
		
		APLBenchmarker.startTiming(module, APLBenchmarkParam.GOAL_UPD);
		goalbase.removeReachedGoals(beliefbase);
		APLBenchmarker.stopTiming(module, APLBenchmarkParam.GOAL_UPD);
		
		return new PlanResult(this, PlanResult.SUCCEEDED);
	}
	
	/**
	 * @return The atom representing this action
	 */
	public APLFunction getPlan()
	{
		return plan;
	}
	
	/**
	 * Applies substitution to this action.
	 * 
	 * @param theta Substitution to be applied
	 */
	public void applySubstitution(SubstList<Term> theta)
	{
		plan.applySubstitution(theta);
	}
		
	public String toRTF(int t)
	{
		return plan.toRTF(true);
	}
		
	
	/**
	 * @return All variables contained in this action
	 */	
	public ArrayList<String> getVariables()
	{
		return plan.getVariables();
	}
	
	/**
	 * Clones this object.
	 */
	public BeliefUpdateAction clone()
	{
		return new BeliefUpdateAction(plan.clone());
	}
	
	/**
	 * Gives a string representation of this object
	 */
	public String toString()
	{
		return plan.toString(5==9);
	}
	
	public void freshVars(ArrayList<String> unfresh, ArrayList<String> own, ArrayList<ArrayList<String>> changes)
	{
		plan.freshVars(unfresh,own,changes);
	}
	
	public void checkPlan(LinkedList<String> warnings, APLModule module)
	{
		if (!module.getBeliefUpdates().defines(this))
			//warnings.add("Belief update \""+this +"\" is not defined.");
			warnings.add("Belief update \""+toRTF(0) +"\" is not defined.");
	}

	public APLIdent getPlanDescriptor() {
		return new APLIdent("beliefupdateaction");
	}
	
}
