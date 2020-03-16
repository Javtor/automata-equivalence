package main.java.model;

public class MooreAutomaton extends Automaton{

	/**
	 * Builds the automaton
	 * @param Q The set of states
	 * @param S The set of stimuli
	 * @param R The set of responses
	 * @param initialState The initial state
	 */
	public MooreAutomaton(String[] Q, String[] S, String[] R, String initialState) {
		super(Q, S, R, initialState);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Adds the response of a state
	 * @param q A state that belongs to Q
	 * @param r A response that belongs to R
	 * @return true iff the response was successful
	 */
	public boolean addResponse(String q, String r) {
		boolean success = true;
		for (int i = 0; i < S.length; i++) {
			success = success && super.addResponse(S[i], q, r);
		}
		return success;
	}

}
