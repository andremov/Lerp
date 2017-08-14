/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author Andres
 */
public class Handler {
	
	private static Point[] points = new Point[10];
	private static int count = 0;
	private static int precision = 50;
	
	public static void createPoints() {
		for (int i = 0; i < points.length; i++) {
			points[i] = new Point(-10,-10);
		}
	}
	
	public static void createPoint(int x, int y) {
		points[count].setX(x);
		points[count].setY(y);
		count++;
		if (count == points.length) {
			count = 0;
		}
	}
	
	public static BufferedImage getBoardImage() throws IOException {
		int imageSize = 500;
		BufferedImage image = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_ARGB);
		Graphics g = image.getGraphics();
		
		g.setColor(Color.black);
		g.fillRect(5,5,490,490);
		
		for (int i = 0; i < points.length; i++) {
			g.drawImage(points[i].getImage(), points[i].getX(), points[i].getY(), null);
		}
		
		g.setColor(Color.white);
		for (int i = 0; i < points.length-1; i++) {
			g.drawLine(points[i].getX(), points[i].getY(), points[i+1].getX(), points[i+1].getY());
		}
		
		for (int i = 0; i < points.length-2; i++) {
			int dx1 = points[i].getX() - points[i+1].getX();
			int dx2 = points[i+1].getX() - points[i+2].getX();
			
			int dy1 = points[i].getY() - points[i+1].getY();
			int dy2 = points[i+1].getY() - points[i+2].getY();
			for (int j = 1; j < precision; j++) {
				int x1 = (int)(points[i].getX() - (dx1*(j/(float)precision)));
				int x2 = (int)(points[i+1].getX() - (dx2*(j/(float)precision)));
				int y1 = (int)(points[i].getY() - (dy1*(j/(float)precision)));
				int y2 = (int)(points[i+1].getY() - (dy2*(j/(float)precision)));
				g.drawLine(x1,y1,x2,y2);	
			}
			
		}
		
		return image;
	}
}
