package ChildsPlay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Play {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("C:\\Users\\OPBos\\eclipse-workspace\\GraphIntro\\src\\ChildsPlay\\play.dat"));

    	int testCases = Integer.parseInt(sc.nextLine());
 
    	for (int i = 0; i < testCases; i++) { // change 1 to testCases at the end
    		System.out.println("Test Number: " + (i+1));
    	   	int count = 0;
    		int n = sc.nextInt(); // the number of domino tiles
    		
    		int m = sc.nextInt(); // Each of the 'm' lines after the first line 
    							  // contains two integers x and y indicating that if domino number x falls, 
    							  // it will cause domino number y to fall as well.
    		
    		int l = sc.nextInt(); // the following l lines contains a single integer z indicating that the domino numbered z is knocked over by hand
    		
    		@SuppressWarnings("unchecked")
			LinkedList<Integer>[] arr = new LinkedList[n+1]; // n + 1 because index[0] is never used and this need one more space for last element
    		
    		sc.nextLine(); // need for token issue
    		for (int j = 0; j < m; j++) {
    	//		System.out.print(sc.next() + " "); // points x, y
    			// index will represent domino and the numbers contained in the list at the index represent the dominos the index knocks over
    			// this does mean that 'index = 0' will always be 0
    			int index = Integer.parseInt(sc.next());
    			if (arr[index] == null) {
    				arr[index] = new LinkedList<Integer>();
    			}
    			int dominoToAdd = Integer.parseInt(sc.next());
    			arr[index].add(dominoToAdd);
    			
    		}
    //		System.out.println(Arrays.deepToString(arr));
    		sc.nextLine(); // need for token issue
    		
    		for (int k = 0; k < l; k++) {
    			
    			int initalDominoKnocked = Integer.parseInt(sc.nextLine()); // first domino that gets knocked over
    			count += countKnocked(arr, initalDominoKnocked) + 1; // starts with l counter bc initial domino is knocked
    			System.out.println(count);
    			arr[initalDominoKnocked] = null;
    			
        	}
    		System.out.println(count);
    		System.out.println();
    	}
		
    	
		
		
	}
	
	public static int countKnocked(LinkedList[] arr, int initalDominoKnocked) {
		
		@SuppressWarnings("unchecked")
		LinkedList<Integer> L = arr[initalDominoKnocked];
		int count = 0;
	//	System.out.println("init: " + initalDominoKnocked);
	
		
		if (L == null) {
	//		System.out.println("im isnide 1");
			return 0;
		}
		
		for (Integer i : L) {
	//		System.out.println(L.toString());
	//		System.out.println("im isnide 2");
			count += countKnocked(arr, i) + 1;
			
		}
		return count;
		
	}

}
