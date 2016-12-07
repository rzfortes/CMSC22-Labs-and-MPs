/*
 * Most of the variable names and function names and their implementations are based on the source codes provided
 * during lecture of Concurrency 
 * 
 * -- CountDivisorThread.java && CountDivisorTester2.java
 */

import java.util.Scanner;

public class Rule30CellularAutomataTester{
	
	public static final int THREAD_COUNT = 10;

	@SuppressWarnings("resource")
	public static void main(String[] args){
		
		//int maxGen = 0; // for how many generations there will be

		System.out.println("Cellular Automata Rule 30!");
		System.out.println("Enter the number of generations: ");
		
		Scanner sc = new Scanner(System.in);
		int maxGen = sc.nextInt();
		
		long startTime = System.currentTimeMillis();
		
		// 10 rule30thread
		Rule30Thread[] worker = new Rule30Thread[THREAD_COUNT];
		int generationsPerThread = maxGen / THREAD_COUNT;
		int min = 0;
		int max = min + generationsPerThread - 1;
		
		// initializing of tasks
		for(int i = 0; i < THREAD_COUNT; i++) {
			if(i == (THREAD_COUNT - 1)) {
				max = maxGen -1;
			}
			worker[i] = new Rule30Thread(min, max);
			min = max + 1;
			max = min + generationsPerThread - 1;
		}
		
		// get the workers working!
		for(int i = 0; i < THREAD_COUNT; i++) {
			worker[i].start();
		}
		
		// wait until workers die
		for(int i = 0; i < THREAD_COUNT; i++) {
			while(worker[i].isAlive()) {
				try {
					worker[i].join();
				} catch (InterruptedException e) {
					System.err.println("thread interrupted: " + e.getMessage());
				}
			}
		}
		
		System.out.println("time consumed in ms: " + (System.currentTimeMillis() - startTime));
		
 
	}
}