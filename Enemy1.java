import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends Enemy
{
    /**
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Enemy1(){
        setRotation(90);
        
    }
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

            getWorld().removeObject(this);
        }else if(getY()==599){
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
            }

            getWorld().removeObject(this);
        }
    }
    
}
