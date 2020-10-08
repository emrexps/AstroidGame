package com.astroid.game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class SpaceCraft extends Obj
{
	 int x , y;
	    double dir;    int COMdir;    synchronized void set_COMdir(int c)  { COMdir = c; }
	    double thr;    int COMthr;    synchronized void set_COMthr(int c)  { COMthr = c; }

	    SpaceCraft()
	    {  x = y = Game.size / 2;
	        dir = 0.0;    thr = 0.0;  }

	    synchronized void evolve()
	    {
	        dir += COMdir * (2.0 * Math.PI / 5) * Game.dt / 1000.0;
	        thr += COMthr * (1.0 / 5) * Game.dt / 1000.0;
	        if (thr < 0.0)  thr = 0.0;    if (thr > 1.0)  thr = 1.0;

	        double v = thr * Game.size / 10.0;
	        x += (int)(v * Math.cos(dir) * Game.dt / 1000.0);
	        y += (int)(v * Math.sin(dir)  * Game.dt / 1000.0);
	    }


	    int n = 4;
	    int[] X = new int[] {   20 , -20 , -40 ,  -20 };
	    int[] Y = new int[] {     0 ,  10 ,     0 ,  -10 };

	    void draw(Graphics g)
	    {  Graphics2D g2 = (Graphics2D)g;
	        java.awt.geom.AffineTransform at0 = g2.getTransform();

	        g2.translate(x , y);    g2.rotate(dir);

	        g.setColor(Color.DARK_GRAY); 
	        
	        g.fillPolygon(X , Y , n);

	        g2.setTransform(at0);
	  }
	}

