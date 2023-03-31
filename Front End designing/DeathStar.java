package assignment5;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class DeathStar extends Shape {
// Variable for the position on the display panel
	private int offset;

	public DeathStar(int a, int b) {
		super(a, b); // we explicitly call a superclass constructor that takes 2 ints
		offset = 0;
	}
// This constructor decides the image position on the panel
	public DeathStar(int a, int b, int o) {
		super(a, b); // we explicitly call a superclass constructor that takes 2 ints
		this.offset = o;
	}

// Draws the image
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
// Variables		
		final int x = getX();
		final int y = getY();

		int xOffset = 1;
		int yOffset = 1;
// Drawing methods
// Draws the main body
		g2d.setColor(Color.GRAY);
		g2d.fill(new Ellipse2D.Double(x + xOffset, offset + y + yOffset, x + xOffset * 75, y + yOffset * 75));
// Draws the smaller circle and the splitting lines halfway through the circle		
		g2d.setColor(Color.BLACK);
		g2d.fill(new Ellipse2D.Double(x + xOffset + 15, offset + y + yOffset + 15, x + xOffset - 0.25 * x,
				y + yOffset - 0.25 * y));
		g2d.drawRoundRect(x + 1 + xOffset, offset + y * 2 + 15 + yOffset, 133, 2, 15, 15);
	}
}
