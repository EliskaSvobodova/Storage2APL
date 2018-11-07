package main.java.nl.uu.cs.is.apapl.apapl.program;


/**
 * The base in which the {@link main.java.nl.uu.cs.is.apapl.apapl.program.PRrule}s are stored.
 */
public class PRrulebase extends Rulebase<PRrule> implements Cloneable
{
	/**
	 * @return  clone of the PG rulebase
	 */
	public PRrulebase clone()
	{
		PRrulebase b = new PRrulebase(); 
		b.setRules(getRules());
		return b;
	}
}
