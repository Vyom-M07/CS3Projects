import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * A model for the game of 20 questions
 *
 * @author Rick Mercer
 */
public class GameTree {
	/**
	 * Constructor needed to create the game.
	 *
	 * @param fileName this is the name of the file we need to import the game
	 *                 questions and answers from.
	 */

	private class Node {

		Node right;
		Node left;
		String questionText;

		private Node(String questionText) {

			this.questionText = questionText;
			left = right = null;

		}

		public String toString() {

			return questionText;
		}

	}

	Node root;
	Node current;
	String fileName;

	public GameTree(String fileName) throws FileNotFoundException {
		// TODO

		this.fileName = fileName;
		File f = new File(fileName);
		Scanner sc = new Scanner(f);
		root = treeMakerHelper(sc);
		current = root;

	}

	private Node treeMakerHelper(Scanner sc) {
		String line = sc.nextLine().trim();
		Node curr = new Node(line);

		if (line.endsWith("?")) {
			curr.left = treeMakerHelper(sc);
			curr.right = treeMakerHelper(sc);

		}

		return curr;
	}

	/*
	 * Add a new question and answer to the currentNode. If the current node has the
	 * answer chicken, theGame.add("Does it swim?", "goose"); should change that
	 * node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQ The question to add where the old answer was.
	 * @param newA The new Yes answer for the new question.
	 */
	public void add(String newQ, String newA) {
		// TODO
		// Node oldAns = current;
		current.right = new Node(current.questionText);
		current.left = new Node(newA);
		current.questionText = newQ;

	}

	/**
	 * True if getCurrent() returns an answer rather than a question.
	 *
	 * @return False if the current node is an internal node rather than an answer
	 *         at a leaf.
	 */
	public boolean foundAnswer() {
		// TODO

		if (current.right == null && current.left == null)
			return true;

		return false;
	}

	/**
	 * Return the data for the current node, which could be a question or an answer.
	 * Current will change based on the users progress through the game.
	 *
	 * @return The current question or answer.
	 */
	public String getCurrent() {
		// TODO

		if (current != null)
			return current.toString();

		return "no current";
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or right
	 * for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 *
	 * @param yesOrNo
	 */
	public void playerSelected(Choice yesOrNo) {
		if (yesOrNo.equals(Choice.Yes) && current != null) {

			current = current.left;
		} else if (yesOrNo.equals(Choice.No) && current != null) {
			current = current.right;
		}
	}

	/**
	 * Begin a game at the root of the tree. getCurrent should return the question
	 * at the root of this GameTree.
	 */
	public void reStart() {
		// TODO
		current = root;

	}

	@Override
	public String toString() {
		// TODO
		StringBuilder strResult = new StringBuilder();
		toStringHelper(root, 0, strResult);
		return strResult.toString();
	}

	private void toStringHelper(Node node, int depthCoutner, StringBuilder strResult) {
		
		if (node != null) {
	
			toStringHelper(node.right, depthCoutner+1, strResult);
			strResult.append("- ".repeat(depthCoutner)).append(node.toString()).append("\n");
			toStringHelper(node.left, depthCoutner+1, strResult);
			
		}
	
	}

	/**
	 * Overwrite the old file for this gameTree with the current state that may have
	 * new questions added since the game started.
	 * @throws IOException 
	 *
	 */
	public void saveGame() throws IOException {
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(fileName));
			PrintStream printStream = new PrintStream(outputStream);
			preOrder(root, outputStream, printStream);
			printStream.close();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void preOrder(Node node, FileOutputStream outputStream, PrintStream printStream) {
		try {

			if (node != null) {
				System.setOut(printStream);
				System.out.println(node.toString());
				preOrder(node.left, outputStream, printStream);
				preOrder(node.right, outputStream, printStream);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
