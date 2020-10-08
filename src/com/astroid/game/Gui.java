package com.astroid.game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Gui {
	 Game game;    JFrame f;    DrawingPanel p;

	    class DrawingPanel extends JPanel
	    {  public void paintComponent(Graphics g)
	        {  super.paintComponent(g);
	            game.world.draw(g); } }

	    Gui(Game game)
	    {
	        this.game = game;
	        f = new JFrame();    f.setFocusable(true);    f.setVisible(true);
	        p= new DrawingPanel();    f.getContentPane().add(p , BorderLayout.CENTER);

	        f.addKeyListener(new KeyAdapter()
	        {  public void keyPressed(KeyEvent e)
	            {   int c = e.getKeyCode();    SpaceCraft sc = Gui.this.game.world.spacecraft;
	                 switch (c) { case KeyEvent.VK_LEFT:     sc.set_COMdir(-1);  break; 
	                                     case KeyEvent.VK_RIGHT:  sc.set_COMdir(+1);  break;
	                                     case KeyEvent.VK_DOWN:  sc.set_COMthr(-1);  break;
	                                     case KeyEvent.VK_UP:         sc.set_COMthr(+1);  break; 
	                                     case KeyEvent.VK_ESCAPE:  Gui.this.game.set_end(true);  break;  } } } );

	        f.addKeyListener(new KeyAdapter()
	        {  public void keyReleased(KeyEvent e)
	            {  int c = e.getKeyCode();    SpaceCraft sc = Gui.this.game.world.spacecraft;
	                 switch (c) { case KeyEvent.VK_LEFT:     sc.set_COMdir(0);  break; 
	                                     case KeyEvent.VK_RIGHT:  sc.set_COMdir(0);  break;
	                                     case KeyEvent.VK_DOWN:  sc.set_COMthr(0);  break;
	                                     case KeyEvent.VK_UP:         sc.set_COMthr(0);  break;  } } } );

	        f.setSize(new Dimension(Game.size + 16, Game.size + 38));
	    }
}
