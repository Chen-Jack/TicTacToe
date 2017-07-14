package main;

//This class has stuff that deals with the board layout.

import java.util.Iterator;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Board {
    Mechanics mechanics = new Mechanics();
    
    public GridPane createBoard(){      
        GridPane layout = new GridPane();    
        layout.setPadding(new Insets(10,10,10,10));
        layout.setVgap(10);
        layout.setHgap(10);
                     
        for(int col = 0; col < 3; col++){             //row
            for(int row = 0; row < 3; row++){         //column                
                layout.add(new Button(" "), row, col);
            }
        }
        
        ObservableList<Node> buttonList = layout.getChildren();
        Iterator iterator = buttonList.iterator();
        while(iterator.hasNext()){
            Button buffer = (Button)iterator.next();
            buffer.setMinSize(50, 50);
        }
        
        setButtonFunction(layout);
        return layout;
        
    }
    
    private <T extends Pane> void setButtonFunction(T board){
        ObservableList<Node> buttonList = board.getChildren();
        Iterator iterator = buttonList.iterator();
        while(iterator.hasNext()){
            Button button = (Button)iterator.next();
            button.setMinSize(50, 50);
            button.setOnAction(e -> {
                button.setText(mechanics.getCurrentPlayer().symbol);
                button.setMouseTransparent(true);
                checkBoard(board);
                mechanics.switchCurrentPlayer();
            });
        }
        
    }
    
    private <T extends Pane> void checkBoard(T scheme){        
        ObservableList<Node> buttonList = scheme.getChildren();
        Button[] boardState = buttonList.toArray(new Button[9]);
        Player[] roster = mechanics.getPlayers();
        
        checkHorizontalWin(boardState, roster);
        checkVerticalWin(boardState, roster);
        checkDiagonalWin(boardState, roster);
        
    }
    
    
    private void checkVerticalWin(Button[] boardState, Player[] roster){
        for(Player player : roster){
            for(int i=0;i<3;i++){
                if(boardState[i].getText().equals(player.symbol)){
                    if(boardState[i+3].getText().equals(player.symbol)){
                        if(boardState[i+6].getText().equals(player.symbol)){
                            player.score++;
                            VictoryWindow.display(player);                       
                        }
                    }
                }
            }
        }        
    }
    
    private void checkHorizontalWin(Button[] boardState, Player[] roster){
        for(Player player : roster){
            for(int i=0; i<9; i+=3){
                if(boardState[i].getText().equals(player.symbol)){
                    if(boardState[i+1].getText().equals(player.symbol)){
                        if(boardState[i+2].getText().equals(player.symbol)){
                            player.score++;
                            VictoryWindow.display(player);  
                        }
                    }
                }
            }
        }
    }
    
    private void checkDiagonalWin(Button[] boardState, Player[] roster){
        for(Player player: roster){
            if(boardState[0].getText().equals(player.symbol)){
                if(boardState[4].getText().equals(player.symbol)){
                    if(boardState[8].getText().equals(player.symbol)){
                        player.score++;
                        VictoryWindow.display(player); 
                    }
                }

            }
            if(boardState[6].getText().equals(player.symbol)){
                if(boardState[4].getText().equals(player.symbol)){
                    if(boardState[2].getText().equals(player.symbol)){
                        VictoryWindow.display(player); 
                    }
                }
            }
        }
    }
    
}
