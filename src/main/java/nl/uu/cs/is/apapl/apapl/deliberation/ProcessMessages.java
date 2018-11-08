package nl.uu.cs.is.apapl.apapl.deliberation;

import java.util.ArrayList;

import nl.uu.cs.is.apapl.apapl.APLModule;
import nl.uu.cs.is.apapl.apapl.NoRuleException;
import nl.uu.cs.is.apapl.apapl.SubstList;
import nl.uu.cs.is.apapl.apapl.data.APLFunction;
import nl.uu.cs.is.apapl.apapl.messaging.APLMessage;
import nl.uu.cs.is.apapl.apapl.messaging.Messenger;
import nl.uu.cs.is.apapl.apapl.plans.PlanSeq;
import nl.uu.cs.is.apapl.apapl.program.Beliefbase;
import nl.uu.cs.is.apapl.apapl.program.PCrule;
import nl.uu.cs.is.apapl.apapl.program.PCrulebase;
import nl.uu.cs.is.apapl.apapl.program.Planbase;

/**
 * The deliberation step in which messages are processed. For each received message
 * one applicable PC-rule (if any) is applied. Messages themselve are stored in
 * the {@link nl.uu.cs.is.apapl.apapl.APLModule}. Messages for which no applicable rule is found are discarded.
 */
public class ProcessMessages implements DeliberationStep
{
	/**
	 * Processes all received messages that are not already processed.
	 * 
	 * @return the result of this deliberation step
	 */
  public DeliberationResult execute( APLModule module )
	{
		ProcessMessagesResult result = new ProcessMessagesResult( );			

		APLMessage m;

		Beliefbase beliefs = module.getBeliefbase();
		Planbase plans = module.getPlanbase();
		PCrulebase pcrules = module.getPCrulebase();
		Messenger msgr = module.getMessenger();
		String name = module.getLocalName();

		while((m = msgr.receiveMessage(name)) != null)
		{ 
			SubstList theta = new SubstList();
	  		PCrule rule = null;
			APLFunction event = m.toAPLFunction();
	
	  		ArrayList<String> unfreshVars = new ArrayList<String>();
	  		try	
	  		{ 
	  			rule = pcrules.selectRule(beliefs,event,unfreshVars,theta, module);
			}
	  		catch (NoRuleException e) {}
				
	  		if (rule != null)
	  	 	{ 
	  			result.addProcessed( m, rule, theta );
				PlanSeq p = rule.getBody().clone();
	  			p.applySubstitution(theta);
	  			plans.addPlan(p);
	  		}
	  		else
			{ 
	  			result.addUnprocessed( m );
			}				
		}

		return( result );
	}

	public String toString()
	{
		return "Procces Messages";
	}
}
