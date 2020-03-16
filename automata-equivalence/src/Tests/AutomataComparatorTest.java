import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import main.java.model.*;

class AutomataComparatorTest {

	MealyAutomaton me1;
	MealyAutomaton me2;
	
	MooreAutomaton mo1;
	MooreAutomaton mo2;
	
	private void setupScenario1() {
		String[] S = new String[] {"0","1"};
		String[] R = new String[] {"0","1"};
		String[] Q1 = new String[] {"A","B","C"};
		String[] Q2 = new String[] {"D","E","F","G","H"};
		
		me1 = new MealyAutomaton(Q1, S, R, "A");
		me2 = new MealyAutomaton(Q2, S, R, "D");
		
		me1.addConection("0", "A", "B", "0");
		me1.addConection("1", "A", "A", "0");
		me1.addConection("0", "B", "A", "0");
		me1.addConection("1", "B", "C", "1");
		me1.addConection("0", "C", "C", "1");
		me1.addConection("1", "C", "A", "0");
		
		me2.addConection("0", "D", "E", "0");
		me2.addConection("1", "D", "D", "0");
		me2.addConection("0", "E", "D", "0");
		me2.addConection("1", "E", "F", "1");
		me2.addConection("0", "F", "F", "1");
		me2.addConection("1", "F", "D", "0");
		me2.addConection("0", "G", "E", "0");
		me2.addConection("1", "G", "H", "1");
		me2.addConection("0", "H", "D", "1");
		me2.addConection("1", "H", "G", "0");
	}
	
	private void setupScenario2() {
		String[] S = new String[] {"c","d"};
		String[] R = new String[] {"0","1"};
		String[] Q1 = new String[] {"A","B","C"};
		String[] Q2 = new String[] {"A","B","C","D"};
		
		mo1 = new MooreAutomaton(Q1, S, R, "A");
		mo2 = new MooreAutomaton(Q2, S, R, "A");
		
		mo1.addResponse("A", "1");
		mo1.addResponse("B", "0");
		mo1.addResponse("C", "0");
		mo1.addTransition("c", "A", "A");
		mo1.addTransition("d", "A", "B");
		mo1.addTransition("c", "B", "C");
		mo1.addTransition("d", "B", "A");
		mo1.addTransition("c", "C", "B");
		mo1.addTransition("d", "C", "C");
		
		mo2.addResponse("A", "1");
		mo2.addResponse("B", "0");
		mo2.addResponse("C", "0");
		mo2.addResponse("D", "0");
		mo2.addTransition("c", "A", "A");
		mo2.addTransition("d", "A", "B");
		mo2.addTransition("c", "B", "C");
		mo2.addTransition("d", "B", "A");
		mo2.addTransition("c", "C", "D");
		mo2.addTransition("d", "C", "C");
		mo2.addTransition("c", "D", "C");
		mo2.addTransition("d", "D", "A");

	}
	private void setupScenario3() {
		String[] S = new String[] {"c","d"};
		String[] R = new String[] {"0","1"};
		String[] Q1 = new String[] {"A","B","C"};
		String[] Q2 = new String[] {"A","B","C","D"};
		
		mo1 = new MooreAutomaton(Q1, S, R, "A");
		mo2 = new MooreAutomaton(Q2, S, R, "A");
		
		mo1.addResponse("A", "1");
		mo1.addResponse("B", "0");
		mo1.addResponse("C", "0");
		mo1.addTransition("c", "A", "A");
		mo1.addTransition("d", "A", "B");
		mo1.addTransition("c", "B", "C");
		mo1.addTransition("d", "B", "A");
		mo1.addTransition("c", "C", "B");
		mo1.addTransition("d", "C", "C");
		
		mo2.addResponse("A", "1");
		mo2.addResponse("B", "1");
		mo2.addResponse("C", "0");
		mo2.addResponse("D", "0");
		mo2.addTransition("c", "A", "A");
		mo2.addTransition("d", "A", "B");
		mo2.addTransition("c", "B", "C");
		mo2.addTransition("d", "B", "A");
		mo2.addTransition("c", "C", "D");
		mo2.addTransition("d", "C", "C");
		mo2.addTransition("c", "D", "C");
		mo2.addTransition("d", "D", "A");

	}
	
	private void setupScenario4() {
		String[] S = new String[] {"0","1"};
		String[] R = new String[] {"0","1"};
		String[] Q1 = new String[] {"A","B","C"};
		String[] Q2 = new String[] {"D","E","F","G","H"};
		
		me1 = new MealyAutomaton(Q1, S, R, "A");
		me2 = new MealyAutomaton(Q2, S, R, "D");
		
		me1.addConection("0", "A", "B", "0");
		me1.addConection("1", "A", "B", "0");
		me1.addConection("0", "B", "A", "0");
		me1.addConection("1", "B", "C", "1");
		me1.addConection("0", "C", "C", "1");
		me1.addConection("1", "C", "A", "0");
		
		me2.addConection("0", "D", "E", "0");
		me2.addConection("1", "D", "D", "0");
		me2.addConection("0", "E", "D", "0");
		me2.addConection("1", "E", "F", "1");
		me2.addConection("0", "F", "F", "1");
		me2.addConection("1", "F", "D", "0");
		me2.addConection("0", "G", "E", "0");
		me2.addConection("1", "G", "H", "1");
		me2.addConection("0", "H", "D", "1");
		me2.addConection("1", "H", "G", "0");
	}
	
