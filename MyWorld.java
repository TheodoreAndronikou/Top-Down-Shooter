import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    HealthBar healthbar = new HealthBar();
    Counter counter = new Counter();
    boolean bosslvl = false;
    
    SimpleTimer gameTimer = new SimpleTimer();
    int totalTime = 25000;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        prepare();
        
        TimeDisplay timeDisplay = new TimeDisplay(gameTimer, totalTime);
        addObject(timeDisplay, 500, 20); 
    }
    
    public Counter getCounter(){
        return counter;
    }
    
    public HealthBar getHealthBar(){
        return healthbar;
    }
    
    public void act(){ 
        addEnemy1();
        addEnemy2();
        if(counter.score == 25){
            Greenfoot.setWorld(new BossWorld(counter.score, healthbar.health));
        }
        if (gameTimer.millisElapsed() > totalTime) {
            addObject(new Lose(), 300, 300);
            Greenfoot.stop();
        }

    }
    
    public void addEnemy1(){
        if(Greenfoot.getRandomNumber(100) < 1){
            addObject(new Enemy1(), Greenfoot.getRandomNumber(600),0);
        }
    }
    
    public void addEnemy2(){
        if(Greenfoot.getRandomNumber(120) < 1){
            addObject(new Enemy2(), Greenfoot.getRandomNumber(700),0);
        }
    }
    public void addEnemy3(){
    
        if(counter.score==25 || counter.score==26){
            if(bosslvl == false){
                addObject(new Enemy3(),300,0);
                bosslvl = true;
                Greenfoot.setWorld(new BossWorld(counter.getScore(), healthbar.getHealth()));

            }
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(counter,60,20);
        addObject(healthbar,300,50);
        Player player = new Player();
        addObject(player,266,520);
        player.setLocation(303,447);
    }
}
