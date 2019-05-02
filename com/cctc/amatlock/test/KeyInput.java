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
            ship.setVelX(-2);
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            ship.setVelX(2);
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
        else if(e.getKeyCode() == KeyEvent.VK_SPACE )
        {
            ship.shoot();
        }
    }
}
