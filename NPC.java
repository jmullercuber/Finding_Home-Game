import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class NPC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NPC extends Actor
{
    private int movin = 0;
    private int movinUp = 0;
    private int movinDown = 0;
    private int movinRight = 0;
    private int movinLeft = 0;
    int a = 0;
    int bulletDelay;
    private int name;

    
    /**
     * Act - do whatever the NPC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        

            
        npcshoot();
        movement();
        drift();
        engineStatus();
        Actor asteroid = getOneIntersectingObject(Asteroid.class);
        if(asteroid != null){
            getWorld().addObject(new Explosion(), getX(), getY());
            generateDeathline();
            Greenfoot.delay(100);
            getWorld().removeObject(this);
        }
        if(a == 0) {
            getWorld().addObject(new NPCText(), getX(), getY() - 15);
            a = 1;
        }
    }    

    public NPC()
    {
       
        
        bulletDelay = 10;
        
    }
  
    
    /**
     * Depending on the last direction of the player, the ship will continue to "drift" in that direction.
     */
    public void drift()
    {
        if (movinUp == 1) {
            setLocation(getX(), getY() - 1);
        }
        if (movinDown == 1) {
            setLocation(getX(), getY() + 1);
        }
        if (movinRight == 1) {
            setLocation(getX() + 1, getY());
        }
        if (movinLeft == 1) {
            setLocation(getX() - 2, getY());
        }
    }
    public void engineStatus()
    {
         if ( Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d") )
         {
             setImage("Ship Engine On.png");
         }
         else
         {
             setImage("Ship Engine Off.png");
         }
    }
    public void movement()
    {
        if ( (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) && !(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) )
        {
            setLocation(getX() + 2, getY());
            //setImage("Ship Engine On.png");
            GreenfootImage image = getImage();
            //image.scale(image.getWidth() - 350, image.getHeight() - 60);
            setImage(image);
            movin = 1;
            movinRight = 1;
            movinUp = 0;
            movinDown = 0;
            movinLeft = 0;
            //change image to Engine On, else Engine Off
        }
        else if ( (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) && !(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) )
        {
            setLocation(getX() - 2, getY());
            //setImage("Ship Engine Off.png");
            GreenfootImage image = getImage();
            //image.scale(image.getWidth() - 260, image.getHeight() - 53);
            setImage(image);
            movinLeft = 1;
            movinUp = 0;
            movinDown = 0;
            movinRight = 0;
        }
        if ( (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) && !(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) )
        {
            setLocation(getX(), getY() - 3);
            movin = 1;
            movinUp = 1;
            movinLeft = 0;
            movinDown = 0;
            movinRight = 0;
        }
        else if ( (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) && !(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) )
        {
            setLocation(getX(), getY() + 3);
            movin = 1;
            movinDown = 1;
            movinUp = 0;
            movinLeft = 0;
            movinRight = 0;
        }
        if (movin == 0) {
            //setImage("Ship Engine Off.png");
            GreenfootImage image = getImage();
            //image.scale(image.getWidth() - 260, image.getHeight() - 53);
            setImage(image);

        }
        movin = 0;
    }
    public void generateDeathline(){
        name = Greenfoot.getRandomNumber(10);
        if(name == 1){
            setImage(new GreenfootImage("To Hell", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 2){
            setImage(new GreenfootImage("I forgive", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 3){
            setImage(new GreenfootImage("All of us had a reason to find home", 20, Color.WHITE, Color.BLACK));
        }
        if(name == 4){
            setImage(new GreenfootImage("Home remembers", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 5){
            setImage(new GreenfootImage("I understand.", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 6){
            setImage(new GreenfootImage("I lived.", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 8){
            setImage(new GreenfootImage("Must the End justify my death to you?", 20, Color.WHITE, Color.BLACK));
        }
        if(name == 9){
            setImage(new GreenfootImage("I'm sorry.", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 10){
            setImage(new GreenfootImage("Home, now Forever distant.", 20, Color.WHITE, Color.BLACK));
        }
    }

    /**
     * The NPC ship needs to be able to move on its own according to where the asteroids are around it
     * Basically it can't move randomllu, it has to be somewhat smart about it.
     */
    public void npcshoot()
    {
        if (bulletDelay == 0) {
            getWorld().addObject(new Bullet(), getX() + 50, getY());

            bulletDelay = Greenfoot.getRandomNumber(200);

        }
        if (bulletDelay > 0) {
            bulletDelay --;
        }
    }
}