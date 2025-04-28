import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartWorld extends World
{

    /**
     * Constructor for objects of class StartWorld.
     * 
     */
    public StartWorld()
    {    
        super(600, 600, 1); 

        // Background άσπρο για καλύτερη αντίθεση
        setBackground(new GreenfootImage(600, 600));
        getBackground().setColor(Color.WHITE);
        getBackground().fill();
        
        // Γράφουμε τον τίτλο
        GreenfootImage title = new GreenfootImage("Σκοπός: Εξολόθρευσε τους εχθρούς και νίκησε το boss!", 30, Color.BLUE, new Color(0,0,0,0));
        getBackground().drawImage(title, 0, 100);

        // Γράφουμε τις οδηγίες
        GreenfootImage instructions = new GreenfootImage("Οδηγίες:", 26, Color.BLACK, new Color(0,0,0,0));
        getBackground().drawImage(instructions, 250, 170);

        GreenfootImage move = new GreenfootImage("- Κινήσου με αριστερό και δεξί βελάκι", 22, Color.DARK_GRAY, new Color(0,0,0,0));
        getBackground().drawImage(move, 120, 220);

        GreenfootImage shoot = new GreenfootImage("- Πυροβόλησε με SPACE", 22, Color.DARK_GRAY, new Color(0,0,0,0));
        getBackground().drawImage(shoot, 120, 260);

        GreenfootImage health = new GreenfootImage("- ΣΗΜΑΝΤΙΚΟ: Πρόσεχε το healthbar και τον χρόνο σου!", 22, Color.DARK_GRAY, new Color(0,0,0,0));
        getBackground().drawImage(health, 120, 300);
        
        GreenfootImage loss = new GreenfootImage("- Χάνεις ζωή αν σου ξεφύγει ο εχθρός αλλά και αν συγκρουστείτε!", 20, Color.DARK_GRAY, new Color(0,0,0,0));
        getBackground().drawImage(loss, 120, 340);
        
        // Γράφουμε το "ΠΑΤΑ ENTER"
        GreenfootImage pressEnter = new GreenfootImage("Πάτα ENTER για να ξεκινήσεις!", 24, Color.RED, new Color(0,0,0,0));
        getBackground().drawImage(pressEnter, 150, 450);
    }

    public void act(){
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
