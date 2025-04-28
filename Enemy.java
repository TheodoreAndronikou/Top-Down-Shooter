import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //add code
    }
    
    public void moveEnemy(){
         setLocation(getX(), getY() + 3);  
    }
    
    public void removeEnemy(){
    }
    
    public void checkTouchPlayer()
    {
        if (getWorld() == null) {
            return; 
        }
    
        Actor player = getOneIntersectingObject(Player.class);
        if (player != null) {
            World world = getWorld();
            HealthBar healthbar = null;
    
            if (world instanceof MyWorld) {
                healthbar = ((MyWorld) world).getHealthBar();
            } 
            else if (world instanceof BossWorld) {
                healthbar = ((BossWorld) world).getHealthBar();
            }
    
            if (healthbar != null) {
                for (int i = 0; i < 4; i++) {
                    healthbar.loseHealth();
                }
            }
    
            getWorld().removeObject(this);
        }
    }


}
