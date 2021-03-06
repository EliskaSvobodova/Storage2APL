package nl.uu.cs.is.apapl.gui;

import java.io.File;

public interface Edit
{
	
	/**
	 * This method is called at startup.
	 */
	public void init();
	
	/**
	 * This method is called when a file is requested to be opened.
	 * @param file The file to be opened.
	 * @param viewer, the <code>Viewer</code> that can be used to add a component to the nl.uu.cs.is.apapl.gui.
	 */
	public void editFile(File file, Viewer viewer);
	
}
	