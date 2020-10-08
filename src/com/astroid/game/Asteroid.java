package com.astroid.game;
import java.awt.Color;
import java.awt.Graphics;

public class Asteroid extends Obj
{
    int x , y , vx , vy;

    Asteroid()
    {  x = (int)(Math.random() * Game.size);    vx = (int)((2*Math.random()-1) * Game.size / 100.0);
        y = (int)(Math.random() * Game.size);    vy = (int)((2*Math.random()-1) * Game.size / 100.0);  }

    void evolve()
    {  x += vx * Game.dt / 500.0;    y += vy * Game.dt / 500.0;  }

    void draw(Graphics g)
    {  g.setColor(Color.red);    g.fillOval(x - 5 , y - 5 , x/15 , y/15);  }
}