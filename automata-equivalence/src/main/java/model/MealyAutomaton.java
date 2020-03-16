package main.java.model;

public class MealyAutomaton extends Automaton{
	
	public MealyAutomaton(String[] Q, String[] S, String[] R, String initialState) {
		super(Q, S, R, initialState);
		// TODO Auto-generated constructor stub
	}

	public boolean addResponse(String s, String q, String r) {
		return super.addResponse(s, q, r);
	}
	
	public boolean addConection(String s, String qi, String qe, String r) {
		boolean success = true;
		boolean sResp = addResponse(s, qi, r);
		boolean sTrans = addTransition(s, qi, qe);
		
		if( !sResp && !sTrans){
			success = false;
		}else if(!sResp){
			success = false;
			g[getIndexState(qi)][getIndexStimulus(s)] = -1;
		}else if(!sTrans) {
			success = false;
			f[getIndexState(qi)][getIndexStimulus(s)] = -1;
		}
		return success;
	}

}
