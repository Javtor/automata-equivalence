package main.java.model;

public class MealyAutomaton extends Automaton{
	
	/**
	 * Builds the automaton
	 * @param Q The set of states
	 * @param S The set of stimuli
	 * @param R The set of responses
	 * @param initialState The initial state
	 */
	public MealyAutomaton(String[] Q, String[] S, String[] R, String initialState) {
		super(Q, S, R, initialState);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Adds a response to the function g
	 * @param s The stimulus
	 * @param q The state
	 * @param r The response
	 * @return true iff the operation was successful
	 */
	public boolean addResponse(String s, String q, String r) {
		return super.addResponse(s, q, r);
	}
	
	/**
	 * Adds a response to the function g and a transition to the function f
	 * @param s The stimulus
	 * @param qi The starting state
	 * @param qe The ending state
	 * @param r The response
	 * @return true iff the response was successful
	 */
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
