
public class MyBST {
	
	private BSTNode root;
	private int size;
	
	private class BSTNode {
		
		Integer val;
		BSTNode left;
		BSTNode right;
		
		public BSTNode(Integer val) {
			this.val = val;
			left = null;
			right = null;
		}
		
		@Override
		public String toString() {
			
			return "" + this.val;
			
		}
		
	}
	
	public int size() {
		// just increment and decrement each time something is inserted or deleted
		return size;
	}
	
	public void insert(Integer n) {
		size++;
		root = insertHelper(root, new BSTNode(n));
	}
	
	private BSTNode insertHelper(BSTNode root, BSTNode newNode) {
		
		if (root == null) {
			return newNode;
		} else if(newNode.val > root.val) {
			root.right = insertHelper(root.right, newNode);
		} else if (newNode.val < root.val) { 
			root.left = insertHelper(root.left, newNode);
		}
			
		return root;
	}
	
	public boolean contains(Integer n) {
		
		return containsHelper(root, n);
		
	}

	private boolean containsHelper(BSTNode root, int n) {
		
		if (root == null) {
			return false;
		} else if (root.val == n) {
			return true;
		} else if (n > root.val) { 
			return containsHelper(root.right, n);
		} else {
			return containsHelper(root.left, n);
		}
		
	
	}

	public Integer getMax() {
		
		return getMaxHelper(root);
		
	}

	private Integer getMaxHelper(BSTNode root) {
		
		if (root == null) {
			System.out.println("No nodes in this tree!");
			return null;
		} else {
			while (root.right != null) {
				root = root.right;
			}
		}
		return root.val;
		
	}
	
	public Integer getMin() {
		
		return getMinHelper(root);
	}

	private Integer getMinHelper(BSTNode root) {

		
		if (root == null) {
			System.out.println("No nodes in this tree!");
			return null;
		} else {
			while (root.left != null) {
				root = root.left;
			}
		}
		return root.val;
		
	}
	
	public void delete(Integer n) {
		size--;
		deleteHelper(root, n);
		
	}
	
	private BSTNode deleteHelper(BSTNode root, Integer n) {
		
		if (root == null || !contains(root.val)) { // if theres no nodes in the tree or the node doesn't exist in the tree
			return root;
		} else if (n > root.val) { // finds the node
			root.right = deleteHelper(root.right, n); 
		} else if (n < root.val) { // finds the node
			root.left = deleteHelper(root.left, n);
		} else { 
			// if leaf node
			if (root.left == null && root.right == null) {
				root = null;
			}
			// if there is a child
			else if (root.right != null) {
				// roots new value will be set to it's child value --> then delete the child
				root.val = successor(root);
				root.right = deleteHelper(root.right, root.val);
			} else {
				root.val = predecessor(root);
				root.left = deleteHelper(root.left, root.val);
			}
			
		}
	
		return root;
	}
	
	public void inOrder() { 
		// ascending order print (in-order)
		inOrderHelper(root);
	}
	
	private void inOrderHelper(BSTNode root) {
		
		if (root != null) {
			inOrderHelper(root.left);
			System.out.print(root.val + " ");
			inOrderHelper(root.right);
		}
	}
	
	public void print() {
		// print in descending order (greatest to least)
		// NEED TO FIGURE OUT INDENT --	> finish
		printHelper(root, 0);
		
	}
	
	private void printHelper(BSTNode root, int count) {

		// FINISH
		if (root == null) {
			return;
		}
		
		
			printHelper(root.right, count+1);
			System.out.println( "\t".repeat(count) +root.val);
			printHelper(root.left, count+1);
		
		
	}
	
	
	
	// find lowest val from the right child of root node
	private int successor(BSTNode root) {
		
		int nodeVal = getMinHelper(root.right);
		
		return nodeVal;
		
	}
	
	// find greatest val from left child 
	private int predecessor(BSTNode root) {
	
		int nodeVal = getMaxHelper(root.left);
		return nodeVal;
	}
}


