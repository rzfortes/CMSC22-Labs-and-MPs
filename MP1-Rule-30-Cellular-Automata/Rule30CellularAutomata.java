// changes were made after failing the test cases in HackerRank and updated .java file

import java.util.Scanner;

public class Rule30CellularAutomata{
	public static void main(String[] args){
		
		int x = 0; // for how many generations there will be
		int i = 0;
		int j = 0;
		int initialState;

		System.out.println("Cellular Automata Rule 30!");
		System.out.println("Enter the number of generations: ");
		
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();

		int[][] generation = new int[x][x];

		// initialize the initial state
		initialState = (x / 2) - 1;
		generation[i][initialState] = 1;

		// initialization for the next state
  		for(i = 0; i < (x - 1); i++){
            		for(j = 0; j < x ; j++){
                		if(j == 0){
                    			if((generation[i][j] == 0) && (generation[i][j+1] == 1)){
                        			generation[i+1][j] = 1;
                    			}else if((generation[i][j] == 1) && (generation[i][j+1] == 1)){
                        			generation[i+1][j] = 1;
                    			}else if((generation[i][j] == 1) && (generation[i][j+1] == 0)){
                        			generation[i+1][j] = 1;
                    			}
                		}else if(j == (x - 1)){
                    			if((generation[i][j-1] == 1) && (generation[i][j] == 0)){
                        			generation[i+1][j] = 1;
                    			}else if((generation[i][j-1] == 0) && (generation[i][j] == 1)){
                        			generation[i+1][j] = 1;
                    			}
                		}else{
                    			if((generation[i][j-1] == 1) && (generation[i][j] == 0) && (generation[i][j+1] == 0)){
                        			generation[i+1][j] = 1;
                    			}else if((generation[i][j-1] == 0) && (generation[i][j] == 1) && (generation[i][j+1] == 1)){
                        			generation[i+1][j] = 1;
                    			}else if((generation[i][j-1] == 0) && (generation[i][j] == 1) && (generation[i][j+1] == 0)){
                        			generation[i+1][j] = 1;
                    			}else if((generation[i][j-1] == 0) && (generation[i][j] == 0) && (generation[i][j+1] == 1)){
                        			generation[i+1][j] = 1;
                    			}
                		}
            		}
        	}
        
        	for(i = 0; i < x; i++){
           		for(j = 0; j < x; j++){
                		System.out.print(generation[i][j]);
            		}
            		System.out.println();
        	}
 
	}
}
