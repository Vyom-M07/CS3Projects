
public class MazeSolverWithQueue<T> extends MazeSolver {

	MyQueue<T> queue;
	
	public MazeSolverWithQueue(Maze maze) {
		super(maze);
		queue = new MyQueue<T>();
		add(maze.getStart());
	}

	@Override
	public void makeEmpty() {
		queue.clear();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(Square e) {
		
		queue.offer((T) e);
		
	}

	@Override
	public Square next() {
		// TODO Auto-generated method stub
		return (Square) queue.poll();
	}

	@Override
	public Square peek() {
		// TODO Auto-generated method stub
		return (Square) queue.peek();
	}

}
