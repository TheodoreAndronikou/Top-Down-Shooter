import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Enemy
{   
    int timesHit = 0;
    /**
     * Act - do whatever the Enemy2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveEnemy();
        removeEnemy();
        hitByProjectile();
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
        }
        if(timesHit ==2){
            getWorld().removeObject(this);            
        }
        else if(getY()==599){
            World world = getWorld();
            HealthBar healthbar = null;
            
            if (world instanceof MyWorld) {
                healthbar = ((MyWorld) world).getHealthBar();
            } 
            else if (world instanceof BossWorld) {
                healthbar = ((BossWorld) world).getHealthBar();
            }
            
            if (healthbar != null) {
                healthbar.loseHealth();
                healthbar.loseHealth();
            }

            getWorld().removeObject(this);
        }
    }
}
