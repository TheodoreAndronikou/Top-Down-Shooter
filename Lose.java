import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lose here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lose extends Actor
{
    /**
     * Act - do whatever the Lose wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Lose() {
        Greenfoot.playSound("lose.wav");
        GreenfootImage image = getImage();
        image.scale((int)(image.getWidth() * 0.2), (int)(image.getHeight() * 0.2));
        setImage(image);
        
    }
    public void act()
    {
        // Add your action code here.
    }
}
