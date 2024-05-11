import java.util.List;

public abstract class MazeSolver {

	private Maze maze;
	private boolean isSolved;
	private boolean isSolvable;
	private Square exploredBeforeExit;

	public MazeSolver(Maze maze) {
		this.maze = maze;
		isSolved = false;
		isSolvable = true;

	}

	public abstract void makeEmpty();

	public abstract boolean isEmpty();

	public abstract void add(Square e);

	public abstract Square next();

	public boolean isSolved() {
		return isSolved || !isSolvable;
	}

	public abstract Square peek();

	public void step() {
		if (isEmpty()) {
			System.out.println("solved...");
			isSolvable = false;
			return;
		}
		Square currentSquare = next(); // removes and returns currentSquare
		currentSquare.setStatus(Square.EXPLORED);

		if (currentSquare.getType() == Square.EXIT) {
			isSolved = true;
			return;
		}

		List<Square> neighbors = maze.getNeighbors(currentSquare);

		for (Square s : neighbors) {
			if (s.getType() != Square.WALL && s.getStatus() == Square.UNKNOWN) {
				s.setStatus(Square.WORKING);
				add(s);

			}
		}
		try {
		if (peek().getType() == Square.EXIT && peek() != null) {
			exploredBeforeExit = currentSquare;
			}
		} catch(NullPointerException e) {
			System.out.println("Maze can't be solved");
		}
	}

	
		
	

	public String getPath() {
		if (isSolved) {

			maze.getExit().setPrevious(exploredBeforeExit);
//			System.out.println("(" + Integer.toString(maze.getExit().getRow()) + ", " + Integer.toString(maze.getExit().getCol()) + ")");
//			System.out.println(exploredBeforeExit.getPrevious().getRow());
//			System.out.println(exploredBeforeExit.getPrevious().getCol());
			Square temp = maze.getExit();
			while (temp.hasPrevious() && temp.getType() != Square.START) {
				temp.setStatus(Square.ON_EXIT_PATH); // Updates on GUI
				System.out.println("(" + Integer.toString(temp.getRow()) + ", " + Integer.toString(temp.getCol()) + ")");
				temp = temp.getPrevious();
			}
			System.out.println("(" + Integer.toString(maze.getStart().getRow()) + ", " + Integer.toString(maze.getStart().getCol()) + ")" 
			+ " <<< Start Here");
			System.out.println("No more squares to be explored!");
			return "Maze is Solved!";
		} else if (!isSolvable)
			return "Maze cannot be solved";
		return "Maze is being solved!";
	}

	public void solve() {
		while (!isSolvable)
			step();
	}

}
