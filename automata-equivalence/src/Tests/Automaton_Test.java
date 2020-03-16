

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.java.model.*;


public class Automaton_Test{
	MealyAutomaton a1;
	MealyAutomaton a2;
	MooreAutomaton M;
	
	public void scene_1() {
		String[] Q = {"A","B","C","D","F"};
		String[] R = {"0","1"};
		String[] S = {"0","1"};
		String iS = "C";
		
		a1 = new MealyAutomaton(Q,S,R,iS);
		for (int i = 0; i < 10; i++) {
			int s = (int)(Math.random()*2);
			int qi = (int)(Math.random()*4);
			int qe = (int)(Math.random()*4);
			int r = (int)(Math.random()*2);
			System.out.println("S = "+S[s]+"  Qi = "+Q[qi]+"  Qe = "+Q[qe]+"  R = "+R[r]+"  result = "+a1.addConection(S[s], Q[qi], Q[qe],R[r]));
		}
	}
	
	public void scene_2() {
		String[] Q = {"A","B","C","D","F"};
		String[] R = {"a","b","c"};
		String[] S = {"0","1"};
		String iS = "C";
		
		a1 = new MealyAutomaton(Q,S,R,iS);
		for (int i = 0; i < 10; i++) {
			int s = (int)(Math.random()*2);
			int qi = (int)(Math.random()*4);
			int qe = (int)(Math.random()*4);
			int r = (int)(Math.random()*3);
			System.out.println("S = "+S[s]+"  Qi = "+Q[qi]+"  Qe = "+Q[qe]+"  R = "+R[r]+"  result = "+a1.addConection(S[s], Q[qi], Q[qe],R[r]));
		}
		
		a2 = new MealyAutomaton(Q,S,R,iS);
		for (int i = 0; i < 10; i++) {
			int s = (int)(Math.random()*2);
			int qi = (int)(Math.random()*4);
			int qe = (int)(Math.random()*4);
			int r = (int)(Math.random()*3);
			System.out.println("S = "+S[s]+"  Qi = "+Q[qi]+"  Qe = "+Q[qe]+"  R = "+R[r]+"  result = "+a2.addConection(S[s], Q[qi], Q[qe],R[r]));
		}
	}
	
	//Quiz 1
	public void scene_3() {
		String[] Q = {"A","B","C","D","E","F"};
		String[] R = {"0","1"};
		String[] S = {"0","1"};
		String iS = "A";
		
		M = new MooreAutomaton(Q,S,R,iS);
		M.addResponse("A","0");
		M.addResponse("B","0");
		M.addResponse("C","1");
		M.addResponse("D","1");
		M.addResponse("E","1");
		M.addResponse("F","0");
		
		M.addTransition("0", "A", "B");
		M.addTransition("1", "A", "C");
		M.addTransition("0", "B", "A");
		M.addTransition("1", "B", "D");
		M.addTransition("0", "C", "E");
		M.addTransition("1", "C", "F");
		M.addTransition("0", "D", "E");
		M.addTransition("1", "D", "F");
		M.addTransition("0", "E", "E");
		M.addTransition("1", "E", "F");
		M.addTransition("0", "F", "E");
		M.addTransition("1", "F", "F");
		
	}
	
	@Test
	public void testMinimizedDS() {
		scene_3();
		int[] minimized = M.getMinimizedDS().parent;
		assertTrue(Arrays.equals(minimized, new int[] {0,0,2,2,2,5}));
	}
	
    @Test
    public void checkAutomataConstruction_1(){
        scene_1();
        int f[][] = a1.getF();
        int g[][] = a1.getG();
        System.out.println("\nF");
        for (int i = 0; i < f.length; i++) {
			for(int j = 0; j<f[i].length; j++) {
				System.out.print(f[i][j]+" ");
			}
			System.out.println("");
		}
        
        System.out.println("\n G");
        for (int i = 0; i < g.length; i++) {
			for(int j = 0; j<g[i].length; j++) {
				System.out.print(g[i][j]+" ");
			}
			System.out.println("");
		}
    }
    
    @Test
    public void checkAutomataConstruction_2(){
        scene_2();
        int f [][] = a1.getF();
        int g[][] = a1.getG();
        System.out.println("\n F1");
        for (int i = 0; i < f.length; i++) {
			for(int j = 0; j<f[i].length; j++) {
				System.out.print(f[i][j]+" ");
			}
			System.out.println("");
		}
        
        System.out.println("\n G1");
        for (int i = 0; i < g.length; i++) {
			for(int j = 0; j<g[i].length; j++) {
				System.out.print(g[i][j]+" ");
			}
			System.out.println("");
		}
        f = a2.getF();
        g = a2.getG();
        
        System.out.println("\n F2");
        for (int i = 0; i < f.length; i++) {
			for(int j = 0; j<f[i].length; j++) {
				System.out.print(f[i][j]+" ");
			}
			System.out.println("");
		}
        
        System.out.println("\n G2");
        for (int i = 0; i < g.length; i++) {
			for(int j = 0; j<g[i].length; j++) {
				System.out.print(g[i][j]+" ");
			}
			System.out.println("");
		}
    }
    
    @Test
    public void creatUnionFind1(){
        scene_1();
        
    }
}