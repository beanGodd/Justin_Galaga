package com.cctc.amatlock.test;

import java.awt.*;

public class Laser extends CoreObject
{
    public boolean ally;
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
    public Laser(int x, int y, int width, int height, Color color, boolean ally)
    {
        super(x, y, width, height, color);
        this.ally = ally;
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
        Spaceship ship = Screen.getInstance().ship;
      if(ally)
      {
          CoreObject[] coreObjects = Screen.getCoreObjects();


          for(int i = 0; i < Screen.getObjectCounter(); i++)
          {
              CoreObject object = coreObjects[i];

              if( intersects(object) && !object.destroyed)
              {
                  object.destroy();
                  destroy();
                  ship.score += 5;
                  System.out.println("score: "+ ship.score);

              }


          }
      }
      else
      {
          if(ship.x > x && Screen.getInstance().difficulty > 1)
          {
              velX += 0.5;
          }
          else if ( Screen.getInstance().difficulty > 1)
          {
              velX -= 0.5;
          }
          if(intersects(ship))
          {
              ship.destroy();
          }
      }

    }

    @Override
    public void render(Graphics g)
    {
        if(!destroyed )
        {
            g.setColor(color);
            g.fillRect(x,y,width,height);
        }
    }
}
