package assignment5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class PokeBall extends Shape {
// Variables for the position on the display panel
	private int ysett;
	private int xsett;

	public PokeBall(int a, int b) {
		super(a, b); // we explicitly call a superclass constructor that takes 2 ints
		ysett = 0;
		xsett = 0;
	}

// This constructor decides the image position on the panel
	public PokeBall(int a, int b, int x, int y) {
		super(a, b); // we explicitly call a superclass constructor that takes 2 ints
		this.ysett = y;
		this.xsett = x;
	}

// Draws the image	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
// Variables	
		final int x = getX();
		final int y = getY();

		int xOffset = 1;
		int yOffset = 1;
// Draws the lower semi circle of the poke balll
		g2d.setColor(Color.WHITE);
		g2d.fill(new Ellipse2D.Double(xsett + x + xOffset, ysett + y + yOffset, x + xOffset * 75, y + yOffset * 75));
// Draws the upper semi circle of the poke ball
		g2d.setColor(Color.RED);
		g2d.fillArc(xsett + x + xOffset, ysett + y + yOffset, 145, 150, 0, 180);
// Draws the inner circle of the poke ball and the splitting line	
		g2d.setColor(Color.BLACK);
		g2d.fill(new Ellipse2D.Double(xsett + x + xOffset + 45, ysett + y + yOffset + 50, x + xOffset - 0.25 * x,
				y + yOffset - 0.25 * y));
		g2d.fillRect(xsett + x + xOffset, ysett + y * 2 + 5 + yOffset, 145, 7);
// Draws the circle within the inner circle		
		g2d.setColor(Color.WHITE);
		g2d.fillArc(xsett + x + xOffset + 50, ysett + y + yOffset + 56, 43, 43, 0, 360);
// Draws the innermost circle	
		g2d.setColor(Color.BLACK);
		g2d.drawArc(xsett + x + xOffset + 59, ysett + y + yOffset + 65, 25, 25, 0, 360);
	}
}
