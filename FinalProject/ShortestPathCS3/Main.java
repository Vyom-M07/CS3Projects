import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new File("C:\\Users\\OPBos\\eclipse-workspace\\ShortestPathCS3\\src\\input6.txt"));
		
		int numOfVertex = sc.nextInt();
		int numOfEdges = sc.nextInt();
		
		Vertex[] arr = new Vertex[numOfVertex]; // A vertex is essentially a LinkedList. This would make this an AdjacencyList
		
		for (int i = 0; i < numOfVertex; i++) {
			
			int id = sc.nextInt();
			int xPos = sc.nextInt();
			int yPos = sc.nextInt();
			
			arr[i] = new Vertex(id, xPos, yPos); // Filling up AdjList (arr) with all the vertices given in the problem
			
			
		}
				
		for (int i = 0; i < numOfEdges; i++) {
			
			int vertex1 = sc.nextInt();
			int vertex2 = sc.nextInt();
			
			arr[vertex1].getAdjVertices().add(arr[vertex2]); // vertex1 will create a connection to vertex2
			
		}
		
		int sourceIndex = sc.nextInt();
		Vertex sourceVertex = arr[sourceIndex];
		sourceVertex.setDistance(0); // sets the source node to have a distance of 0 as per Dijstra's Algorithm
				
		// by this point all vertex contain a linkedList that has all neighboring verticies that can be visited- set up for problem is done
		
		
		// Dijstra's Algorithm:
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		int numberVisited = 0; // way of keeping track of how many Vertices we have visited- if this number reaches the length of the AdjList, 
							   //  we will have visited all Vertices and can stop our algorithm
		
		q.offer(sourceVertex); // offers the Source Vertex
		while(numberVisited != arr.length) {
			Vertex current = q.poll();
	if (current != null) {
		if (!current.isVisited()) {
			for (Vertex v : current.getAdjVertices()) {
				if (!v.isVisited()) {
				double distanceBetween = current.getDistance() + distance(current, v);
				if (distanceBetween < v.getDistance()) {
					v.setDistance(distanceBetween); // if new distance is shorter than old, replace it with new- this will reflect shortest path
					v.setPreviousVertex(current); // essentially a backwards LinkedList which keeps track of the shortest path from source to end
				}
				q.offer(v);
				}
			}
			current.setVisited(true);
			numberVisited++;
				}		
			}
		}
		
		int endIndex = sc.nextInt();
		Vertex endVertex = arr[endIndex];
		System.out.println("Shortest distance from source vertex " + sourceVertex.getId() + " to end vertex " + endVertex.getId() + " is: "
				+ endVertex.getDistance());
		

		String str = "";
		while(endVertex != null) {
			str += endVertex.getId() + " <- ";
			endVertex = endVertex.getPreviousVertex();
		}
		System.out.println("Path: " + str.substring(0, str.length()-4));
	}
	
	public static double distance(Vertex origin, Vertex destination) {
		// distance formula
		return Math.sqrt(Math.pow(origin.getX()-destination.getX(), 2) + Math.pow(origin.getY() - destination.getY(), 2));
		
	}

}
