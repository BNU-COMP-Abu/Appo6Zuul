import java.util.ArrayList;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private String name; 
    private int score;
    private int health; 
    private ArrayList <Items> items; 
    
    public Player(String name)
    {
        score = 0;
        health = 100;
        items = new ArrayList <Items> ();
      
    }
}
