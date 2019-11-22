import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    public Bullet()
    {
        getImage().scale(10, 10);
    }
    public void act() 
    {
        move(20);
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }    
}
