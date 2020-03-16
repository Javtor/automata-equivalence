package main.java.model;

import java.util.HashSet;

public class AutomataComparator {
	
	/**
	 * Finds if two automata are equivalent
	 * @param a1 The first automaton
	 * @param a2 The second automaton
	 * @return true iff the two automata are equivalent
	 */
	public static boolean equals(Automaton a1, Automaton a2) {
		
		// Accessible states
		int[] minA1 = a1.getAccessibleStates();
		int[] minA2 = a2.getAccessibleStates();
		
		// Direct sum + renaming
		String[] newQ = new String[minA1.length+minA2.length];
		for (int i = 0; i < minA1.length; i++) {
			newQ[i] = minA1[i]+"";
		}	
		for (int i = 0; i < minA2.length; i++) {
			newQ[i+minA1.length] = (minA2[i]+a1.Q.length)+"";
		}	
		
		Automaton sum = new MealyAutomaton(newQ,a1.S,a1.R,"0");
		for (int i = 0; i < minA1.length; i++) {
			for (int j = 0; j < sum.S.length; j++) {
				sum.addResponse(sum.S[j], minA1[i]+"", a1.g[minA1[i]][j]+"");
				sum.addTransition(sum.S[j], minA1[i]+"", a1.f[minA1[i]][j]+"");
			}
		}
		for (int i = 0; i < minA2.length; i++) {
			for (int j = 0; j < sum.S.length; j++) {
				sum.addResponse(sum.S[j], (minA2[i]+a1.Q.length)+"", (a2.g[minA2[i]][j]+""));
				sum.addTransition(sum.S[j], (minA2[i]+a1.Q.length)+"", (a2.f[minA2[i]][j]+a1.Q.length)+"");
			}
		}
		
		//Algorithm
		UnionFind ds = sum.getMinimizedDS();
		int[] finalPartition = ds.parent;
		
		//Are the initial states connected?
		boolean ini = ds.connected(a1.initialState, a2.initialState);
		
		//Checks if every block contains at least one element of each automaton
		HashSet<Integer> blocks1 = new HashSet<Integer>();
		for (int i = 0; i < minA1.length; i++) {
			blocks1.add(finalPartition[i]);
		}
		
		HashSet<Integer> blocks2 = new HashSet<Integer>();
		for (int i = minA1.length; i < finalPartition.length; i++) {
			blocks2.add(finalPartition[i]);
		}
		
		boolean contains = blocks1.equals(blocks2);
		
		return ini && contains;
	}

}
