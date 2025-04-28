import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy3 extends Enemy
{
    //SimpleTimer
    SimpleTimer winTimer = new SimpleTimer();
    boolean winTriggered = false;
    
    int timesHit = 0;
    /**
     * Act - do whatever the Enemy3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (!winTriggered) {
            moveEnemy(); 
            removeEnemy();
            hitByProjectile();
        }
        else {
            if (winTimer.millisElapsed() > 10000) { // Μετά από 2 δευτερόλεπτα
                Greenfoot.stop();
            }
        }
        checkTouchPlayer();

    }
    
    public void hitByProjectile(){
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile != null){
            getWorld().removeObject(projectile);
    
            World world = getWorld();
            Counter counter = null;
            if (world instanceof MyWorld) {
                counter = ((MyWorld) world).getCounter();
            } 
            else if (world instanceof BossWorld) {
                counter = ((BossWorld) world).getCounter();
            }
    
            if (counter != null) {
                counter.addScore();
            }
    
            timesHit++; 
    
            if (timesHit == 10) {
                if (counter != null) {
                    counter.setImage(new GreenfootImage("Score:" + counter.getScore(), 35, Color.GREEN, Color.BLACK));
                }
                
                world.addObject(new Win(), 300, 300);
                winTriggered = true;
                winTimer.mark();
            }
        }
        else if (getY() == 599) {
            World world = getWorld();
            HealthBar healthbar = null;
    
            if (world instanceof MyWorld) {
                healthbar = ((MyWorld) world).getHealthBar();
            } 
            else if (world instanceof BossWorld) {
                healthbar = ((BossWorld) world).getHealthBar();
            }
    
            if (healthbar != null) {
                for (int i = 0; i <= 9; i++) {
                    healthbar.loseHealth();
                }
                
                if (healthbar.getHealth() > 0) {
                    world.addObject(new Lose(), 300, 300);
                    Greenfoot.stop();
                }
            }
            world.addObject(new Lose(), 300, 300);
            Greenfoot.stop();
            getWorld().removeObject(this);
        }
    }
    @Override
    public void checkTouchPlayer()
    {
        if (getWorld() == null) {
            return; 
        }
    
        Actor player = getOneIntersectingObject(Player.class);
        if (player != null) {
            World world = getWorld();
            world.addObject(new Lose(), 300, 300);
            Greenfoot.stop();
        }
    }

}
