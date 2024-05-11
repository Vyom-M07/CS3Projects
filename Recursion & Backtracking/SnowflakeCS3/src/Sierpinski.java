import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sierpinski extends JPanel {

	public Sierpinski() {

		super.setPreferredSize(new Dimension(400, 400));
		super.setBackground(Color.BLACK);

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		drawSierpinski(g, 0, 0, 400);

	}

	private void drawSierpinski(Graphics g, int x, int y, int n) {

		g.setColor(Color.white);

		if (n <= 1) {
			return;
		}

		int x1 = x; // top left-x
		int y1 = y; // top left- y
		int x2 = x + n; // top left plus size of triangle --> goes to right-border
		int y2 = y; // top left- y
		int x3 = x; // top left- x
		int y3 = y + n; // top left plus size of triange --? goes to bottom border

		
		g.drawLine(x1, y1, x2, y2); // top left point to right most
		g.drawLine(x2, y2, x3, y3); // right most to bottom most
		g.drawLine(x3, y3, x1, y1); // bottom most to top left

		
		drawSierpinski(g, x, y, n / 2); // smaller triangle to the left
		drawSierpinski(g, x + n / 2, y, n / 2); // smaller triangle to the right
		drawSierpinski(g, x, y + n / 2, n / 2); // smaller trianle to the below

/*
 * 		Ignore commented code below: failed attemps: 
 * 
		g.drawLine(x/2, y/2, (x/2), (y/2) - (n/2));
		g.drawLine(x/2, y/2, (x/2) - (n/2), y/2);
		g.drawLine(x/2, (y/2)-(n/2), (x/2) - (n/2), y/2);
		
		
		drawSierpenski(g, x/2, y/2, n/2);
		drawSierpenski(g, (x/2)+(x/4), (y/2)-(y/4), n/4);
		drawSierpenski(g, (x/2)-(x/4), (y/2)+(y/4), n/4);
*/
	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("Snowflake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Sierpinski());
//		frame.setUndecorated(true); // gets rid of title border
		frame.pack();
		frame.setVisible(true);

	}

}
