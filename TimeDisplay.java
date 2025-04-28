import greenfoot.*;

public class TimeDisplay extends Actor
{
    SimpleTimer gameTimer;
    int totalTime; // σε milliseconds

    public TimeDisplay(SimpleTimer timer, int totalTime)
    {
        this.gameTimer = timer;
        this.totalTime = totalTime;
        updateImage();
    }

    public void act()
    {
        updateImage();
    }

    private void updateImage()
    {
        int timeLeft = (totalTime - gameTimer.millisElapsed()) / 1000;
        if (timeLeft < 0) {
            timeLeft = 0;
        }
        setImage(new GreenfootImage("Time Left: " + timeLeft + "s", 30, Color.YELLOW, Color.BLACK));
    }
}
