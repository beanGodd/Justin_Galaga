package com.cctc.amatlock.test;

import com.cctc.amatlock.test.utilities.Images;

import java.awt.*;

public class Spaceship extends CoreObject
{
      public int score = 0;
      public Laser[] lasers = new Laser[30];
      public int laserCounter = 0;
      private Color laserColor = new Color(255, 0, 137);
    /**
     * Creates the core object. All subclasses
     * will call this with super.
     * The super call to the Rectangle class.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     */
    public Spaceship(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
    }

    @Override
    public void tick()
    {
        if(destroyed)
        {
            return;
        }
        x += velX;
        int counter = 0;
        counter++;
        if(counter == 30)
        {
            shoot();
        }
        for(int i = 0; i < laserCounter; i++)
        {
            lasers[i].tick();

        }
    }
    @Override
    public void render(Graphics g)
    {
        if(!destroyed)
        {
            g.setColor(color);
            //g.fillRect(x,y,width,height);
           g.drawImage(Images.spaceship, x - 4, y, width+8, height, null);

            for(int i = 0; i < laserCounter; i++)
            {
                lasers[i].render(g);

            }
        }


    }
    public void shoot()
    {
       Laser laser = new Laser(x, y, 5, 10, laserColor, true );
       laser.setVelY(-10);

       if(laserCounter >= lasers.length)
       {

           laserCounter = 0;
       }

       lasers[laserCounter] = laser;
       laserCounter++;
    }
}
