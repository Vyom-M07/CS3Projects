package ScoopyCS3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Scooby {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new File("H:\\GraphsIntroCS3\\src\\ScoopyCS3\\scooby.dat"));
		int testCases = Integer.parseInt(sc.nextLine());


		for (int i = 0; i < 1; i++) {
			HashMap<String, String> map = new HashMap<>(); // data structure to store adjacency map
			String paths = sc.nextLine(); // EF
			String[] pathsArr = paths.split(" ");
			for (String s : pathsArr) {
				
				if (map.get(s) == null ) {
				map.put(s.charAt(0) + "", s.charAt(1) + "");
				map.put(s.charAt(1) + "", s.charAt(0) + "");
				} else  {
					
					
					
				}
				System.out.println(map.toString());
			}
			
		}
			
			
			
			
			
			/*
			String paths = sc.nextLine(); // EF GH IJ FH
	//		String[] pathsArr = paths.split(" "); // [EF, GH, IJ, FH]
			String[] pathWithoutSpace = paths.replaceAll(" ", "").split(""); // [E, F, G, H, I, J, F, H]
//			Queue<String> queue = new LinkedList<>();
//			while (sc.hasNext()) {
//				
//				queue.add(i); // [EF, GH, IJ, FH] 
//				
//			}
			for(String s : pathWithoutSpace) { // for each letter
				
				while (!queue.isEmpty()) { // for each pair
					String t = queue.poll();
					System.out.println(t);
					if ( (t.charAt(0) + "").equals(s) ) { // if the first letter of the pair equals a letter in pathWithoutSpace
						
				//		System.out.println("inside!" + s);
						Queue<String> q = new LinkedList<>(); // new linked list
						q.add(t.charAt(1) + ""); // add the second letter of the pair to indicate a passage
						
						if (map.get(s) == null) { // if there's nothing associated with the letter yet, just add the second letter of pair
						map.put(s, q);
						} else { // else if there's already a list associated with the letter, add the letter onto the list
							map.get(s).add(t.charAt(1) + "");
							map.put(s, map.get(s));
						}
						
					} else if ((t.charAt(1) + "").equals(s) ) {
			//			System.out.println("inside!" + s);
						Queue<String> q = new LinkedList<>();
						q.add(t.charAt(0) + "");
						if (map.get(s) == null) {
							map.put(s, q);
							} else {
								map.get(s).add(t.charAt(0) + "");
								map.put(s, map.get(s));
							}
						
						
					}
					
				}
				
			}
			
			System.out.println(map.toString());
			
			
			

			
	

		
*/		
	}

	public static void dfs(HashMap<String, String> map, String V, String W) {
		Stack<String> stack = new Stack<>();

	}

}
