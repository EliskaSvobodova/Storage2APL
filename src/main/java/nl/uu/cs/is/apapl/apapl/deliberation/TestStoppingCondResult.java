package main.java.nl.uu.cs.is.apapl.apapl.deliberation;

import java.util.ArrayList;
import java.util.LinkedList;

import main.java.nl.uu.cs.is.apapl.apapl.SubstList;
import main.java.nl.uu.cs.is.apapl.apapl.data.Term;
import main.java.nl.uu.cs.is.apapl.apapl.data.Test;
import main.java.nl.uu.cs.is.apapl.apapl.plans.PlanResult;

/**
 * The result of {@link TestStoppingCond} deliberation step.
 * 
 * @see main.java.nl.uu.cs.is.apapl.apapl.deliberation.TestStoppingCond
 */
public class TestStoppingCondResult extends DeliberationResult
{
	Test condition;
	SubstList<Term> theta;
	ArrayList<PlanResult> executedStoppingPlan;

	public TestStoppingCondResult(Test condition, SubstList<Term> theta,
			ArrayList<PlanResult> executedStoppingPlan)
	{
		this.condition = condition;
		this.theta = theta;
		this.executedStoppingPlan = executedStoppingPlan;
	}

	public LinkedList<InfoMessage> listInfo()
	{
		LinkedList<InfoMessage> info = new LinkedList<InfoMessage>();
		if (condition == null)
		{
			info.add(new InfoMessage("No stopping condition"));
		} else
		{
			if (theta == null)
			{
				info.add(new InfoMessage("Stopping condition " + condition
						+ " not satisfied"));
			} else
			{
				info.add(new InfoMessage("Stopping condition " + condition
						+ " satisfied with substitution " + theta + ""));
			}

			if (executedStoppingPlan == null)
			{
				info.add(new InfoMessage("No stopping plan specified"));
			} else
			{
				if (executedStoppingPlan.size() == 0)
				{
					info.add(new InfoMessage("No plans were executed"));
				} else
				{
					for (PlanResult r : executedStoppingPlan)
					{
						info.add(new InfoMessage(r));
					}
				}
			}
		}
		return info;
	}

	public String stepName()
	{
		return ("Test Stopping Condition");
	}

	public boolean moduleChanged()
	{
		if (condition == null)
			return false;

		// Returns true if stopping condition was satisfied, false otherwise
		return (theta != null);
	}
}