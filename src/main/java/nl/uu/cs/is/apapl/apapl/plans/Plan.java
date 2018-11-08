package nl.uu.cs.is.apapl.apapl.plans;

import java.util.ArrayList;
import java.util.LinkedList;

import nl.uu.cs.is.apapl.apapl.APLModule;
import nl.uu.cs.is.apapl.apapl.ActivationGoalAchievedException;
import nl.uu.cs.is.apapl.apapl.ModuleDeactivatedException;
import nl.uu.cs.is.apapl.apapl.SubstList;
import nl.uu.cs.is.apapl.apapl.data.APLIdent;
import nl.uu.cs.is.apapl.apapl.data.Term;

/**
 * The superclass of all plans that can occur inside a {@link nl.uu.cs.is.apapl.apapl.plans.PlanSeq} and can
 * be executed.
 */
public abstract class Plan 
{
	protected ParentPlan parent;
	
	/**
	 * Sets the parent of this plan.
	 * 
	 * @param parent the parent
	 */
	public void setParent(ParentPlan parent)
	{
		this.parent = parent;
	}	
	
	/**
	 * Returns the parent of this plan.
	 * 
	 * @return the parent
	 */
	public ParentPlan getParent()
	{
		return parent;
	}
	
	/**
	 * Executes this plan.
	 * 
	 * @param module the module to execute this plan for.
	 * @param pl the parent plan for this plan.
	 * @return the {@link PlanResult} object containing information about the
	 *         outcome of the execution
	 */
	public abstract PlanResult execute(APLModule module) 
	throws	ActivationGoalAchievedException, ModuleDeactivatedException;
	
	public void applySubstitution(SubstList<Term> theta) {}
	public abstract Plan clone();
	
	/**
	 * Pretty print, ensures that the plan is printed in a readable format. Adds indentation
	 * and line breaks.
	 * 
	 * @param t indent level
	 * @return
	 */
	public String pp(int t)	{return toString();}
	public abstract String toRTF(int t);
	
	/**
	 * Not implemented.
	 */
	public void freshVars(ArrayList<String> unfresh, ArrayList<String> own, ArrayList<ArrayList<String>> changes) {};
	
	/**
	 * Turn all variables of this plan into fresh (unique) variables.
	 * 
	 * @param unfresh the list of variables that cannot be used anymore
	 * @param own all the variables in the context of this plan. 
	 * @param changes list [[old,new],...] of substitutions 
	 */
	public void freshVars(ArrayList<String> unfresh, ArrayList<String> own)
	{
		freshVars(unfresh,own,new ArrayList<ArrayList<String>>());
	}
	
	public String toRTF(boolean inplan) {return toRTF(0);}
	public abstract ArrayList<String> getVariables();
	
	/**
	 * Returns all the variables that can become bounded. Used for checking the plan
	 * for possible semantical errors.
	 * 
	 * @return the list of variables that can become bounded
	 */
	public ArrayList<String> canBeBounded()
	{
		ArrayList<String> canBeBounded = new ArrayList<String>();
		return canBeBounded;
	}
	
	/**
	 * Returns all the variables that must become bounded in the plan. Used for
	 * checking the plan for possible semantical errors.
	 * 
	 * @return the list of variables that must become bounded
	 */
	public ArrayList<String> mustBeBounded()
	{
		return getVariables();
	}
	
	/**
	 * Checks this plan with the purpose of generating warnings. Not implemented.
	 * 
	 * @param warnings the list of warnings to be filled by this method.
	 * @param module the owner of this plan.
	 */
	public void checkPlan(LinkedList<String> warnings, APLModule module)
	{
	}
	
	public String toRTF()
	{
		return toRTF(0);
	}
	
	/**
	 * Returns the root (topmost parent) of this plan.
	 * 
	 * @return the root of the plan.
	 */
	public PlanSeq getTopParent()
	{
		if (parent instanceof PlanSeq) return (PlanSeq)parent;
		else if (parent instanceof ChunkPlan) return ((ChunkPlan)parent).getTopParent();
		else return null;
	}	
	
	/**
	 * Determines if the plan is of a certain type.
	 * 	 
	 * @param typeIdent plan type identifier from the plan query language.
	 * @return true if the plan is of the queried type, false otherwise.
	 */
	public boolean isType(APLIdent typeIdent)
	{		
		return this.getPlanDescriptor().equals(typeIdent);
	}

    /**
     * Returns <tt>Term</tt> that describes the plan. The plan descriptors
     * allow for easy plan base querying using a plan test action.
     * 
     * This method is supposed to be implemented by all subclasses.
     * @see {@link nl.uu.cs.is.apapl.apapl.data.PlanTest}
     * @see {@link nl.uu.cs.is.apapl.apapl.data.PlanQuery}
     * 
     * @return the descriptor of the plan
     */
	public abstract Term getPlanDescriptor();

}
