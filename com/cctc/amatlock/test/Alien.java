package com.cctc.amatlock.test;

import java.awt.*;

public class Alien extends CoreObject
{
    public Laser[] lasers = new Laser[30];
    public int laserCounter = 0;
    private int ticks = 0;
    /**
     * Creates the core object. All subclasses
     * will call this with super.
     * The super call to the Rectangle class.
     *
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     */

    public Alien(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
    }

    @Override
    public void tick()
    {
        x += velX;
        y += velY;
        ticks++;

        if(ticks == 120)
        {
            shoot();
            ticks = 0;
        }
        for(int i = 0; i < laserCounter; i++)
        {
           lasers[i].tick();

        }
    }

    @Override
    public void render(Graphics g)
    {
        if(!destroyed )
        {
            g.setColor(color);
            g.fillRect(x,y,width,height);
            for(int i = 0; i < laserCounter; i++)
            {
                lasers[i].render(g);

            }
        }
    }
    public void shoot()
    {
        Laser laser = new Laser(x, y, 5, 10, Color.WHITE, false);
        laser.setVelY(10);

        if(laserCounter >= lasers.length)
        {

            laserCounter = 0;
        }

        lasers[laserCounter] = laser;
        laserCounter++;
    }
}
