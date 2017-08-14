/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerp;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Andres
 */
public class Screen extends Canvas implements Runnable {
	
	
	
	/**
	 * Create a GameDisplay custom canvas.
	 */
	public Screen() {
		setSize(500,500);
		setLocation(1,1);
		setBackground(Color.black);
		
		addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Handler.createPoint(e.getX(), e.getY());
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
	}

	@Override
	public void run() {
		createBufferStrategy(2);
		while (true) {
			Graphics g = getBufferStrategy().getDrawGraphics();
			
			try {
				g.drawImage(Handler.getBoardImage(), 0, 0, this);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			getBufferStrategy().show();

			try {
				Thread.sleep(30);
			} catch (InterruptedException ex) {
			}
		}
	}

}
