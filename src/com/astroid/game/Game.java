package com.astroid.game;

public class Game
{
    boolean end = false;    synchronized void set_end(boolean v)  {  end = v;  }
                                        synchronized boolean get_end()  {  return end;  }
    static int size;    static long dt;
    World world;    Gui gui;

    Game()
    {  size = 500;    dt = 100;
        world = new World();    gui = new Gui(this);  }

    void play()
    {
        while (!get_end())
        {  long t_start = System.currentTimeMillis();

            world.evolve();    gui.p.repaint();

            long dt_real = System.currentTimeMillis() - t_start;
            if (dt_real < dt)  try {  Thread.sleep(dt  - dt_real);  }  catch (InterruptedException e) {}
                              else  System.out.println("PC too slow; please increase dt");  }

        System.exit(0);
    }
}

