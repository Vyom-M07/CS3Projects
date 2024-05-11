

public class GemList {
	
	private int size;
	private int score;
	private Node head;
	
	
	
	public int size() {
		
		return size;
	}
	
	public void draw(double y) {
		// Need to work on
		
		Node iter = head;
		int indexCounter = 0;
		while(iter != null) {
			iter.gem.draw(GemGame.indexToX(indexCounter), y);
			indexCounter++;
			iter = iter.next;
		}
		
		
	}
	
	@Override
	public String toString() {
		
		if (head == null) {
			return "[none]";
		}
		String s = "[";

		Node temp = head;

		while (temp != null) {
			s += temp.gem + ", ";
			temp = temp.next;
		}

		return s.substring(0, s.length() - 2) + "]";
	}
	
	void insertBefore(Gem gem, int index ) {
		
		if (index >= size)  // so if index is 200, and the size is at 10, index will just be set to 10. 
			index = size;
		if (size == 0) {
			head = new Node(gem);
			size++;
			return;
		}
		if (index == 0) {
			Node newHead = new Node(gem);
			newHead.next = head;
			head = newHead;
			size++;
			return;
		}
		if (index <= size) {
			
			Node pred = head;
			int counter = 0;
			while (counter != index -1) {
				counter++;
				pred = pred.next;
			}
			// after while loop, temp is the node at 'index-1'
			Node newNode = new Node(gem);
			newNode.next = pred.next;
			pred.next = newNode;
			
		}
		
		size++;
	}
	
	int score() {
		// score =  total score of the player
		// int multiplier = the number of consecutive of the same gem type (is 1 by default)
		// int subScore = the added up values of the consecutive gem Types (EX: 10 + 5 + 30 + 20)
		
		// first try to figure out score without multipliers, then worry about it later
		score = 0;
		int subScore = 0;
		int multiplier = 1; // multiply subScore by multiplier for accurate score
		Node iter = head;
		while (iter != null) {
			subScore += iter.gem.getPoints();
			while (iter.next != null && iter.next.gem.getType() == iter.gem.getType()) {
				
				multiplier++;
				iter = iter.next;
				subScore += iter.gem.getPoints();
			} 
				score += subScore * multiplier;
				subScore = 0;
				multiplier = 1;
				
			

			iter = iter.next;
		}
		
		
		return score;
	}
	
	private class Node {
		// Each Node represents a Gem
		private Gem gem;
		private Node next;
		
		public Node(Gem gem) {
			this.gem = gem;
		}
		
		@Override
		public String toString() {
			return "" + this.gem;
		}
	}
	
	
	
	
	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);		
		
		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);
		
		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);
		
		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);
		
		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);
		
		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);
		
		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);		
	}	
}
