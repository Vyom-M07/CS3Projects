import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A class used to print a binary tree of integers, for testing purposes
 * 
 * Borrowed from StackOverflow with minor modifications
 * 
 * To use, call the printNode() method, supplying your tree's overall root.  Example:
 * 
 *    TreePrinter.printNode(tree.getRoot());
 *    
 * where tree is an object of your TreeMethods class, which has a getRoot() method
 */
public class TreePrinter 
{
	/** 
	 * print the tree in a tree-like form
	 * @param root the overall root of the tree
	 */
	public static void printTree(Node root) {
		int maxLevel = TreePrinter.maxLevel(root);

		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || TreePrinter.isAllElementsNull(nodes))
			return;

		int floor         = maxLevel - level;
		int endgeLines    = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces   = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) (Math.pow(2, (floor + 1)) - 1)/2;

		TreePrinter.printWhitespaces(firstSpaces);

		List<Node> newNodes = new ArrayList<>();
		for (Node node : nodes) {
			if (node != null) {
				System.out.print(node);
				newNodes.add(node.left);
				newNodes.add(node.right);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}

			TreePrinter.printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				TreePrinter.printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					TreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}

				if (nodes.get(j).left != null)
					System.out.print("/");
				else
					TreePrinter.printWhitespaces(1);

				TreePrinter.printWhitespaces(i + i - 1);

				if (nodes.get(j).right != null)
					System.out.print("\\");
				else
					TreePrinter.printWhitespaces(1);

				TreePrinter.printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println("");
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static int maxLevel(Node node) {
		if (node == null)
			return 0;

		return Math.max(TreePrinter.maxLevel(node.left), TreePrinter.maxLevel(node.right)) + 1;
	}

	@SuppressWarnings("rawtypes")
	private static boolean isAllElementsNull(List list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}

		return true;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
/*		BitOutputStream b = new BitOutputStream("C:\\Users\\OPBos\\eclipse-workspace\\HuffmanCodingCS3\\src\\happy hip hop.txt");
		
		b.writeBit(1); // 1 ascii value of '!' is 33 which in binary is 100001
		b.writeBit(0);
		b.writeBit(0); 
		b.writeBit(0); 
		b.writeBit(0); 
		b.writeBit(1); 
		
		b.close();
*/		
		
		int[] freqCounts = new int[256];
		String relativePath = "happy hip hop.txt";
		String filePath = "C:\\Users\\OPBos\\eclipse-workspace\\HuffmanCodingCS3\\src\\" + relativePath;
		try  {
			FileReader reader = new FileReader(filePath);
			
			int ch;
			while ((ch = reader.read()) != -1) {
			//	System.out.print((char) ch);
				freqCounts[ch]++;
				
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
/*		freqCounts[32] = 2; // space
		freqCounts[97] = 1; // a
		freqCounts[104] = 3; // h
		freqCounts[105] = 1; // i
		freqCounts[111] = 1; // o
		freqCounts[112] = 4; // p
		freqCounts[121] = 1; // y
*/
		
//		HuffmanTree tree = new HuffmanTree(freqCounts);
//	     TreePrinter.printTree(tree.queue.peek());
//		 tree.write(relativePath); // this works
//		 BitOutputStream output = new BitOutputStream("C:\\Users\\OPBos\\eclipse-workspace\\HuffmanCodingCS3\\src\\" 
//				 									+ relativePath.substring(0,  relativePath.indexOf('.')) 
//				 									+ ".short");
//		 tree.encode(output, relativePath);
		
		
		
		HuffmanTree tree2 = new HuffmanTree("happy hip hop.code");
//		TreePrinter.printTree(tree2.root);
		BitInputStream input = new BitInputStream("C:\\Users\\OPBos\\eclipse-workspace\\HuffmanCodingCS3\\src\\" + "happy hip hop.short");
		tree2.decode(input, "happy hip hop.new"); 
	}
	

}