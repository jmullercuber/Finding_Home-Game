import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends NPC
{
    static String[] names = {
        "Snoop",
        "Bob",
        "Jim",
        "Joey",
        "Ian",
        "Steff",
        "Victor",
        "Zahir",
        "Lena",
        "Greagory",
        "Corelli",
        "John",
        "Thomas",
        "Anthony",
        "Leo",
        "Lena",
        "Berns",
        "Michael",
        "Richard",
        "Daniel",
        "George",
        "Steven",
        "David",
        "Jared",
        "Eric",
        "Jordan",
        "Mary",
        "Maria",
        "Deborah",
        "Hillary",
        "Bush",
        "Ryan",
        "Donald",
        "Sanders",
        "Jeb",
        "Christie",
        "Chris",
        "Biden",
        "Austin",
        "Chafee",
        "O'Malley",
        "Trump",
        "Webb",
        "Martin",
        "Carson",
        "Adams",
        "Everson",
        "Graham",
        "Huck",
        "King",
        "Caesar",
        "Marcus",
        "Roi",
        "PK Thunder",
        "X",
        "Amour",
        "Lin",
        "Joyce",
        "Oboey",
        "Robbie",
        "Lindsey",
        "Jared",
        "Hailey",
        "Ryssa",
        "Ren",
        "Jalen",
        "Hamrick",
        "Eliza",
        "Jay",
        "Bennish",
        "Jones"
    };
    
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
        drift();
    }
    
    public Text()
    {
        generateName();
    }
    
    public void generateName(){
        int rand = Greenfoot.getRandomNumber(names.length);
        setImage(new GreenfootImage(names[rand], 12, Color.WHITE, Color.BLACK));
    }
}