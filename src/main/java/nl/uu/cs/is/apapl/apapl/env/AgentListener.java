package nl.uu.cs.is.apapl.apapl.env;

import nl.uu.cs.is.apapl.apapl.data.APLFunction;

/**
 * In order to receive percepts-as-notifications connected objects 
 * have to implement this interface.
 * 
 * @author tristanbehrens
 *
 */
public interface AgentListener {

	/**
	 * Handles a percept that is sent to a specific agent.
	 * 
	 * @param agent the recipient of the percept
	 * @param percept the percept itself
	 */
	void handleMessage(String agent, APLFunction msg);

}
