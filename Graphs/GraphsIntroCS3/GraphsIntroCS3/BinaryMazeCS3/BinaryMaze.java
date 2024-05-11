package BinaryMazeCS3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BinaryMaze {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("C:\\Users\\OPBos\\eclipse-workspace\\GraphIntro\\src\\BinaryMazeCS3\\maze.dat"));
		int r = sc.nextInt();
		int c = sc.nextInt();
		int testCases = sc.nextInt();
		sc.nextLine(); // this is here for token reasons
		
		int[][] arr = new int[r][c];
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				
				arr[i][j] = sc.nextInt(); // fills up the array
				
			}
			sc.nextLine();
			
		}
		
//		System.out.println(Arrays.deepToString(arr));
		
		
		
		
		// chance to testCases when you finish
		for (int i = 0; i < 4; i++) {
			Queue<Location> queue = new LinkedList<>();
			
			int x1 = sc.nextInt(); // row of starting point
			int y1 = sc.nextInt(); // col of startng point
			int x2 = sc.nextInt(); // row of end point
			int y2 = sc.nextInt(); // col of end point;
			
//			System.out.println("(" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
			
			if (arr[x1][y1] == 0 || arr[x2][y2] == 0) { // if initial or end is a non-traversable value
				System.out.println(-1); 
			} else if (x1 == x2 && y1 == y2) {
				System.out.println("0: no need to traverse; same location");
			}

			
			// bfs search
			
			boolean[][] visitedArr = new boolean[r][c];
			
			Location end = new Location(x2, y2, arr[x2][y2], 0);
		    Location initial = new Location(x1, y1, arr[x1][y1], 0);
		    
			System.out.println(bfs(initial, end, queue, arr, visitedArr));
			
			
			
		}
		
		

	}
	
	public static int bfs(Location initial, Location end, Queue<Location> queue, int[][] arr, boolean[][] visitedArr) {
		queue.offer(initial);
	    int count = 0;
	    outerloop:
		while(!queue.isEmpty()) {
			
	//		System.out.println(queue);
			
			Location polled = queue.poll(); // 'Dequeue D' --> from BFS info doc
	//		System.out.println(polled.locationsVistedBefore);
			visitedArr[polled.x][polled.y] = true;// 'Visit D'

			
			// enqueue unenqueued (isVisted == false) nodes adjacent to D.	
		if (polled.x != 0) { // as long as the cell isn't on the top most row
			if (arr[polled.x-1][polled.y] == 1 && visitedArr[polled.x-1][polled.y] == false) { // one UP from polled cell
				Location up = new Location(polled.x-1,polled.y, arr[polled.x-1][polled.y], polled.locationsVistedBefore+1);
		//		visitedArr[polled.x-1][polled.y] = true;
				queue.offer(up);
			}		
		}
		
		if (polled.y != arr[0].length-1) { // as long as the cell isn't on the right most column
			if (arr[polled.x][polled.y+1] == 1 && visitedArr[polled.x][polled.y+1] == false) { // one RIGHT from polled cell
				Location right = new Location(polled.x,polled.y+1, arr[polled.x][polled.y+1], polled.locationsVistedBefore+1);
			//	visitedArr[polled.x][polled.y+1] = true;
				queue.offer(right);
			}	
		}
		if (polled.y != 0) { // as long as the cell isn't on the left most column
			if (arr[polled.x][polled.y-1] == 1 && visitedArr[polled.x][polled.y-1] == false) { // one LEFT from polled cell
				Location left = new Location(polled.x,polled.y-1, arr[polled.x][polled.y-1], polled.locationsVistedBefore+1);
			//	visitedArr[polled.x][polled.y-1] = true;
				queue.offer(left);
			}	
		}
		
		if (polled.x != arr.length-1) { // as long as the cell isn't on the bottom row
			if (arr[polled.x+1][polled.y] == 1 && visitedArr[polled.x+1][polled.y] == false) { // one DOWN from polled cell
				Location down = new Location(polled.x+1,polled.y, arr[polled.x+1][polled.y], polled.locationsVistedBefore+1);
			//	visitedArr[polled.x+1][polled.y] = true;
				queue.offer(down);
			}	
		}
		
		int size = queue.size();
		while(size != 0) {
			Location temp = queue.poll();
			if (temp.equals(end)) {
			//	System.out.println("path found");
				count = temp.locationsVistedBefore;
				break outerloop;
			}
			queue.offer(temp);
		//	System.out.println(queue);
			size--;
		}	
	} 
		
	    return (count != 0) ? count : -1;
	}
	
	
	
	private static class Location {
		

		private int x;
		private int y;
		private int locationsVistedBefore;
		
		public Location(int x, int y, int val, int locationsVisitedBefore) {
			

			this.x = x;
			this.y = y;
			this.locationsVistedBefore = locationsVisitedBefore;

			
		}
		
		
		public boolean equals(Location o) {
			
			return (x == o.x) && (y == o.y);
			
			
		}
		
		@Override
		public String toString() {
			
			return "(" + x + ", " + y + ")";
			
		}
		
	}

}
