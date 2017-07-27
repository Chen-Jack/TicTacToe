
package main;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.stage.Modality;

//Window Layout
//Row 1: Please Enter the names of the following players.
//Row 2: Player 1(X)  ||  Player2(O)
//       [Text Block] ||  [Text Block]
//Row 4: Confirm Button

public class OpenScreen {
    
    public static void promptName(){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        VBox layout = new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        
        //Row1
        Label row1 = new Label("Please enter the names of the "
                + "following players.");
        layout.getChildren().add(row1);
        
        //Row 2 (Two nested VBox within this HBox;
        HBox row2 = new HBox();
        
        VBox p1col = new VBox();        //player 1 column
        p1col.getChildren().add(new Label("Player 1(X)"));
        TextField p1Entry = new TextField();
        p1col.getChildren().add(p1Entry);
        
        VBox p2col = new VBox();        //player 2 column.
        p2col.getChildren().add(new Label("Player 2 (O)"));
        TextField p2Entry = new TextField();
        p2col.getChildren().add(p2Entry);
        
        row2.getChildren().add(p1col);
        row2.getChildren().add(p2col);
        
        layout.getChildren().add(row2);
        
        //Row 3;
        Button confirmButton = new Button("Start Game");
        layout.getChildren().add(confirmButton);
        confirmButton.setOnAction(e -> {
            if(p1Entry.getText().length() == 0 || 
                    p2Entry.getText().length() == 0){
                //Do nothing. Wait until they give a valid name.
            }
            else{
                Operation.setP1Name(p1Entry.getText());
                Operation.setP2Name(p2Entry.getText());
                stage.close();
            }
        });
        
        
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }
    
}
