import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel
{
	public SnowFlakePanel()
	{
		super.setPreferredSize(new Dimension(400, 400));
		super.setBackground(Color.BLACK); // changed to black (from white) for dark mode purposes (eyes)
	}

	public void paintComponent(Graphics g)
	{
		int width  = getWidth();
		int height = getHeight();

		super.paintComponent(g);

		/*
		 * DRAWING CODE BELOW
		 */
	//	g.drawLine(0, 0, width - 1, height - 1);
		for (int i = 0; i < 10; i++) { // loop to create multiple snowflakes and get a blizzard!
		int sizeRand = (int) (Math.random() * 16)+ 10;
		
		Color c = new Color((int) (Math.random()*255) + 1, (int) (Math.random()*255) + 1, (int) (Math.random()*255) + 1);
		drawStar(g, (int) (Math.random()*width), (int) (Math.random()*height), sizeRand, c);
		}
	//	g.drawLine(width/2, height/2, width, height);
		
	}

	private void drawStar(Graphics g, int x, int y, int size, Color color) {
		if (size == 0) {
			return;
		}
		
		g.setColor(color);
		for (int i = 1; i <= 6; i++ ) {
			g.drawLine(x, y,  (int) (x + (size*Math.cos(i * (2 * Math.PI/6)))), (int) (y - (size*Math.sin(i * (2 * Math.PI/6)))));
			drawStar(g, (int) (x + (size*Math.cos(i * (2 * Math.PI/6)))), (int) (y - (size*Math.sin(i * (2 * Math.PI/6)))), size/5, color);

		}
		
		
//		g.drawLine(x, y,  (int) (x + (size*Math.cos(1 * (2 * Math.PI/6)))) , (int) (y - (size*Math.sin(1 * (2 * Math.PI/6)))));
//		g.drawLine(x, y,  (int) (x + (size*Math.cos(2 * (2 * Math.PI/6)))) , (int) (y - (size*Math.sin(2 * (2 * Math.PI/6)))));
//		g.drawLine(x, y,  (int) (x + (size*Math.cos(3 * (2 * Math.PI/6)))) , (int) (y - (size*Math.sin(3 * (2 * Math.PI/6)))));
//		g.drawLine(x, y,  (int) (x + (size*Math.cos(4 * (2 * Math.PI/6)))) , (int) (y - (size*Math.sin(4 * (2 * Math.PI/6)))));
//		g.drawLine(x, y,  (int) (x + (size*Math.cos(5 * (2 * Math.PI/6)))) , (int) (y - (size*Math.sin(5 * (2 * Math.PI/6)))));
//		g.drawLine(x, y,  (int) (x + (size*Math.cos(6 * (2 * Math.PI/6)))) , (int) (y - (size*Math.sin(6 * (2 * Math.PI/6)))));

		
		
	}
}

public class Snowflake
{
	public static void main ( String[] args )
	{
		/*
		 * A frame is a container for a panel
		 * The panel is where the drawing will take place
		 */
		JFrame frame = new JFrame("Snowflake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SnowFlakePanel());
		frame.pack();
		frame.setVisible(true);
	}
}
