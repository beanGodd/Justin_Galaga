package com.cctc.amatlock.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener
{
    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        Spaceship ship = Screen.getInstance().ship;

        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            ship.setVelX(-4);
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            ship.setVelX(4);
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE )
        {
            ship.shoot();
        }
        else if(e.getKeyCode() == KeyEvent.VK_R )
        {
            Screen.getInstance().reset();
        }
        else if(e.getKeyCode() == KeyEvent.VK_S)
        {
            Screen.getInstance().difficulty++;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
       Spaceship ship = Screen.getInstance().ship;

        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            ship.setVelX(0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            ship.setVelX(0);
        }
    }
}
