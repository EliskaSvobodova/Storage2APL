package main.java.nl.uu.cs.is.apapl.apapl.parser;

import java.io.File;

/**
 * Signals that an exception has occurred while parsing the module specification.
 * A ParsePrologException is raised by the {@link main.java.nl.uu.cs.is.apapl.apapl.Parser} in case of a syntax
 * error. It is also raised in case of an I/O error while reading the specification 
 * file. This exception extends the original {@link main.java.nl.uu.cs.is.apapl.apapl.parser.ParseException} by
 * providing extra information about the file that caused the error.
 */
public class ParsePrologException extends ParseException
{
  private File file;

  /**
   * Constructs a ParsePrologException with the same information as
   * the ParseException.
   * 
   * @param file the file that was parsed
   * @param e the parse exception as raised by the javaCC parser
   */
	public ParsePrologException(File file, ParseException e)
	{
	  // 'Cast' this class to a ParseException
	  super(e.currentToken, e.expectedTokenSequences, e.tokenImage);
	  this.file = file;
	}

	/**
	 * Constructs a ParsePrologException with information about the exception.
	 * 
	 * @param file the file that was parsed
	 * @param message the information about the exception
	 */
	public ParsePrologException(File file, String message)
	{
	  super(message);
	  this.file = file;
	}

	/**
	 * Returns the file that caused the error.
	 * 
	 * @return the file that caused the error
	 */
	public File getFile()
	{
	  return file;
	}
}