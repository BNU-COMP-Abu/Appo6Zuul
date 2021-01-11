
/**
 * Write a description of class Map here.
 *
 * @author Zammar
 * @version 0.1
 */
public class Map
{
    public Room gym, outside, theater, pub, lab, office, fireExit, parliment ;
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
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        gym = new Room("in the gym there is a boxing ring");
        fireExit = new Room("your at the back door of the gym and there is a drunkie");
        parliment = new Room("You are now in parliment, Borris is not here try harder!");
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("north", gym);
        outside.setExit("northEast", parliment);
        
        gym.setExit("south", outside);
        gym.setExit("fireExit", fireExit);
        
        fireExit.setExit("inside", gym);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);
        
        parliment.setExit("left", gym);
        parliment.setExit("right", pub);
        
        

        office.setExit("west", lab);

        startRoom = outside;  // start game outside
    }
    
    public Room getStartRoom()
    {
        return startRoom;
    }
    
}
