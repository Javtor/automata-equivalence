package Tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import model.*;

public class Automaton_Test{
	Automaton a1;
	Automaton a2;
	
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