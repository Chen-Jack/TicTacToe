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
        Mechanics mechanics = new Mechanics(); 
        
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
    
    private <T extends Pane> void setButtonFunction(T scheme){
        ObservableList<Node> buttonList = scheme.getChildren();
        Iterator iterator = buttonList.iterator();
        while(iterator.hasNext()){
            Button button = (Button)iterator.next();
            button.setMinSize(50, 50);
            button.setOnAction(e -> {
                button.setText(mechanics.currentPlayer);
                button.setMouseTransparent(true);
                checkBoard(scheme);
                mechanics.switchCurrentPlayer();
            });
        }
        
    }
    
    public <T extends Pane> void checkBoard(T scheme){        
        ObservableList<Node> buttonList = scheme.getChildren();
        Button[] boardState = buttonList.toArray(new Button[9]);
        //Checking horizontal win
        checkHorizontalWin(boardState, "X");
        checkHorizontalWin(boardState, "O");
        checkVerticalWin(boardState, "X");
        checkVerticalWin(boardState, "O");
        checkDiagonalWin(boardState, "X");
        checkDiagonalWin(boardState, "O");
        
    }
    
    private void checkVerticalWin(Button[] buttonArray, String player){
        for(int i=0;i<3;i++){
            if(buttonArray[i].getText().equals(player)){
                if(buttonArray[i+3].getText().equals(player)){
                    if(buttonArray[i+6].getText().equals(player)){
                        System.out.println(player + " Won!");
                        
                    }
                }
            }
        }        
    }
    
    private void checkHorizontalWin(Button[] buttonArray, String player){
        for(int i=0; i<9; i+=3){
            if(buttonArray[i].getText().equals(player)){
                if(buttonArray[i+1].getText().equals(player)){
                    if(buttonArray[i+2].getText().equals(player)){
                        System.out.println(player + " Won!"); 
                    }
                }
            }
        }
    }
    
    private void checkDiagonalWin(Button[] buttonArray, String player){
        if(buttonArray[0].getText().equals(player)){
            if(buttonArray[4].getText().equals(player)){
                if(buttonArray[8].getText().equals(player)){
                    System.out.println(player + " Won!");
                }
            }
                
        }
        if(buttonArray[6].getText().equals(player)){
            if(buttonArray[4].getText().equals(player)){
                if(buttonArray[2].getText().equals(player)){
                    System.out.println(player + " Won!");
                }
            }
        }
    }
    
}
