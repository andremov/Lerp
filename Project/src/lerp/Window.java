/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerp;

import javax.swing.JFrame;

/**
 *
 * @author Andres
 */
public class Window extends JFrame {

	private Screen screen;
	private Thread screenThread;
	
	public Window() {
        setLayout(null);
        setSize(576,599);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Chess");
		
		screen = new Screen();
		add(screen);
		
		screenThread = new Thread(screen);
		
        setVisible(true);
		
        screenThread.start();
	}
	
}
