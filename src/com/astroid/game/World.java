package com.astroid.game;
import java.awt.Color;
import java.awt.Graphics;

public class World {

    static final int N = 35;
    Obj[] obj = new Obj[N];    SpaceCraft spacecraft;

    World()
    {  obj[0] = spacecraft = new SpaceCraft();
        for (int i = 1 ; i < N ; i++)  obj[i] = new Asteroid();  }

    void evolve()                 {  for (int i = 0 ; i < N ; i++)  if (obj[i] != null)  obj[i].evolve();  }
    void draw(Graphics g)  {  for (int i = 0 ; i < N ; i++)  if (obj[i] != null)  obj[i].draw(g); g.setColor(Color.cyan);  }
}
