import java.util.List;

public abstract class MazeSolver {

	private Maze maze;
	private boolean isSolved;
	private boolean isSolvable;

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

	public void step() {
		if (isEmpty()) {
			System.out.println("solved...");
			isSolvable = false;
			return;
		}
		Square currentSquare = next();
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
	}

	public String getPath() {
		if (isSolved)
			return "Maze is Solved!";
		if (!isSolvable)
			return "Maze cannot be solved";
		return "Maze is being solved";
	}

	public void solve() {
		while (!isSolvable)
			step();
	}

}
