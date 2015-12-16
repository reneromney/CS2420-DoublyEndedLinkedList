package assign6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Timing {

	public static void main(String[] args) {

		// Do 10000 lookups and use the average running time.
		int timesToLoop = 1000;

		// For each problem size n . . .
		for (int n = 1000; n <= 20000; n += 1000) {
			// Setup of n size for testing
			long startTime, midpointTime, stopTime;

			LinkedList<Integer> test = new LinkedList<Integer>();
			Random rng = new Random(n);
			for (int i = 0; i < n; i++) {
				test.addFirst(rng.nextInt(n));
			}
			
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Now, run the test.
			startTime = System.nanoTime();

			// Run the methods for testing
			for (int i = 0; i < timesToLoop; i++) {
				test.remove(n/2);
				test.addFirst(rng.nextInt(n));
			}

			midpointTime = System.nanoTime();

			// Time it takes to run loop
			for (int i = 0; i < timesToLoop; i++) {
				test.addFirst(rng.nextInt(n));
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and doing the lookups.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / timesToLoop;

			System.out.println(averageTime);

		}

	}

}
