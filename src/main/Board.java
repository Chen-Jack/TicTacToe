package main;

//This class has stuff that deals with the board layout and asthetics.

import java.util.Iterator;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class Board {
    private static GridPane layout;
    
    //Initializes the asthetics of the board and the button function
    public static void initBoard(){     
        layout = new GridPane();
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
        
        setButtonFunction();
        
    }
    
    private static void setButtonFunction(){
        ObservableList<Node> buttonList = layout.getChildren();
        
        Iterator iterator = buttonList.iterator();
        while(iterator.hasNext()){
            Button button = (Button)iterator.next();
            button.setMinSize(50, 50);
            button.setOnAction(e -> {
                button.setText(Operation.getCurrentPlayer().symbol);
                button.setMouseTransparent(true);
        
                Operation.incrementTurn();
                
                //The following method checks the board to see if 
                //Player1 or Player2 won on each button press.
                WinCondition.check(layout, Operation.getPlayer1(), 
                        Operation.getPlayer2());
                Operation.switchCurrentPlayer();           
            });
        }
    }
    
 
    public static GridPane getBoard(){
        return layout;
    }
    
    
    public static void clearBoard(){
        ObservableList<Node> buttonList = layout.getChildren();
        Iterator iterator = buttonList.iterator();
        while(iterator.hasNext()){
            Button buffer = (Button)iterator.next();
            buffer.setText(" "); 
            buffer.setMouseTransparent(false);
        }
        
    }
}

    
    

    
    
 