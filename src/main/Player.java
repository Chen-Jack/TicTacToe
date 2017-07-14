package main;

//Player struct that contains each players attributes

public class Player {
    String name;
    int score;
    String symbol;              //This needs to be a string and not a char
                                //because the button press sets the icon to the
                                //player's symbol.which doesnt work if its  a char.
    
    Player(String name, String symbol){
        this.name = name;
        score = 0;
        this.symbol = symbol;
    }
}
