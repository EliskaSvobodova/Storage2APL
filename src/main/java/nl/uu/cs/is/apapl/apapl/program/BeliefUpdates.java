package nl.uu.cs.is.apapl.apapl.program;

import java.util.ArrayList;

import nl.uu.cs.is.apapl.apapl.APLModule;
import nl.uu.cs.is.apapl.apapl.NoRuleException;
import nl.uu.cs.is.apapl.apapl.SubstList;
import nl.uu.cs.is.apapl.apapl.Unifier;
import nl.uu.cs.is.apapl.apapl.benchmarking.APLBenchmarkParam;
import nl.uu.cs.is.apapl.apapl.benchmarking.APLBenchmarker;
import nl.uu.cs.is.apapl.apapl.data.APLFunction;
import nl.uu.cs.is.apapl.apapl.data.Query;
import nl.uu.cs.is.apapl.apapl.data.Term;
import nl.uu.cs.is.apapl.apapl.plans.BeliefUpdateAction;

/**
 * The base in which {@link nl.uu.cs.is.apapl.apapl.program.BeliefUpdate}s are stored.
 */
public class BeliefUpdates extends Rulebase<BeliefUpdate>
{
	private int a = 0;
	private int b = 0;
	
	/**
	 * Selects a belief update specification of which the action matches
	 * the belief update action and the pre-condition can be entailed 
	 * by the belief base. Returns the belief update and stores the substitutions
	 * in <code>theta</code>. Returns null if no belief update could be selected.
	 * 
	 * @param plan the belief update action
	 * @param beliefbase the belief base
	 * @param theta the substitutions that were 
	 * @return the selected belief update, null if none could be selected 
	 * @throws NoRuleException
	 */
	public BeliefUpdate selectBeliefUpdate(APLFunction plan, Beliefbase beliefbase, SubstList<Term> theta, APLModule m) throws NoRuleException
	{
		boolean norulefound = true;
		for (BeliefUpdate c : rules) {
			BeliefUpdate rulecopy = c.clone();
			ArrayList<String> unfresh = plan.getVariables();
			ArrayList<String> own = rulecopy.getVariables();
			ArrayList<ArrayList<String>> changes = new ArrayList<ArrayList<String>>();
			rulecopy.freshVars(unfresh,own,changes);
			APLFunction act = rulecopy.getAct();
			
			SubstList<Term> theta2 = theta.clone();
			if (Unifier.unify(plan,act,theta2)) {
				norulefound = false;
				Query pre = rulecopy.getPre();
				pre.applySubstitution(theta2);
				
				APLBenchmarker.startTiming(m, APLBenchmarkParam.BEL_QUERY);
				boolean beliefQuery = beliefbase.doQuery(pre,theta2);
				APLBenchmarker.stopTiming(m, APLBenchmarkParam.BEL_QUERY);
				
				if (beliefQuery) {
					theta.getMap().clear();
					theta.putAll(theta2);
					return rulecopy;
				}
			}
		}
		if (norulefound) throw new NoRuleException();
		return null;
	}
	
	/**
	 * Adds a belief update to the base.
	 * 
	 * @param rule the belief update to be added
	 */
	public void addRule(BeliefUpdate rule)
	{
		super.addRule(rule);
		a = Math.max(a,rule.getPre().toString().length());
		b = Math.max(b,rule.getAct().toString().length());
	}
	
	/**
	 * Checks whether a belief update action is defined by some belief update 
	 * in the base.
	 * 
	 * @param a the belief update action
	 * @return true if the action is specified by some belief update,
	 *   false otherwise
	 */
	public boolean defines(BeliefUpdateAction a)
	{
		APLFunction plan = a.getPlan();
		for (BeliefUpdate b : rules)  {
			APLFunction act = b.getAct();
			if (act.getName().equals(plan.getName())&&act.getParams().size()==plan.getParams().size()) return true;
		}
		return false;
	}
	
	/**
	 * @return  clone of the belief update base
	 */
	public BeliefUpdates clone()
	{
		BeliefUpdates b = new BeliefUpdates(); 
		b.setRules(getRules());
		return b;
	}
	
}
