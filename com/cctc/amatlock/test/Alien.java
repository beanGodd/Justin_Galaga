package com.cctc.amatlock.test;

import com.cctc.amatlock.test.utilities.Images;

import java.awt.*;

public class Alien extends CoreObject
{
    public Laser[] lasers = new Laser[30];
    public int laserCounter = 0;
    private static final int fireRate = 300;
    private int ticks = Randomizer.nextInt(-fireRate/2, fireRate/2);
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
        if(destroyed)
        {
            return;
        }
        x += velX;
        y += velY;
        ticks++;

        if(ticks == fireRate)
        {
            shoot();
            ticks = 0;
        }
        for(int i = 0; i < laserCounter; i++)
        {
           lasers[i].tick();

        }
        if(x < 0)
        {
            velX *= -1;
            y += height + 2;
        }
        else if(x > Reference.WIDTH)
        {
            velX *= -1;
            y += height + 2;
        }
    }

    @Override
    public void render(Graphics g)
    {
        if(!destroyed )
        {
            g.setColor(color);
//            g.fillRect(x,y,width,height);
            g.drawImage(Images.alien, x, y, width, height, null);
            for(int i = 0; i < laserCounter; i++)
            {
                lasers[i].render(g);

            }
        }
    }
    public void shoot()
    {
        Laser laser = new Laser(x, y, 5, 10, Color.RED, false);
        laser.setVelY(10);

        if(laserCounter >= lasers.length)
        {

            laserCounter = 0;
        }

        lasers[laserCounter] = laser;
        laserCounter++;
    }
}
