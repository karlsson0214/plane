import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Rikard Karlsson
 * @version 2019-11-14
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        setPaintOrder(Plane.class, Rocket.class);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Plane plane = new Plane();
        addObject(plane,300,200);
        Rocket leftRocket = new Rocket();
        Rocket rightRocket = new Rocket();
        
        plane.addRockets(leftRocket, rightRocket);
        
    }
}
