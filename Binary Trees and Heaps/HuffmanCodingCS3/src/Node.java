
public class Node implements Comparable<Node>{
	
	
	Node right;
	Node left;
	private int frequency;
	private char val;
	
	
	@Override
	public int compareTo(Node o) {
		
		if (frequency < o.frequency) {
			return -1;
		} else if (frequency > o.frequency) {
			return 1;
		}
		return 0;
	}
	
	// for leaf nodes
	public Node(char val, int frequency) {
		
		
		this.val = val;
		this.frequency = frequency;
		
		
	}
	
	// For Integer Nodes that track frquency
	// This node's frequency will be made up of the sum of all sub-trees of this node
	public Node(int frequencyTotal) {
		
		this.val = '\0'; // default value for chars, sometimes called the null character
		this.frequency = frequencyTotal;
		right = null;
		left = null;
		
	}
	
	public String toString() {
		
		return val + "(" + frequency + ")";
		
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public char getVal() {
		return val;
	}

	public void setVal(char val) {
		this.val = val;
	}
	
	
	
}
