import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze {

	private Square[][] mazeSquares;
	private Square start;
	private Square end;
	private String fileName;
//	private MyStack pathStack;

	public Maze() {

		loadMaze("C:\\Users\\OPBos\\eclipse-workspace\\BellRinger\\src\\maze-2");

	}

	public boolean loadMaze(String fileName) {
		// COME BACK TO
//		pathStack = new MyStack();
		this.fileName = fileName;
		int row = 0;
		int col = 0;

		try {

			Scanner scan = new Scanner(new FileReader(fileName));
			row = scan.nextInt();
			col = scan.nextInt();
			mazeSquares = new Square[row][col];

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					int type = scan.nextInt();
					mazeSquares[i][j] = new Square(i, j, type, null);
//					pathStack.push(mazeSquares[i][j]);
					switch (type) {
					case 2:
						start = mazeSquares[i][j];
						break;
					case 3:
						end = mazeSquares[i][j];
						break;
					}
				}

			}

			return true;

		} catch (FileNotFoundException e) {
			e.printStackTrace();

			return false;
		}

	}

	public List<Square> getNeighbors(Square s) {

		List<Square> list = new ArrayList<Square>();
		// North, East, South, West << Do in this order

		try {
			if (s.getRow() - 1 >= 0) {
				list.add(mazeSquares[s.getRow() - 1][s.getCol()]);
				if (mazeSquares[s.getRow() - 1][s.getCol()].getPrevious() == null) {
					// s.setPrevious(mazeSquares[s.getRow() - 1][s.getCol()]);
					mazeSquares[s.getRow() - 1][s.getCol()].setPrevious(s);
		//			pathStack.push(s);
					
				}

			}
			if (s.getCol() + 1 < mazeSquares[0].length) {
				list.add(mazeSquares[s.getRow()][s.getCol() + 1]);
				if (mazeSquares[s.getRow()][s.getCol() + 1].getPrevious() == null) {
					// s.setPrevious(mazeSquares[s.getRow()][s.getCol() + 1]);
					mazeSquares[s.getRow()][s.getCol() + 1].setPrevious(s);
		//			pathStack.push(s);

				}
			}
			if (s.getRow() + 1 < mazeSquares.length) {
				list.add(mazeSquares[s.getRow() + 1][s.getCol()]);
				if (mazeSquares[s.getRow() + 1][s.getCol()].getPrevious() == null) {
					// s.setPrevious(mazeSquares[s.getRow() + 1][s.getCol()]);
					mazeSquares[s.getRow() + 1][s.getCol()].setPrevious(s);
			//		pathStack.push(s);

				}
			}
			if (s.getCol() - 1 >= 0) {
				list.add(mazeSquares[s.getRow()][s.getCol() - 1]);
				if (mazeSquares[s.getRow()][s.getCol() - 1].getPrevious() == null) {
					// s.setPrevious(mazeSquares[s.getRow()][s.getCol() - 1]);
					mazeSquares[s.getRow()][s.getCol() - 1].setPrevious(s);
			//		pathStack.push(s);

				}

			}

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("out of bounds");
		}

		return list;

	}

	public Square getStart() {

		return start;

	}

	public Square getExit() {

		return end;

	}

	public void reset() {

		loadMaze(fileName);

	}

//	public MyStack getPathStack() {
//
//		return pathStack;
//
//	}
	
	

	public String toString() {

		String s = "";
		for (int i = 0; i < mazeSquares.length; i++) {
			for (int j = 0; j < mazeSquares[i].length; j++) {
				s += mazeSquares[i][j].toString() + " ";
			}
			s += "\n"; // after it goes through a row, start a new line
		}
		return s;

	}

	public static void main(String[] args) {

		Maze mze = new Maze();
//		System.out.println(mze.getExit().toString());
		System.out.println(mze.toString());

//		List<Square> exitArr = mze.getNeighbors(mze.getExit());
//		Square exploredBeforeExit = null;
//		for (Square s : exitArr) {
//			if (s.getStatus() == '_') {
//				exploredBeforeExit = s;
//				break;
//			}
//		}
//		mze.getExit().setPrevious(exploredBeforeExit);
//		System.out.println(mze.getExit().getPrevious());

	}

}
