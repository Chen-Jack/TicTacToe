package main;

//This class has stuff that deals with the board layout and asthetics.

import java.util.Iterator;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class Board {
    private final Operation gameOp;
    private final GridPane layout;
    
    public Board(){      
        gameOp = new Operation();     
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
        
        gameOp.setButtonFunction(layout);
        
    }
    
 
    public GridPane getBoardLayout(){
        return layout;
    }
    
    public Operation getBoardOperation(){
        return gameOp;
    }
    
    public static <GridPane extends Pane> void clearBoard(GridPane layout){
        ObservableList<Node> buttonList = layout.getChildren();
        Iterator iterator = buttonList.iterator();
        while(iterator.hasNext()){
            Button buffer = (Button)iterator.next();
            buffer.setText(" "); 
            buffer.setMouseTransparent(false);
        }
        
    }
}

    
    

    
    
 