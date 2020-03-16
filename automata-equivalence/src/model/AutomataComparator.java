package model;

public class AutomataComparator {
	
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
		for (int i = 0; i < minA1.length; i++) {
			for (int j = 0; j < sum.S.length; j++) {
				sum.addResponse(sum.S[j], minA1[i]+"", a1.g[minA1[i]][j]+"");
			}
		}
		
		return false;
	}

}
