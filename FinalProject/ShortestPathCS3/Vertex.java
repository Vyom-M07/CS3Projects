import java.util.LinkedList;

public class Vertex implements Comparable<Vertex>{

	private int x;
	private int y;
	private int id;
	private boolean visited; // whether this vertex has been visited or not
	private double distance = Double.POSITIVE_INFINITY; // distance from source node
	
	private LinkedList<Vertex> adjVertices;
	

	private Vertex previousVertex;
	
	
	// should contain a neighboring verticies
	


	Vertex(int id, int x, int y) {
		
		this.id = id;
		this.x = x;
		this.y = y;
		adjVertices = new LinkedList<>();
		
	}
	
	@Override
	public int compareTo(Vertex o) {
		// will prioritize verticies (based on shortest distance) when implementing PriorityQueue
		if (this.distance > o.distance) {
			return 1;
		} else if (this.distance < o.distance) {
			return -1;
		}
		
		return 0;
	}
	
	public boolean isVisited() {
		return visited;
	}


	public void setVisited(boolean visited) {
		this.visited = visited;
	}


	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	public int getId() {
		return id;
	}
	
	public LinkedList<Vertex> getAdjVertices() {
		return adjVertices;
	}
	public Vertex getPreviousVertex() {
		return previousVertex;
	}


	public void setPreviousVertex(Vertex previousVertex) {
		this.previousVertex = previousVertex;
	}
	
	@Override
	public String toString() {
		
		return "ID: " + id + " " + "(" + x + "," + y + ")";
		
	}
	
	

}
