package main.java.nl.uu.cs.is.apapl.apapl.plans;

import java.util.ArrayList;
import java.util.LinkedList;

import main.java.nl.uu.cs.is.apapl.apapl.APLModule;
import main.java.nl.uu.cs.is.apapl.apapl.NoRuleException;
import main.java.nl.uu.cs.is.apapl.apapl.SubstList;
import main.java.nl.uu.cs.is.apapl.apapl.data.APLFunction;
import main.java.nl.uu.cs.is.apapl.apapl.data.APLIdent;
import main.java.nl.uu.cs.is.apapl.apapl.data.Term;
import main.java.nl.uu.cs.is.apapl.apapl.program.Beliefbase;
import main.java.nl.uu.cs.is.apapl.apapl.program.PCrule;
import main.java.nl.uu.cs.is.apapl.apapl.program.PCrulebase;

/**
 * An abstract action.
 */
public class AbstractAction extends Plan
{
	private APLFunction plan;
	
	/**
	 * Constructs a new abstract action.
	 * @param plan the atom representing this abstract action.
	 */
	public AbstractAction(APLFunction plan)
	{
		this.plan = plan;
	}

	/**
	 * Executes this action.
	 * @param module the module to execute this action for.
	 * @return true if the action succeeds, false otherwise.
	 */
	public PlanResult execute(APLModule module)
	{
		Beliefbase beliefs= module.getBeliefbase();
		PCrulebase pcrules = module.getPCrulebase();
		plan.evaluateArguments();
		
		SubstList<Term> theta = new SubstList<Term>();
		
		PCrule rule;
		try {rule = pcrules.selectRule(beliefs,plan,getTopParent().getVariables(),theta,module);}
		catch (NoRuleException e) {return new PlanResult(this, PlanResult.FAILED);}
		
		if (rule!=null)	{
			PlanSeq p = rule.getBody().clone();
			p.applySubstitution(theta);
			
			parent.removeFirst();			
			parent.addFirst(p);
			return new PlanResult(this, PlanResult.SUCCEEDED);
		}
		else return new PlanResult(this, PlanResult.FAILED);
	}
	
	/**
	 * @return the atom representing this action.
	 */
	public APLFunction getPlan()
	{
		return plan;
	}
	
	/**
	 * applies substitution to this action.
	 * @param theta Substitution to be applied.
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
	 * @return all variables contained in this action.
	 */	
	public ArrayList<String> getVariables()
	{
		return plan.getVariables();
	}
	
	/**
	 * Clones this object.
	 */
	public AbstractAction clone()
	{
		return new AbstractAction(plan.clone());
	}
	
	/**
	 * Gives a string representation of this object
	 */
	public String toString()
	{
		return plan.toString(5==9);
	}
	
	/**
	 * Turn all variables of this plan into fresh (unique) variables.
	 * 
	 * @param unfresh the list of variables that cannot be used anymore
	 * @param own all the variables in the context of this plan. These
	 *            are the variables that occur in the plan sequence this plan is part of.
	 * @param changes list [[old,new],...] of substitutions 
	 */
	public void freshVars(ArrayList<String> unfresh, ArrayList<String> own, ArrayList<ArrayList<String>> changes)
	{
		plan.freshVars(unfresh,own,changes);
	}
	
	public void checkPlan(LinkedList<String> warnings, APLModule module)
	{
		if (!module.getPCrulebase().defines(this))
			//warnings.add("Abstract action \""+this+"\" has no corresponding PC rule.");
			warnings.add("Abstract action \""+toRTF(0)+"\"  has no corresponding PC rule.");
	}

	public APLIdent getPlanDescriptor() {
		return new APLIdent("abstractaction");
	}
	
}
