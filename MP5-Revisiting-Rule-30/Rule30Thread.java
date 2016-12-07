
public class Rule30Thread extends Thread {
	
	int min = 0;
	static int maxGene = 0; // for how many generations there will be
	int i = 0;
	int j = 0;
	int initialState;
	
	public Rule30Thread(int min, int maxGen) {
		if(min > maxGen || maxGen < 0 || min < 0) {
			throw new IllegalArgumentException("Invalid Number of Generations!");
		}
		this.min = min;
		maxGene = maxGen;
		initialState = (maxGen / 2) - 1;
	}
	
	public static int[][] generation = new int[maxGene][maxGene];
	// initialize the initial state
	
	public void run() {
		// for the next state
		for(i = min; i < (maxGene - 1); i++) {
			for(j = 0; j < maxGene ; j++){
				if(j == 0){
					if((generation[i][j] == 0) && (generation[i][j+1] == 1)){
						generation[i+1][j] = 1;
					}else if((generation[i][j] == 1) && (generation[i][j+1] == 1)){
		    			generation[i+1][j] = 1;
					}else if((generation[i][j] == 1) && (generation[i][j+1] == 0)){
		    			generation[i+1][j] = 1;
					}
				}else if(j == (maxGene - 1)){
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
			} // end of inner loop
		}
	}
	
	public void display() {
		for(i = 0; i < maxGene; i++){
       		for(j = 0; j < maxGene; j++){
            		System.out.print(generation[i][j]);
        		}
        		System.out.println();
    	}
	}

}
