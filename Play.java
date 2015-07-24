import greenfoot.*;

/**
 * Write a description of class play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends World
{
    public static Play play = new Play();
    
    Actor1 player;
    int bombChance = 1;
    //The chance of a new NPC being created.
    int chance = 1;
    public int asteroidDelay = 1;
    //Rate of creating new asteroid. The lower int difficulty, the higher the rate of new asteroids.
    int difficulty = 10;
    
    /**
     * Constructor for objects of class play.
     * 
     */
    public Play()
    {
        // Create a new world with 1008x630 cells with a cell size of 1x1 pixels.
        super(1008, 800, 1);
        
        addObject(new Asteroid(), 1500, Greenfoot.getRandomNumber(800));
        addObject(new actorText2(), 50, 400 - 15);
        player = new Actor1();
        addObject(player, 50, 400);
        addObject(new bombIcon(), 500, 400);
        addObject(new DistanceCounter(), 189, 38);
        addObject(new PointCounter(), 76, 81);
        //addObject(new asteroidSuper(), 0, 0);
        Explosion.initialiseImages();
        
    }
    
    public void act()
    {
        spawn();
    }
    
    public void spawn() {
        spawnBomb();
        createAsteroid();
        populateNPC();
        radioTrans();
    }

    public void spawnBomb()
    {
        if(bombChance == 1) {
            addObject(new bombIcon(), 1008, Greenfoot.getRandomNumber(850));
        }
        bombChance = Greenfoot.getRandomNumber(1200);
    }

    /** 
     * Decides when to create asteroids. Rate of creation dependent on int difficulty.
     */
    public void createAsteroid()
    {
        if(asteroidDelay > 0){
            asteroidDelay--;
            if (asteroidDelay == 0) {
                populate();
                asteroidDelay = difficulty;
            }
        }
    }

    /**
     * Creates new asteroid at random Y location.
     */
    public void populate()
    {
        addObject(new Asteroid(), 1008, Greenfoot.getRandomNumber(850));
    }
    
    /**
     * Creates new NPC/ Probability of new NPC.
     */
    public void populateNPC()
    {
        if ( chance == 1 ) {
            addObject(new NPC(), player.getX() - Greenfoot.getRandomNumber(200) , player.getY() + Greenfoot.getRandomNumber(100) );
        }
        chance = Greenfoot.getRandomNumber(10000);
    }

    private void radioTrans()
    {
        if (player.timer == 15000) {
            addObject(new Radio(), 1008, 400);
        }
        if (player.timer == 23000) {  
            addObject(new Patrol(), 1008, 400);
        }
    }
}
