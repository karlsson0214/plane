import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author Rikard Karlsson
 * @version 2019-11-14
 */
public class Rocket extends Actor
{
    private int speed = 0;
    
    public Rocket()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() * 8 / 10, image.getHeight() * 8 / 10);
    }
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(speed);
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }    
    public void start()
    {
        speed = 20;
    }
}
