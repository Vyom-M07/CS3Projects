import java.awt.Color;
import java.awt.Font;

enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem {
	
	private GemType type;
	private int points;
	private int[] values = new int[] {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50}; // 11 values in this array
	
	Gem () {
		int random = (int) (Math.random()*3); // 0, 1, 2 >> for picking a random gem
		int random2 = (int) (Math.random()*11); // numbers between 0-10 >> for picking a random value
		type = GemType.values()[random];
		points = values[random2];
		
		
		
	}
	
	Gem(GemType type, int points) {
		this.type = type;
		this.points = points;
		
	}
	
	@Override
	public String toString() {
		
		return type.name();
		
	}
	
	public GemType getType() {
		
		return type;
	}
	
	public int getPoints() {

		return points;
		
	}
	
	public void draw(double x, double y) {
		
		switch(type) {
		case GREEN:
			StdDraw.picture(x, y, "C:\\Users\\OPBos\\eclipse-workspace\\GemMatchingCS3\\src\\gem_green.png");
			StdDraw.setFont(new Font("SansSerif", Font.BOLD, 14));
			StdDraw.setPenColor(Color.white);
			StdDraw.text(x, y, Integer.toString(points));
			break;
		case BLUE:
			StdDraw.picture(x, y, "C:\\Users\\OPBos\\eclipse-workspace\\GemMatchingCS3\\src\\gem_blue.png");
			StdDraw.setFont(new Font("SansSerif", Font.BOLD, 14));
			StdDraw.setPenColor(Color.white);
			StdDraw.text(x, y, Integer.toString(points));
			break;
		case ORANGE:
			StdDraw.picture(x, y, "C:\\Users\\OPBos\\eclipse-workspace\\GemMatchingCS3\\src\\gem_orange.png");
			StdDraw.setFont(new Font("SansSerif", Font.BOLD, 14));
			StdDraw.setPenColor(Color.white);
			StdDraw.text(x, y, Integer.toString(points));
			break;
		}
		
		
	}
	
	
	
	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;
		
		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
//		Gem random = new Gem();
//		System.out.println(random + ", " + random.getType() + ", " + random.getPoints());
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());		
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);
		
		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}
}
