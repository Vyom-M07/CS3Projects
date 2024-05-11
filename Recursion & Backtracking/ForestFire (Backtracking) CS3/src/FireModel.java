public class FireModel {
	public static int SIZE = 47;
	private FireCell[][] myGrid;
	private FireView myView;

	public FireModel(FireView view) {
		myGrid = new FireCell[SIZE][SIZE];
		int setNum = 0;
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				myGrid[r][c] = new FireCell();
			}
		}

		// For loop below turns every tree on the bottom border to be on fire
		for (int i = 0; i < myGrid[0].length; i++) {

			if (myGrid[myGrid.length - 1][i].getStatus() == FireCell.GREEN) {
				myGrid[myGrid.length - 1][i].setStatus(2);
			}
		}
//        myGrid[myGrid.length-2][myGrid[0].length-1].setStatus(FireCell.GREEN);
//        myGrid[myGrid.length-1][myGrid[0].length-1].setStatus(FireCell.BURNING);

		myView = view;
		myView.updateView(myGrid);
	}

	/*
	 * recursiveFire method here
	 */

	public void recursiveFire(int x, int y) {
		myView.updateView(myGrid);

		if (myGrid[x][y].getStatus() == FireCell.BURNING) {
			if (x - 1 >= 0 && myGrid[x - 1][y].getStatus() == FireCell.GREEN) { // up from original
				myGrid[x - 1][y].setStatus(FireCell.BURNING);
				recursiveFire(x - 1, y);
			}
			if (x + 1 <= myGrid.length - 1 && myGrid[x + 1][y].getStatus() == FireCell.GREEN) { // down from original
				myGrid[x + 1][y].setStatus(FireCell.BURNING);
				recursiveFire(x + 1, y);
			}
			if (y + 1 <= myGrid[0].length - 1 && myGrid[x][y + 1].getStatus() == FireCell.GREEN) { // right from
																									// original
				myGrid[x][y + 1].setStatus(FireCell.BURNING);
				recursiveFire(x, y + 1);
			}
			if (y - 1 >= 0 && myGrid[x][y - 1].getStatus() == FireCell.GREEN) { // left from original
				myGrid[x][y - 1].setStatus(FireCell.BURNING);
				recursiveFire(x, y - 1);
			}
		}

	}

	public void solve() {
		for (int i = 0; i < myGrid[0].length - 1; i++) {

			recursiveFire(myGrid.length - 1, i);
			myView.updateView(myGrid);
		}

		boolean danger = false;

		for (int j = 0; j < myGrid[0].length - 1; j++) {

			if (myGrid[0][j].getStatus() == FireCell.BURNING) {
				danger = true;
				break;
			}
		}

		if (danger) {
			System.out.println("Onnet is on fire!");
		} else {
			System.out.println("Onnet is safe!");
		}

	}

}