	private void setupScenario5() {
		String[] S = new String[] {"0","1"};
		String[] R = new String[] {"0","1"};
		String[] Q1 = new String[] {"A","B","C","D","E","F","G","H","I","J","K"};
		String[] Q2 = new String[] {"A","B","C","D","E","F"};
		
		mo1 = new MooreAutomaton(Q1, S, R, "A");
		mo2 = new MooreAutomaton(Q2, S, R, "A");
		
		mo1.addResponse("A", "0");
		mo1.addResponse("B", "0");
		mo1.addResponse("C", "0");
		mo1.addResponse("D", "0");
		mo1.addResponse("E", "0");
		mo1.addResponse("F", "0");
		mo1.addResponse("G", "0");
		mo1.addResponse("H", "0");
		mo1.addResponse("I", "1");
		mo1.addResponse("J", "0");
		mo1.addResponse("K", "1");
		
		mo1.addTransition("0", "A", "B");
		mo1.addTransition("1", "A", "A");
		mo1.addTransition("0", "B", "C");
		mo1.addTransition("1", "B", "D");
		mo1.addTransition("0", "C", "E");
		mo1.addTransition("1", "C", "C");
		mo1.addTransition("0", "D", "F");
		mo1.addTransition("1", "D", "B");
		mo1.addTransition("0", "E", "G");
		mo1.addTransition("1", "E", "E");
		mo1.addTransition("0", "F", "H");
		mo1.addTransition("1", "F", "F");
		mo1.addTransition("0", "G", "I");
		mo1.addTransition("1", "G", "G");
		mo1.addTransition("0", "H", "J");
		mo1.addTransition("1", "H", "H");
		mo1.addTransition("0", "I", "A");
		mo1.addTransition("1", "I", "K");
		mo1.addTransition("0", "J", "K");
		mo1.addTransition("1", "J", "J");
		mo1.addTransition("0", "K", "A");
		mo1.addTransition("1", "K", "K");
		
		mo2.addResponse("A", "0");
		mo2.addResponse("B", "0");
		mo2.addResponse("C", "0");
		mo2.addResponse("D", "0");
		mo2.addResponse("E", "0");
		mo2.addResponse("F", "1");
		
		mo2.addTransition("0", "A", "B");
		mo2.addTransition("1", "A", "A");
		mo2.addTransition("0", "B", "C");
		mo2.addTransition("1", "B", "B");
		mo2.addTransition("0", "C", "D");
		mo2.addTransition("1", "C", "C");
		mo2.addTransition("0", "D", "E");
		mo2.addTransition("1", "D", "D");
		mo2.addTransition("0", "E", "F");
		mo2.addTransition("1", "E", "E");
		mo2.addTransition("0", "F", "B");
		mo2.addTransition("1", "F", "F");
	}
	
	private void setupScenario6() {
		String[] S = new String[] {"0","1"};
		String[] R = new String[] {"0","1"};
		String[] Q1 = new String[] {"A","B","C","D","E","F","G","H","J"};
		String[] Q2 = new String[] {"U","V","W","X","Y","Z"};
		
		me1 = new MealyAutomaton(Q1, S, R, "A");
		me2 = new MealyAutomaton(Q2, S, R, "U");
		
		me1.addConection("0", "A", "B", "0");
		me1.addConection("1", "A", "C", "0");
		me1.addConection("0", "B", "C", "1");
		me1.addConection("1", "B", "D", "1");
		me1.addConection("0", "C", "D", "0");
		me1.addConection("1", "C", "E", "0");
		me1.addConection("0", "D", "C", "1");
		me1.addConection("1", "D", "B", "1");
		me1.addConection("0", "E", "F", "1");
		me1.addConection("1", "E", "E", "1");
		me1.addConection("0", "F", "G", "0");
		me1.addConection("1", "F", "C", "0");
		me1.addConection("0", "G", "F", "1");
		me1.addConection("1", "G", "G", "1");
		me1.addConection("0", "H", "J", "1");
		me1.addConection("1", "H", "B", "0");
		me1.addConection("0", "J", "H", "1");
		me1.addConection("1", "J", "D", "0");
		
		me2.addConection("0", "U", "X", "0");
		me2.addConection("1", "U", "W", "0");
		me2.addConection("0", "V", "Y", "0");
		me2.addConection("1", "V", "W", "0");
		me2.addConection("0", "W", "X", "0");
		me2.addConection("1", "W", "Y", "0");
		me2.addConection("0", "X", "W", "1");
		me2.addConection("1", "X", "X", "1");
		me2.addConection("0", "Y", "V", "1");
		me2.addConection("1", "Y", "Y", "1");
		me2.addConection("0", "Z", "Z", "1");
		me2.addConection("1", "Z", "X", "0");
	}

	@Test
	void test1Equals() {
		setupScenario1();
		assertTrue(AutomataComparator.equals(me1, me2));
	}
	
	@Test
	void test2Equals() {
		setupScenario1();
		assertTrue(AutomataComparator.equals(me2, me1));
	}
	
	@Test
	void test3Equals() {
		setupScenario2();
		assertTrue(AutomataComparator.equals(mo1, mo2));
	}
	
	@Test
	void test4Equals() {
		setupScenario3();
		assertFalse(AutomataComparator.equals(mo1, mo2));
	}
	
	@Test
	void test5Equals() {
		setupScenario4();
		assertFalse(AutomataComparator.equals(me1, me2));
	}
	
	@Test
	void test6Equals() {
		setupScenario5();
		assertFalse(AutomataComparator.equals(mo1, mo2));
	}
	
	@Test
	void test7Equals() {
		setupScenario6();
		assertTrue(AutomataComparator.equals(me1, me2));
	}

}
