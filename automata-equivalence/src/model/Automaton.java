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

	public Automaton(String[] Q, String[] S, String[] R, String initialState) {
		for (int i = 0; i < Q.length; i++) {
			qIndex.put(Q[i], i);
		}
		for (int i = 0; i < R.length; i++) {
			qIndex.put(R[i], i);
		}
		for (int i = 0; i < S.length; i++) {
			qIndex.put(S[i], i);
		}
		f = new int[Q.length][S.length];
		g = new int[Q.length][S.length];
		this.initialState = getIndexState(initialState);

	}

	public boolean addTransition(String s, String qInitial, String qEnd) {
		boolean success = true;

		int indS = getIndexStimulus(s);
		int indQI = getIndexState(qInitial);
		int indQE = getIndexState(qEnd);

		try {
			if (indQE == -1) {
				throw new IndexOutOfBoundsException();
			}
			g[indQI][indS] = indQE;

		} catch (IndexOutOfBoundsException e) {
			success = false;
		}
		return success;
	}

	public boolean addResponse(String s, String q, String r) {
		boolean success = true;

		int indS = getIndexStimulus(s);
		int indQ = getIndexState(q);
		int indR = getIndexState(r);

		try {
			if (indR == -1) {
				throw new IndexOutOfBoundsException();
			}
			g[indQ][indS] = indR;

		} catch (IndexOutOfBoundsException e) {
			success = false;
		}
		return success;

	}

	public Automaton minimizeAutomaton() {
		UnionFind uf = getMinimizedDS();
		return null;
	}
	
	public UnionFind getMinimizedDS() {
		return null;
	}

	public int getIndexState(String state) {
		if (qIndex.keySet().contains(state)) {
			return qIndex.get(state);
		} else {
			return -1;
		}
	}

	public int getIndexStimulus(String stimulus) {
		if (sIndex.keySet().contains(stimulus)) {
			return sIndex.get(stimulus);
		} else {
			return -1;
		}
	}

	public int getIndexResponse(String response) {
		if (rIndex.keySet().contains(response)) {
			return rIndex.get(response);
		} else {
			return -1;
		}
	}

}
