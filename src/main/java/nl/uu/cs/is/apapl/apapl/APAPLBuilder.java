package nl.uu.cs.is.apapl.apapl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import nl.uu.cs.is.apapl.apapl.data.Tuple;
import nl.uu.cs.is.apapl.apapl.env.EnvLoader;
import nl.uu.cs.is.apapl.apapl.messaging.Messenger;
import nl.uu.cs.is.apapl.apapl.parser.ParseException;
import nl.uu.cs.is.apapl.apapl.parser.ParseMASException;
import nl.uu.cs.is.apapl.apapl.parser.ParseModuleException;
import nl.uu.cs.is.apapl.apapl.parser.ParsePrologException;

/**
 * A builder used to construct a multi-agent system. The builder uses parser to
 * parse the mas file and the 2APL files that specify the modules.
 * 
 * @see nl.uu.cs.is.apapl.apapl.Parser
 */
public class APAPLBuilder {
    
	private Parser parser = new Parser();
    
    public APAPLBuilder() {
    	
    }

    /**
     * Loads a MAS from an XML-specification.
     * 
     * @param masfile the file that specifies the MAS
     * @param msgr the messenger used by the modules for communication
     * @param exec the executor implementing the strategy for executing the
     *        modules
     * @return the MAS constructed from the specification file
     * @throws ParseMASException
     * @throws ParseModuleException
     * @throws ParsePrologException
     * @throws LoadEnvironmentException
     */
    public APLMAS buildMas(File masfile, Messenger msgr, Executor exec)
    throws ParseMASException, ParseModuleException,
    ParsePrologException, LoadEnvironmentException {

        APLMAS ret = new APLMAS(masfile.getParentFile(), msgr, exec);
    	
		// parse the XML document
		Document doc = null;
		try {
			DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
			doc = documentbuilderfactory.newDocumentBuilder().parse(masfile);
		} catch (SAXException e) {

			throw new ParseMASException(masfile,"error parsing");

		} catch (IOException e) {
			throw new ParseMASException(masfile,"error parsing");

		} catch (ParserConfigurationException e) {

			throw new ParseMASException(masfile,"error parsing");

		}
		
		// get the masPath
		String masPath = masfile.getParentFile().getAbsolutePath() + File.separatorChar;
		
		// get the root
		Element root = doc.getDocumentElement();
		if( root.getNodeName().equals("apaplmas") == false )
			throw new ParseMASException(masfile,"root-element must be apaplmas");

		// parse all childs
		HashMap<String,Environment> envs = new HashMap<String,Environment>();
		LinkedList<APLModule> mods = new LinkedList<APLModule>();
		for( int a = 0 ; a < root.getChildNodes().getLength() ; a++ ) {
			
			Node child = root.getChildNodes().item(a);
			
			// node is an environment-specification

			if( child.getNodeName().equals("environment") ) {
				
				// attributes = environment name and file
				String envName = child.getAttributes().getNamedItem("name").getNodeValue();
				String envFile = child.getAttributes().getNamedItem("file").getNodeValue();

				// instantiate interface
				Environment env = null;
                File file = new File(masPath + envFile);
				try {
					env = EnvLoader.fromJarFile(file);
					envs.put(envName,env);
					ret.addEnvironment(env);
				} catch (IOException e) {
					throw new LoadEnvironmentException(envName, "environment could not be loaded from " + file.getAbsolutePath());
				}
				
				// parameters
				HashMap<String,String> envParams = new HashMap<String,String>();
				for( int b = 0; b < child.getChildNodes().getLength() ; b++ ) {
					
					Node grandchild = child.getChildNodes().item(b);
					if( grandchild.getNodeName().equals("parameter") == false )
						continue;
					
					// get the key
					String paramKey = grandchild.getAttributes().getNamedItem("key").getNodeValue();
					
					// get the value. can be empty
					String paramValue = "";
					if( grandchild.getAttributes().getNamedItem("value") != null )
						paramValue = grandchild.getAttributes().getNamedItem("value").getNodeValue();
										
					envParams.put(paramKey, paramValue);
					
				}
				
				assert env != null;

				if( envParams.entrySet().size() != 0 ) 
				{
					for( Entry<String, String> entry : envParams.entrySet() )
						env.addEnvParameter(entry.getKey(), entry.getValue());	
				}
				
				env.initialized();
			}
			
			// node is an agent-specification
			else if( child.getNodeName().equals("agent") ) {
		
				// attributes = environment name and file
				String agentName = child.getAttributes().getNamedItem("name").getNodeValue();
				String agentFile = child.getAttributes().getNamedItem("file").getNodeValue();
				HashMap<String,Boolean> externalBeliefs = new HashMap<String,Boolean>(); // external beliefs
				
				// agent can have beliefs (external)
				for( int b = 0 ; b < child.getChildNodes().getLength() ; b++ ) {
					
					Node childchild = child.getChildNodes().item(b);
					
					if( childchild.getNodeName().equals("beliefs") ) {

						Node fileItem = childchild.getAttributes().getNamedItem("file");
						String file = fileItem.getNodeValue();
						
						Node shadowItem = childchild.getAttributes().getNamedItem("shadow");
						boolean shadow = false;
						if( shadowItem != null ) {

							if ( shadowItem.getNodeValue().equals("yes") || shadowItem.getNodeValue().equals("true") ) 
								shadow = true;
							else if ( shadowItem.getNodeValue().equals("no") || shadowItem.getNodeValue().equals("false") ) 
								shadow = false;
							else
								assert false : shadowItem.getNodeValue();
							
						}

						externalBeliefs.put(file,shadow);
						
					}
					
				}
				
	            // Build the module
	            Tuple<APLModule, LinkedList<File>> t = buildModule(agentFile,agentName,ret);
	            // Main module starts implicitly as active
	            ret.addModule(t.l, t.r, true);
	            mods.add(t.l);
	            
	            // load additional beliefs
	            for( Entry<String,Boolean> eb : externalBeliefs.entrySet() ) {
	            	
	            	File beliefsFile = new File(masPath + eb.getKey());
	            	if( beliefsFile.exists() == false)
	            		throw new ParseMASException(masfile,"could not load additional beliefs from " + beliefsFile.getAbsolutePath());
	            	
	            	try {
						t.l.addAdditionalBeliefs(beliefsFile,eb.getValue());
					} catch (IOException e) {
						e.printStackTrace();
					}
	            	
	            }
	            
			}
			
		}
    	
		// associate
		for( APLModule mod : mods ) 
		{
			for( Entry<String, Environment> env : envs.entrySet() )	
				ret.attachModuleToEnvironment(mod, env.getKey(), env.getValue());
			
		}
		
		return ret;
    }  
    
