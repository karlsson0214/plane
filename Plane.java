import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tank here.
 * 
 * @author Rikard Karlsson
 * @version 2019-11-14
 */
public class Plane extends Actor
{
    private int timeToReload = 0;
    private Rocket leftRocket;
    private Rocket rightRocket;
    
    public void act() 
    {
        CheckKeyboard();
    } 
    public void addRockets(Rocket leftRocket, Rocket rightRocket)
    {
        this.leftRocket = leftRocket;
        this.rightRocket = rightRocket;
        getWorld().addObject(leftRocket, getX(), getY());
        getWorld().addObject(rightRocket, getX(), getY());
        positionRockets();
    }
    private void CheckKeyboard()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            turn(-5);
            positionRockets();
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            turn(5);
            positionRockets();
        }
        if (Greenfoot.isKeyDown("space"))
        {
            shootBullet();
        }
        if (Greenfoot.isKeyDown("L"))
        {
            shootLeftRocket();
        }
        if (Greenfoot.isKeyDown("R"))
        {
            shootRightRocket();
        }
        timeToReload = timeToReload - 1;
   }
   private void shootBullet()
   {
       if (timeToReload <= 0)
       {
           Bullet bullet = new Bullet();
           bullet.setRotation(getRotation());
           getWorld().addObject(bullet, getX(), getY());
           timeToReload = 10;
       }
   }
   private void shootLeftRocket()
   {
       if (leftRocket != null)
       {
           leftRocket.start();
           leftRocket = null;
       }
   }
   private void shootRightRocket()
   {
       if (rightRocket != null)
       {
           rightRocket.start();
           rightRocket = null;
       }
       
   }
   private void positionRockets()
   {
       if (leftRocket != null)
       {
           int leftX = getX() + (int)(40 * Math.sin(getRotation() * Math.PI / 180.0));
           // a bit forward
           leftX += (int)(8 * Math.cos(getRotation() * Math.PI / 180.0));
           int leftY = getY() - (int)(40 * Math.cos(getRotation() * Math.PI / 180.0));
           // a bit forward
           leftY += (int)(8 * Math.sin(getRotation() * Math.PI / 180.0));
           leftRocket.setLocation(leftX, leftY);
           leftRocket.setRotation(getRotation());
       }
       
       if (rightRocket != null)
       {
           int rightX = getX() - (int)(40 * Math.sin(getRotation() * Math.PI / 180.0));
           // a bit forward
           rightX += (int)(8 * Math.cos(getRotation() * Math.PI / 180.0));
           int rightY = getY() + (int)(40 * Math.cos(getRotation() * Math.PI / 180.0));
           // a bit forward
           rightY += (int)(8 * Math.sin(getRotation() * Math.PI / 180.0));
           rightRocket.setLocation(rightX, rightY);
           rightRocket.setRotation(getRotation());
       }
       
   }
}
