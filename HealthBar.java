import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int health = 20;
    int healthBarWidth = 80;
    int healthBarHeight = 10;
    int pixelsPerHealthPoint = (int)healthBarWidth/health;
    public HealthBar(){
        update();
    }
    
    public void act()
    {
      update();
      youlose();
    }

    public void update(){
        setImage(new GreenfootImage(healthBarWidth,healthBarHeight));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0,0,healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1,1,health*pixelsPerHealthPoint,healthBarHeight);
        
    }
    public void loseHealth(){
        health--;
        health--;
    }
    
    public void youlose(){
        if(health<=0){
            getWorld().addObject(new Lose(), 300, 300);
            Greenfoot.stop();
        }
    }
    
    public void setHealth(int h){
        health = h;
    }
    public int getHealth(){
        return health;
    }
}
