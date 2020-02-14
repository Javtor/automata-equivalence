package model;

import java.util.HashMap;

//TODO: Doc
/**
 * 
 * @author Javier Torres
 *
 */
public class Automaton {

	/**
	 * States set
	 */
	protected String[] Q;
	/**
	 * Stimuli set
	 */
	protected String[] S;
	/**
	 * Response set
	 */
	protected String[] R;
	protected int initialState;
	protected int[][] f;
	protected int[][] g;

	protected HashMap<String, Integer> qIndex;
	protected HashMap<String, Integer> sIndex;
	protected HashMap<String, Integer> rIndex;

	public Automaton(String[] Q, String[] S, String[] R) {

	}

	public void addTransition(String s, String qInitial, String qEnd) {

	}

	public void addResponse(String s, String q, String response) {

	}

	public Automaton minimizeAutomaton() {
		// TODO: Implementation
		return null;
	}

	public int getIndex(String state) {
		if (qIndex.keySet().contains(state)) {
			return qIndex.get(state);
		} else {
			return -1;
		}
	}

}
