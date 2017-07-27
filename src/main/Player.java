package main;

//Player struct that contains each players attributes

public class Player {
    public String name;         //I should make this private, but im lazy
    public Integer score;
    public String symbol;              
    
    Player(){
        this.score = 0;
    }
    
    Player(String name, String symbol){
        this.name = name;
        this.score = 0;
        this.symbol = symbol;
    }
    
    Player(String name){
        this.name = name;
    }
    
}
