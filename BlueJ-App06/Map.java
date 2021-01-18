
/**
 * Write a description of class Map here.
 *
 * @author Zammar and Abu 
 * @version 0.1
 */
public class Map
{
    public Room gym, outside, theater, pub, lab, office, fireExit, parliament, accommodation, mcdonalds, kitchen, reception ;
    private Room startRoom;
    
    public Map()
    {
        createRooms();
    }
    
    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        
        // create the rooms
        outside = new Room("outside the main entrance of the university, your here but your late..");
        theater = new Room("you are in the theatre, you have missed the movies go to bed now!");
        pub = new Room("in the campus pub, your now wasted");
        lab = new Room("in a computing lab, stop playing games and learn something");
        office = new Room("in the computing admin office, recntly you been asking too many questions..");
        gym = new Room("in the gym there is a boxing ring, learn to punch and come back please..");
        fireExit = new Room("your at the back door of the gym and there is a drunkie");
        parliament = new Room("You are now in parliament, Boris is not here try harder!");
        accommodation = new Room("You are now in your accomodation, STOP MISSING LECTURES! ");
        mcdonalds = new Room("You are now in mcdonalds, GO AND COOK SOME FOOD");
        kitchen = new Room("You are now in the kitchen,Well done you cooked chicken");
        reception = new Room("You are at reception, they cannot answer any questions at this time...");
        
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("north", gym);
        outside.setExit("northEast", parliament);
        outside.setExit("southEast", accommodation);
        outside.setExit("southWest", mcdonalds);
        outside.setExit("northWest", kitchen);
        outside.setExit("insideUni", reception);
        
        reception.setExit("north", gym);
        reception.setExit("east", theater);
        reception.setExit("south", lab);
        reception.setExit("west", pub);
        
        kitchen.setExit("left", pub);
        kitchen.setExit("right", gym);
        
        mcdonalds.setExit("left", pub);
        mcdonalds.setExit("right", lab);
        
        gym.setExit("south", outside);
        gym.setExit("fireExit", fireExit);
        
        fireExit.setExit("inside", gym);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);
        
        parliament.setExit("left", gym);
        parliament.setExit("right", pub);
        
        accommodation.setExit("uni", outside);
        accommodation.setExit("getDrunk", pub);
        
        

        office.setExit("west", lab);

        startRoom = outside;  // start game outside
    }
    
    public Room getStartRoom()
    {
        return startRoom;
    }
    
}
