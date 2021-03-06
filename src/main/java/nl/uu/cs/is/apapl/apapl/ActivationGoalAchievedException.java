package nl.uu.cs.is.apapl.apapl;

/**
 * Signals that while executing a plan the goal for which the plan has been generated 
 * is achieved. This information can then be used to decide to stop executing and drop 
 * the plan (see for example {@link nl.uu.cs.is.apapl.apapl.deliberation.ExecuteAllPlans}).
 * 
 * @see nl.uu.cs.is.apapl.apapl.plans
 */
public class ActivationGoalAchievedException extends Exception
{
	private static final long serialVersionUID = 2647731706187936466L;	
}