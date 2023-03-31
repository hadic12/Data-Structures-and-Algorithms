package assignment5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;

// Creates an Among Us Charachter
public class Imposter extends Shape {

	public Imposter(int a, int b) {
		super(a, b); // we explicitly call a superclass constructor that takes 2 ints
	}

// Draws the image	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		final int x = getX();
		final int y = getY();
// Drawing methods
// Draws the main body
		g2d.setColor(Color.RED);
		g2d.fillArc(x, y, 110, 100, 0, 180);
		g2d.fillRoundRect(x, y * 5, 110, 100, 15, 15);
		g2d.fillRoundRect(x * 4, y * 5 - 5, 100, 80, 15, 15);
		g2d.fill(new Ellipse2D.Double(x - 1, (y * 5 + 100) / 1.75, 110 / 2, 100));
		g2d.fill(new Ellipse2D.Double(((x + 100) / 1.75) + 2, (y * 5 + 100) / 1.75, 110 / 2, 100));
// Draws the helmet see through		
		g2d.setColor(Color.CYAN);
		g2d.fill(new Ellipse2D.Double(x * 2 + 4, y * 2, 50, 30));
// Draws the backpack		
		g2d.setColor(Color.BLACK);
		g2d.drawRoundRect(x * 11 + 5, y * 5 - 5, 25, 80, 15, 15);
	}
}
