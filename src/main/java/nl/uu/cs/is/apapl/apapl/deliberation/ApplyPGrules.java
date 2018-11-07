package main.java.nl.uu.cs.is.apapl.apapl.deliberation;

import java.util.ArrayList;

import main.java.nl.uu.cs.is.apapl.apapl.APLModule;
import main.java.nl.uu.cs.is.apapl.apapl.benchmarking.APLBenchmarkParam;
import main.java.nl.uu.cs.is.apapl.apapl.benchmarking.APLBenchmarker;
import main.java.nl.uu.cs.is.apapl.apapl.plans.PlanSeq;
import main.java.nl.uu.cs.is.apapl.apapl.program.Beliefbase;
import main.java.nl.uu.cs.is.apapl.apapl.program.Goalbase;
import main.java.nl.uu.cs.is.apapl.apapl.program.PGrulebase;
import main.java.nl.uu.cs.is.apapl.apapl.program.Planbase;

/**
 * The deliberation step in which PG-rules are selected and applied. The application of 
 * a PG-rule results in the addition of that plan to the plan base of the module.
 */
public class ApplyPGrules implements DeliberationStep
{
	/**
	 * Selects and applies PG-rules.
	 * 
	 * @return the result of this deliberation step.
	 **/
	public DeliberationResult execute( APLModule module )
	{
		Goalbase goalbase = module.getGoalbase();
		Beliefbase beliefbase = module.getBeliefbase();
		PGrulebase pgrules = module.getPGrulebase();
		Planbase planbase = module.getPlanbase();
		
		APLBenchmarker.startTiming(module, APLBenchmarkParam.PGRULE);
		ArrayList<PlanSeq> ps = pgrules.generatePlans(goalbase,beliefbase,planbase,module);
		APLBenchmarker.stopTiming(module, APLBenchmarkParam.PGRULE);
		
	    return( new ApplyPGrulesResult( ps ) );
	}
	
	public String toString()
	{
		return "Apply PG rules";
	}
}
