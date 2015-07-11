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
    int name;
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
        name = Greenfoot.getRandomNumber(70);
        if(name == 1){
            setImage(new GreenfootImage("Bob", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 2){
            setImage(new GreenfootImage("Jim", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 3){
            setImage(new GreenfootImage("Joey", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 4){
            setImage(new GreenfootImage("Ian", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 5){
            setImage(new GreenfootImage("Steff", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 6){
            setImage(new GreenfootImage("Victor", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 7){
            setImage(new GreenfootImage("Zahir", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 8){
            setImage(new GreenfootImage("Lena", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 9){
            setImage(new GreenfootImage("Greagory", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 10){
            setImage(new GreenfootImage("Corelli", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 14){
            setImage(new GreenfootImage("Lena", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 15){
            setImage(new GreenfootImage("Berns", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 11){
            setImage(new GreenfootImage("John", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 16){
            setImage(new GreenfootImage("Michael", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 17){
            setImage(new GreenfootImage("Richard", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 12){
            setImage(new GreenfootImage("Thomas", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 13){
            setImage(new GreenfootImage("Leo", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 18){
            setImage(new GreenfootImage("Daniel", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 19){
            setImage(new GreenfootImage("George", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 12){
            setImage(new GreenfootImage("Anthony", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 21){
            setImage(new GreenfootImage("Steven", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 22){
            setImage(new GreenfootImage("David", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 23){
            setImage(new GreenfootImage("Jared", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 24){
            setImage(new GreenfootImage("Eric", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 25){
            setImage(new GreenfootImage("Jordan", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 26){
            setImage(new GreenfootImage("Mary", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 27){
            setImage(new GreenfootImage("Maria", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 28){
            setImage(new GreenfootImage("Deborah", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 29){
            setImage(new GreenfootImage("Hillary", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 30){
            setImage(new GreenfootImage("Bush", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 33){
            setImage(new GreenfootImage("Sanders", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 31){
            setImage(new GreenfootImage("Clinton", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 41){
            setImage(new GreenfootImage("Trump", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 32){
            setImage(new GreenfootImage("Donald", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 34){
            setImage(new GreenfootImage("Jeb", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 35){
            setImage(new GreenfootImage("Christie", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 36){
            setImage(new GreenfootImage("Chris", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 37){
            setImage(new GreenfootImage("Biden", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 38){
            setImage(new GreenfootImage("Barack", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 39){
            setImage(new GreenfootImage("Chafee", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 40){
            setImage(new GreenfootImage("O'Malley", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 42){
            setImage(new GreenfootImage("Webb", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 43){
            setImage(new GreenfootImage("Martin", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 44){
            setImage(new GreenfootImage("Carson", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 45){
            setImage(new GreenfootImage("Cruz Sux", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 46){
            setImage(new GreenfootImage("Everson", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 47){
            setImage(new GreenfootImage("Graham", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 48){
            setImage(new GreenfootImage("Huck", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 49){
            setImage(new GreenfootImage("King", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 51){
            setImage(new GreenfootImage("Marcus", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 53){
            setImage(new GreenfootImage("PK Thunder", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 0){
            setImage(new GreenfootImage("Snoop", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 54){
            setImage(new GreenfootImage("X", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 52){
            setImage(new GreenfootImage("GOAT", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 55){
            setImage(new GreenfootImage("Amour", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 50){
            setImage(new GreenfootImage("Caesar", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 56){
            setImage(new GreenfootImage("$5 Footlong", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 57){
            setImage(new GreenfootImage("Insert Name Here", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 58){
            setImage(new GreenfootImage("Oboey", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 59){
            setImage(new GreenfootImage("Robbie", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 60){
            setImage(new GreenfootImage("Lindsey", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 61){
            setImage(new GreenfootImage("Jared", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 62){
            setImage(new GreenfootImage("Hailey", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 63){
            setImage(new GreenfootImage("Ryssa", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 64){
            setImage(new GreenfootImage("Ren", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 65){
            setImage(new GreenfootImage("Jalen", 12, Color.BLACK, Color.BLACK));
        }
        if(name == 66){
            setImage(new GreenfootImage("Hamrick", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 67){
            setImage(new GreenfootImage("Eliza", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 68){
            setImage(new GreenfootImage("Jay", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 69){
            setImage(new GreenfootImage("Bennish", 12, Color.WHITE, Color.BLACK));
        }
        if(name == 70){
            setImage(new GreenfootImage("Jones", 12, Color.WHITE, Color.BLACK));
        }
    }
   
        
    }
    
    

    

    

