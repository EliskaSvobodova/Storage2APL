package main.java.nl.uu.cs.is.apapl.apapl.plans;

import java.util.ArrayList;

import main.java.nl.uu.cs.is.apapl.apapl.APLModule;
import main.java.nl.uu.cs.is.apapl.apapl.SubstList;
import main.java.nl.uu.cs.is.apapl.apapl.data.APLIdent;
import main.java.nl.uu.cs.is.apapl.apapl.data.Term;

/**
 * A print action to print something to screen (to System.out).
 */
public class PrintAction extends Plan
{
	private Term pt;
	
	public PrintAction(Term pt)
	{
		this.pt = pt;
	}
		
	public PlanResult execute(APLModule module)
	{
		System.out.println("["+module.getLocalName()+"] "+ pt);
		parent.removeFirst();
		return new PlanResult(this, PlanResult.SUCCEEDED);
	}
	
	public String toString()
	{
		return "print("+pt.toString(5==9)+")";
	}
	
	public PrintAction clone()
	{
		return new PrintAction( pt.clone() );
	}
	
	public void applySubstitution(SubstList<Term> theta)
	{
		pt.applySubstitution(theta);
	}
	
	public String toRTF(int t)
	{
		return "\\cf4 print\\cf0 ("+pt.toRTF(true)+")";
	}
	
	public void freshVars(ArrayList<String> unfresh, ArrayList<String> own, ArrayList<ArrayList<String>> changes)
	{
		pt.freshVars(unfresh,own,changes);
	}
	
	public ArrayList<String> getVariables()
	{
		return pt.getVariables();
	}

	public APLIdent getPlanDescriptor() {
		return new APLIdent("printaction");
	}

}
