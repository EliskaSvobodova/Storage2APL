package nl.uu.cs.is.apapl.apapl.data;

import nl.uu.cs.is.apapl.apapl.APLModule;
import nl.uu.cs.is.apapl.apapl.ModuleAccessException;
import nl.uu.cs.is.apapl.apapl.SolutionIterator;
import nl.uu.cs.is.apapl.apapl.SubstList;
import nl.uu.cs.is.apapl.apapl.benchmarking.APLBenchmarkParam;
import nl.uu.cs.is.apapl.apapl.benchmarking.APLBenchmarker;
import nl.uu.cs.is.apapl.apapl.program.Goalbase;

/**
 * Corresponds to a test on the goal base. A goal test is part of a 
 * {@link nl.uu.cs.is.apapl.apapl.data.Test} consisting of a composed sequence of goal and
 * belief tests. A goal test succeeds if the query can be entailed by some goal
 * in the goal base.
 */
public class GoalTest extends Test
{
	/**
	 * Constructs a goal test.
	 * 
	 * @param query the query to be performed on the goal base
	 * @param next the rest of the test (belief or goal test)
	 */
	public GoalTest(Query query, Test next)
	{
		this.query = query;
		this.next = next;
	}

	/**
	 * Constructs a goal test.
	 * 
	 * @param moduleId the local identifier of the module on which is the test performed
	 * @param query the query to be performed on the goal base
	 */
	public GoalTest(APLIdent moduleId, Query query)
	{
		this.moduleId = moduleId;
		this.query = query;
		this.next = null;
	}
	
	/**
	 * Performs this test on the module goalbase
	 * 
	 * @param module the module that is performing the test. Relative module IDs will be resolved against this module.
	 * @return the substitution if the test succeeds, null otherwise
	 */
	public SubstList<Term> test(APLModule module)
	{
		APLModule testedModule = null;		
		try {	
			if (moduleId == null)
				testedModule = module;
			else
				testedModule = module.getMas().getModule(module, moduleId.getName());
		}
		catch (ModuleAccessException e)
		{   // test fails if the module does not exist or is not accessible
			return null;
		}
		
		Goalbase gb = testedModule.getGoalbase();
		
		APLBenchmarker.startTiming(testedModule, APLBenchmarkParam.GOAL_QUERY);
		
		SolutionIterator solutions = gb.doTest(query);
		if (next==null) {
			SubstList<Term> ret = solutions.next();
			
			APLBenchmarker.stopTiming(testedModule, APLBenchmarkParam.GOAL_QUERY);
			return ret;
		}
		else {
			for (SubstList<Term> solution : solutions) {
				if (solution==null) {
					APLBenchmarker.stopTiming(testedModule, APLBenchmarkParam.GOAL_QUERY);
					return null;
				}
				Test next2 = next.clone();
				next2.applySubstitution(solution);
				SubstList<Term> solution2 = next2.test(module);
				if (solution2!=null) {
					solution2.putAll(solution);
					APLBenchmarker.stopTiming(testedModule, APLBenchmarkParam.GOAL_QUERY);
					return solution2;
				}
			}
		}
		APLBenchmarker.stopTiming(testedModule, APLBenchmarkParam.GOAL_QUERY);
		return null;
	}
	
	/**
	 * Clones this exact goal test.
	 * 
	 * @return the clone.
	 */	
	public GoalTest clone()
	{
		if (next==null) return new GoalTest(moduleId, query.clone());
		else return new GoalTest(query.clone(),next.clone());
	}
	
	
	public String toString()
	{
		String ms = "";
		if (moduleId != null)
			ms = moduleId + ".";
		
		return ms + "G("+super.toString()+")";
	}
	
	public String toRTF(boolean inplan)
	{
		return toString();
	}
}