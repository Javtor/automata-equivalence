package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import model.*;

class AutomataComparatorTest {

	Automaton m1;
	Automaton m2;
	
	private void setupScenario1() {
		String[] S = new String[] {"0","1"};
		String[] R = new String[] {"0","1"};
		String[] Q1 = new String[] {"A","B","C"};
		String[] Q2 = new String[] {"D","E","F","G","H"};
		
		m1 = new MealyAutomaton(Q1, S, R, "A");
		m2 = new MealyAutomaton(Q2, S, R, "D");
		
		m1.addConection("0", "A", "B", "0");
		m1.addConection("1", "A", "A", "0");
		m1.addConection("0", "B", "A", "0");
		m1.addConection("1", "B", "C", "1");
		m1.addConection("0", "C", "C", "1");
		m1.addConection("1", "C", "A", "0");
		
		m2.addConection("0", "D", "E", "0");
		m2.addConection("1", "D", "D", "0");
		m2.addConection("0", "E", "D", "0");
		m2.addConection("1", "E", "F", "1");
		m2.addConection("0", "F", "F", "1");
		m2.addConection("1", "F", "D", "0");
		m2.addConection("0", "G", "E", "0");
		m2.addConection("1", "G", "H", "1");
		m2.addConection("0", "H", "D", "1");
		m2.addConection("1", "H", "G", "0");
	}

	@Test
	void test1Equals() {
		setupScenario1();
		assertTrue(AutomataComparator.equals(m1, m2));
	}
	
	@Test
	void test2Equals() {
		setupScenario1();
		assertTrue(AutomataComparator.equals(m2, m1));
	}

}
