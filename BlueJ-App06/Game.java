/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Abu Ahmed
 */

public class Game 
{
    private Parser parser;
    
    private Room currentRoom;
    
    private Map map;
    
    private Player player;
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        parser = new Parser();
        map = new Map();
        currentRoom = map.getStartRoom();
        player = new Player("Bob");
    }


    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        
        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
        System.out.println("Leaving soo soon? Couldnt take up the challenge? ");
        System.out.println("Oh well mate Thanks for Playing! See you next time:)");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul - Boris Edition!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game full of new things to discover.");
        System.out.println("Ground Rules! No talking, No TikTok dances and definitly no Boris Supporters!");
        System.out.println("First to hit 100 points before their health hits 0 wins!");
        System.out.println("Boris is worth 100 points so find him and you win instantly");
        System.out.println("But there are also other items you will run into that are worth different points");
        
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
                
            case DROP:
                dropItem(command);
                break;
               
            case PICKUP:
                pickupItem(command);
                break;
                
        }
        return wantToQuit;
    }

    // implementations of user commands:
    private void pickupItem(Command command)
    
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Which Item?");
            return;
        }
        
         String word = command.getSecondWord();
        Items item = convertFromString(word);
        
        //TO DO OTHER ITEMS 
        
        player.pickUpItem(item);
        currentRoom.removeItem();
        
    }
    
    private Items convertFromString(String word)
    {
        Items item = Items.NONE;
         if(word.equals("car"))
        {
            item = Items.CAR;
        }
        
        else  if(word.equals("phone"))
        {
            item = Items.PHONE;
        }
        else  if(word.equals("gun"))
        {
            item = Items.GUN;
        }
        else  if(word.equals("boris"))
        {
            item = Items.BORIS;
        }
        else if(word.equals("keys"))
        {
            item = Items.KEYS;
        }
        return item;
    }
    
    private void dropItem(Command command)
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Which Item?");
            return;
        }
        
        String word = command.getSecondWord();
        Items item = convertFromString(word);
        player.dropItem(item);
    }
    
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            moveBorris();
            player.decreaseHealth();
            player.showStatus();
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private void moveBorris()
    {
        if (player. getMoves() == 1 )
        {
            map.parliament.setItem(Items.BORIS);
        }
        
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
