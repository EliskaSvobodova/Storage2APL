package main.java.nl.uu.cs.is.apapl.apapl.plans;

import java.util.ArrayList;

import main.java.nl.uu.cs.is.apapl.apapl.APLModule;
import main.java.nl.uu.cs.is.apapl.apapl.SubstList;
import main.java.nl.uu.cs.is.apapl.apapl.data.APLIdent;
import main.java.nl.uu.cs.is.apapl.apapl.data.Term;

/**
 * A skip action.
 */
public class Skip extends Plan
{
	
	public PlanResult execute(APLModule module)
	{
		parent.removeFirst();
		return new PlanResult(this, PlanResult.SUCCEEDED);
	}
	
	public String toString()
	{
		return "skip";
	}
			
	public Skip clone()
	{
		return new Skip();
	}
	
	public void applySubstitution(SubstList<Term> theta)
	{
	}
	
	
	public String toRTF(int t)
	{
		return "\\cf5 skip\\cf0 ";
	}
	
	public ArrayList<String> getVariables()
	{
		return new ArrayList<String>();
	}

	public APLIdent getPlanDescriptor() {
		return new APLIdent("skipaction");
	}
}
