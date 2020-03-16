package model;

public class MealyAutomaton extends Automaton{
	
	public MealyAutomaton(String[] Q, String[] S, String[] R, String initialState) {
		super(Q, S, R, initialState);
		// TODO Auto-generated constructor stub
	}

	public boolean addResponse(String s, String q, String r) {
		return super.addResponse(s, q, r);
	}

}
