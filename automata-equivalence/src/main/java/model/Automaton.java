package main.java.model;

import java.util.*;

//TODO: Doc
/**
 * 
 * @author Javier Torres
 * @author Nelson Quiñones
 *
 */
public abstract class Automaton {

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
	/**
	 * Transitions
	 */
	protected int[][] f;
	/**
	 * Responses
	 */
	protected int[][] g;

	protected HashMap<String, Integer> qIndex;
	protected HashMap<String, Integer> sIndex;
	protected HashMap<String, Integer> rIndex;
	
	/**
	 * Map to relate a state to an identificator for union F¿find
	 */
	protected HashMap<String, Integer> identificatorIndex;

	public Automaton(String[] Q, String[] S, String[] R, String initialState) {
		this.Q = Q;
		this.S = S;
		this.R = R;
		
		qIndex = new HashMap<>();
		sIndex = new HashMap<>();
		rIndex = new HashMap<>();
		
		for (int i = 0; i < Q.length; i++) {
			qIndex.put(Q[i], i);
		}
		for (int i = 0; i < R.length; i++) {
			rIndex.put(R[i], i);
		}
		for (int i = 0; i < S.length; i++) {
			sIndex.put(S[i], i);
		}
		f = new int[Q.length][S.length];
		g = new int[Q.length][S.length];
		for (int i = 0; i < f.length; i++) {
			for (int j = 0; j < f[i].length; j++) {
				f[i][j] = -1;
				g[i][j] = -1;
			}
		}
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
			f[indQI][indS] = indQE;

		} catch (IndexOutOfBoundsException e) {
			success = false;
		}
		return success;
	}
	
	
	protected boolean addResponse(String s, String q, String r) {
		boolean success = true;

		int indS = getIndexStimulus(s);
		int indQ = getIndexState(q);
		int indR = getIndexResponse(r);

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
	
	/**
	 * Performs the partition refinement algorithm
	 * @return A Disjoint Set with the partitions
	 */
	public UnionFind getMinimizedDS() {
		UnionFind uf = new UnionFind(Q.length);
		
		for (int i = 0; i < Q.length; i++) {
			for (int j = i+1; j < Q.length; j++) {
				if(Arrays.equals(g[i], g[j])) {
					uf.union(i, j);
				}
			}
		}
		
		int[] pPrev = uf.parent;
		boolean cont = true;
		while(cont) {
			UnionFind uf2 = new UnionFind(Q.length);
			for (int i = 0; i < Q.length; i++) {
				for (int j = i+1; j < Q.length; j++) {
					boolean union = uf.connected(i, j);
					for (int k = 0; k < S.length; k++) {
						union = union && uf.connected(f[i][k], f[j][k]);
					}
					if(union) {
						uf2.union(i, j);
					}
				}
			}
			uf = uf2;
			if(Arrays.equals(uf2.parent, pPrev)) {
				cont = false;
			} else {
				pPrev = uf2.parent;
			}
		}
		return uf;

	}
	
	public int[] getAccessibleStates() {
		boolean visited[] = new boolean[Q.length]; 
		  
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        int s = initialState;
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            s = queue.poll();          
            for (int n : f[s]) 
            { 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
        ArrayList<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i < visited.length; i++) {
			if(visited[i])
				integers.add(i);
		}
        
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
	}
	
	//Debería tirar una excepción diciendo que no se puede hacer
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
	
	public int[][] getF() {
		return f;
	}

	public void setF(int[][] f) {
		this.f = f;
	}

	public int[][] getG() {
		return g;
	}

	public void setG(int[][] g) {
		this.g = g;
	}

	public String[] getQ() {
		return Q;
	}

	public void setQ(String[] q) {
		Q = q;
	}
	
	

}
