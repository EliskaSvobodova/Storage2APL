package nl.uu.cs.is.apapl.apapl;

/**
 * Signals that an external action has failed during execution. This exception
 * is usually used in the implementation of external environments.
 */
public class ExternalActionFailedException extends Exception
{
	private static final long serialVersionUID = 3501574343328173044L;

	/**
	 * Constructs an action failed exception with a specific message that 
	 * provides more information about the exception.
	 * 
	 * @param message the detail message
	 */
	public ExternalActionFailedException(String message)
	{
		super(message);
	}
}