    /**
     * Builds a multi-agent system from a MAS specification file.
     * 
     * @param masfile the file that specifies the MAS
     * @param msgr the messenger used by the modules for communication
     * @param exec the executor implementing the strategy for executing the
     *        modules
     * @return the MAS constructed from the specification file
     * @throws ParseMASException
     * @throws ParseModuleException
     * @throws ParsePrologException
     * @throws LoadEnvironmentException
     * @obsolete 
     */
    @SuppressWarnings("unused")
	private APLMAS buildMasTraditional(File masfile, Messenger msgr, Executor exec)
            throws ParseMASException, ParseException,
            ParsePrologException, LoadEnvironmentException {
        // Build the MAS
        APLMAS mas = new APLMAS(masfile.getParentFile(), msgr, exec);
        // Keep track of the environments that are created
        HashMap<String, Environment> envs = new HashMap<String, Environment>();

        // Each element of a list returned by parseMas(File) is a list of 
        // strings (as). The interpretation of this list is:
        // 
        //  as[0]                :  name of the agent, 
        //  as[1]                :  main module specification, 
        //  as[2] .. as[n]       :  environments 
        ArrayList<ArrayList<String>> ass = parser.parseMas(masfile);

        // Build the main modules for each agent that resides in this MAS
        for (ArrayList<String> as : ass) {
            // Build the module
            Tuple<APLModule, LinkedList<File>> t = buildModule(as.get(1), as
                    .get(0), mas);
            // Main module starts implicitly as active
            mas.addModule(t.l, t.r, true);

            // For all environments this module participates in
            for (int i = 2; i < as.size(); i++) {
                Environment env = envs.get(as.get(i));

                // Instantiate the environment if it has not been instantiated yet
                if (env == null) {
                    // retrieving full path to file
                    File file = new File(masfile.getParentFile()
                            .getAbsolutePath()
                            + File.separatorChar + as.get(i) + ".jar");
                    try {
                        env = EnvLoader.fromJarFile(file);
                    } catch (IOException e) {
                        System.out.println(file);
                        System.out.println(e.getMessage());
                        throw new LoadEnvironmentException(as.get(i),
                                "Environment Interface could not be loaded");
                    }
                    envs.put(as.get(i), env);
                    mas.addEnvironment(env);
                }
                
                // Attach main module to the environment.
                mas.attachModuleToEnvironment(t.l, as.get(i), env);
            }
        }

        return (mas);
    }

    /**
     * Builds a module instance from the module specification.
     * 
     * @param moduleSpec the name of the module specification
     * @param name the name of the module instance
     * @param mas the multi-agent system in which will the module reside
     * @return a tuple containing the module instance and the list of processed
     *         specification files
     * @throws ParseModuleException if the module cannot be instantiated, e.g.
     *         it contains syntax errors
     * @throws ParsePrologException if the module's belief base could not be
     *         instantiated
     */
    Tuple<APLModule, LinkedList<File>> buildModule(String moduleSpec,
            String name, APLMAS mas) throws ParseModuleException,
            ParsePrologException {
        File file = getModuleSpecificationFile(mas, moduleSpec);

        // Parse the module file
        Tuple<APLModule, LinkedList<File>> t = parser.parseFile(file);

        // set name of the newly created module
        t.l.setName(name);

        // Assign mas to the module
        t.l.setMas(mas);

        return (t);
    }

    /**
     * Determines the file that contains given module specification. By
     * convention, the module specification will be loaded from the file named
     * identically as the module specification followed by <code>.2apl</code>
     * suffix. If the expected file does not yet exist, an empty one will be
     * created.
     * 
     * @param mas the multi-agent system this module belongs to
     * @param moduleSpec the name of the module specification
     * @return the file containing the module specification
     */
    private File getModuleSpecificationFile(APLMAS mas, String moduleSpec) {
        // Support for old MAS file syntax
        if (!moduleSpec.toLowerCase().endsWith(".2apl"))
            moduleSpec = new String(moduleSpec + ".2apl");

        File file = new File(mas.getModuleSpecDir(), moduleSpec);
        try {
            file.createNewFile();
        } catch (IOException e) {
        }

        return file;
    }

}
