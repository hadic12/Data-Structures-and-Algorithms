package assignment5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class UFO extends Shape {
// Variable for the position on the display panel	
	private int offset;

	public UFO(int a, int b) {
		super(a, b); // we explicitly call a superclass constructor that takes 2 ints
		offset = 0;
	}
// This constructor decides the image position on the panel
	public UFO(int a, int b, int o) {
		super(a, b); // we explicitly call a superclass constructor that takes 2 ints
		this.offset = o;
	}

// Draws the image	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		final int x = getX();
		final int y = getY();

		g2d.setColor(Color.CYAN);
//Variables 		
		int xOffset = 1;
		int yOffset = 1;
		float alpha = (float) 0.5;
// Drawing methods		
// Draws the lowerbody
		g2d.fillArc(offset + x * 2, y, x * 2, y * 2, -15, 205);
		g2d.setColor(Color.ORANGE);
		g2d.fill(new Ellipse2D.Double(offset + x, y * 2, x * 4, (y / 2) + 10));
// Draws the windsheild
		g2d.setColor(Color.WHITE);
		g2d.fillArc(offset + x * 2 + 10, y + 20, 15, 50, 75, 115);
// Draws the lights
		g2d.fill(new Ellipse2D.Double(offset + x + 25, (y * 2) + 14, x / 7, y / 7));
		g2d.fill(new Ellipse2D.Double(offset + x + 40, (y * 2) + 15, x / 7, y / 7));
		g2d.fill(new Ellipse2D.Double(offset + x + 55, (y * 2) + 16, x / 7, y / 7));
		g2d.fill(new Ellipse2D.Double(offset + x + 70, (y * 2) + 17, x / 7, y / 7));
		g2d.fill(new Ellipse2D.Double(offset + x + 85, (y * 2) + 18, x / 7, y / 7));
		g2d.fill(new Ellipse2D.Double(offset + x + 100, (y * 2) + 18, x / 7, y / 7));
		g2d.fill(new Ellipse2D.Double(offset + x + 115, (y * 2) + 17, x / 7, y / 7));
		g2d.fill(new Ellipse2D.Double(offset + x + 130, (y * 2) + 16, x / 7, y / 7));
		g2d.fill(new Ellipse2D.Double(offset + x + 145, (y * 2) + 15, x / 7, y / 7));
		g2d.fill(new Ellipse2D.Double(offset + x + 160, (y * 2) + 14, x / 7, y / 7));

	}

}