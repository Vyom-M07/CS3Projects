import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.ClosedDirectoryStreamException;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new File("C:\\Users\\OPBos\\eclipse-workspace\\ShortestPathCS3\\src\\input6.txt"));
		
		int numOfVertex = sc.nextInt();
		int numOfEdges = sc.nextInt();
		
		Vertex[] arr = new Vertex[numOfVertex];
		
		for (int i = 0; i < numOfVertex; i++) {
			
			int id = sc.nextInt();
			int xPos = sc.nextInt();
			int yPos = sc.nextInt();
			
			arr[i] = new Vertex(id, xPos, yPos);
			
			
		}
		
		// System.out.println(Arrays.toString(arr)); <DELETE THIS PRINT STATEMNT WHEN YOURE DONE>
		
		for (int i = 0; i < numOfEdges; i++) {
			
			int vertex1 = sc.nextInt(); // vertex1 will connect to vertex2
			int vertex2 = sc.nextInt();
			
			arr[vertex1].getAdjVertices().add(arr[vertex2]);
			
		}
		
		int sourceIndex = sc.nextInt(); 
		arr[sourceIndex].setDistance(0); // sets the source node to have a distance of 0
		
	//	System.out.println(arr[0].getAdjVertices().toString()); <DELETE THIS PRINT STATEMNT WHEN YOURE DONE>
		
		// by this point all vertex contain a linkedList that has all neighboring verticies that can be visited: set up for problem is done
		
		PriorityQueue<Vertex> q = new PriorityQueue<>();
	//	HashSet<Vertex> visitedVertices = new HashSet<>(); // set to keep track of visited vertices --> set because of O(1) look up time
		int numberVisited = 0;
		
		// System.out.println(distance(new Vertex(0, 3, 4), new Vertex(1, 2, 5))); <DELETE THIS PRINT STATEMNT WHEN YOURE DONE>
		q.offer(arr[sourceIndex]);
		while(numberVisited != arr.length-1) {
			Vertex current = q.poll();
			System.out.println(current + " distance: " + current.getDistance());

		if (!current.isVisited()) {
			for (Vertex v : current.getAdjVertices()) {
				if (!v.isVisited()) {
				double distanceBetween = current.getDistance() + distance(current, v);
				if (distanceBetween < v.getDistance()) {
					v.setDistance(distanceBetween);
					v.setPreviousVertex(current);
				}
				System.out.println("     " + v + " distance: " + v.getDistance());
				q.offer(v);
				}
			}
			current.setVisited(true);
			numberVisited++;
			
			}
		}
		
		int endIndex = sc.nextInt();
		System.out.println("Shortest distance: " + arr[endIndex].getDistance());
		

		Vertex vPath = arr[endIndex];
		String str = "";
		while(vPath != null) {
			str += vPath.getId() + " <- ";
			vPath = vPath.getPreviousVertex();
		}
		System.out.println("Path: " + str.substring(0, str.length()-4));
	}
	
	public static double distance(Vertex origin, Vertex destination) {
		// distance formula
		return Math.sqrt(Math.pow(origin.getX()-destination.getX(), 2) + Math.pow(origin.getY() - destination.getY(), 2));
		
	}

}
