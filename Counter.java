import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    int score = 0;
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Counter(){
        setImage(new GreenfootImage("Score:" + score, 35, Color.GREEN, Color.BLACK));    
        
    }
    
    public void act()
    {
        setImage(new GreenfootImage("Score:" + score, 35, Color.GREEN, Color.BLACK));
        youwin();
    }
    public void addScore(){
        score++;
    }
    public void youwin(){
        if(score ==35){
            getWorld().addObject(new Win(), 300, 300);
            Greenfoot.stop();
        }
    }
    public void setScore(int s){
        score = s;
    }
    public int getScore(){
        return score;
    }
}
