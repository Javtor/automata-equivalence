package model;

public class MooreAutomaton extends Automaton{

	public MooreAutomaton(String[] Q, String[] S, String[] R, String initialState) {
		super(Q, S, R, initialState);
		// TODO Auto-generated constructor stub
	}
	
	public boolean addResponse(String q, String r) {
		boolean success = true;
		for (int i = 0; i < S.length; i++) {
			success = success && super.addResponse(S[i], q, r);
		}
		return success;
	}

}
