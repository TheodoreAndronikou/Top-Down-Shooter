import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossWorld extends World
{
    Counter counter;
    HealthBar healthbar;
    boolean bossSpawned = false;

    public BossWorld(int score, int health)
    {    
        super(600, 600, 1); 
        
        counter = new Counter();
        counter.setScore(score);
        addObject(counter, 60, 20);

        healthbar = new HealthBar();
        healthbar.setHealth(health);
        addObject(healthbar, 300, 50);

        prepare();
    }
    
    public void act()
    {
        if(!bossSpawned){
            int randomX = Greenfoot.getRandomNumber(600);
            addObject(new Enemy3(), randomX, 0);
            bossSpawned = true;
        }
    }
    
    private void prepare()
    {
        Player player = new Player();
        addObject(player, 300, 520);
    }
    
    public Counter getCounter(){
        return counter;
    }
    
    public HealthBar getHealthBar(){
        return healthbar;
    }

} 


