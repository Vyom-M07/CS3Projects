
public class MazeSolverWithStack extends MazeSolver{

	MyStack stack;
	
	public MazeSolverWithStack(Maze maze) {
		super(maze);
		stack = new MyStack();
		add(maze.getStart());
		
	}
	
	@Override
	public void add(Square s) {
		stack.push(s);
	}

	@Override
	public void makeEmpty() {
		stack.clear();
		
	}

	@Override
	public boolean isEmpty() {
		
		return stack.isEmpty();
	}

	@Override
	public Square next() {
		
		return stack.pop();
		
	}

	@Override
	public Square peek() {
		// TODO Auto-generated method stub
		return stack.peek();
	}
	
	
	

}
