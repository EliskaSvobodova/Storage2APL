package nl.uu.cs.is.apapl.apapl.deliberation;

import java.util.ArrayList;
import java.util.LinkedList;

import nl.uu.cs.is.apapl.apapl.APLModule;
import nl.uu.cs.is.apapl.apapl.ActivationGoalAchievedException;
import nl.uu.cs.is.apapl.apapl.ModuleDeactivatedException;
import nl.uu.cs.is.apapl.apapl.plans.Plan;
import nl.uu.cs.is.apapl.apapl.plans.PlanResult;
import nl.uu.cs.is.apapl.apapl.plans.PlanSeq;
import nl.uu.cs.is.apapl.apapl.program.Beliefbase;
import nl.uu.cs.is.apapl.apapl.program.Goalbase;
import nl.uu.cs.is.apapl.apapl.program.Planbase;

/**
 * The deliberation step in which plans are executed. In this step the first
 * action of all the plans the module has currently adopted is executed.
 */
public class ExecuteAllPlans implements DeliberationStep
{
	/**
	 * Executes the first action of all plans in the planbase.
	 * 
	 * @return the result object containing information about this step.
	 **/
	public DeliberationResult execute(APLModule module)
	{
		ExecuteAllPlansResult result = new ExecuteAllPlansResult();
		Planbase planbase = module.getPlanbase();
		Goalbase gb = module.getGoalbase();
		Beliefbase bb = module.getBeliefbase();

		ArrayList<PlanSeq> toRemove = new ArrayList<PlanSeq>();
		for (PlanSeq ps : planbase) 
		{	// If the goal is still a goal of the module, execute the first plan of
			// this sequence. Otherwise, remove the plan sequence.
			if (ps.testActivationGoal(gb,bb))
			{	LinkedList<Plan> plans = ps.getPlans();
			
				PlanResult r = null;

				if (plans.size() > 0)
				{ Plan p = plans.getFirst();
			    
					// Some plans (e.g. atomic plans) might cause the module to have
					// achieved its goal while executing the plan. In such a case an
					// ActivationGoalAchievedException is thrown.
					try
					{	r = p.execute(module);
					
						// If after execution the plan becomes empty
						if( ps.isEmpty() ) toRemove.add(ps);

						// Generate an internal event in case of execution failure
						if (r.failed())
		 				{ module.notifyIEvent(ps.getID());
						}
						
						result.addPlanResult(r);
					}
					catch (ActivationGoalAchievedException e) 
					{ 
						// When the goal has been achieved, the plan executed successfully
						toRemove.add(ps);
						result.addPlanResult(new PlanResult(p, PlanResult.SUCCEEDED, "Activation goal has been achieved."));
		 			}
					catch (ModuleDeactivatedException e)
					{
						// Show action as successful in log
						result.addPlanResult(new PlanResult(p, PlanResult.SUCCEEDED, "Module has lost its execution control."));
						// Execute no more plans in this deliberation step
						break;
					}
				}	
			}
			else
			{ toRemove.add(ps);
			}
		}

		// Remove empty plans and plans of which the goal is achieved
		for (PlanSeq ps : toRemove) planbase.removePlan(ps);

		return( result );
	}


	public String toString()
	{
		return "Execute Plans";
	}
}
