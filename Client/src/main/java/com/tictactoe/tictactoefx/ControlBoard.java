package com.tictactoe.tictactoefx;

import actions.GameApplication;
import actions.GameConfig;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import playerModel.Player;
import playerModel.PlayerList;
import playerModel.updateView;

public class ControlBoard implements Initializable {

    /*TableView Columns*/
    //Table 1 {User Specific}
    @FXML
    private TableView<Player> userTable;

    @FXML
    private TableColumn<Player, String> userNameColumnT1;
    @FXML
    private TableColumn<Player, String> scoreColumnT1;


    ObservableList<Player> currentUser = FXCollections.observableArrayList();


    @FXML
    private TableView<Player> allUsersTable;
    @FXML
    private TableColumn<Player, String> username;
    @FXML
    private TableColumn<Player, String> score;
//    @FXML
//    private TableColumn<Player, String> level;
    @FXML
    private TableColumn<Player, JFXButton> status;
    @FXML private Label usernameLabel , scoreValueLabel;

    //CSSing some components
    @FXML private Region  playersListRegion ;
    DropShadow mouseEnteredShadow = new DropShadow(); // GRAY Color ( onMouseEntered)
    DropShadow mouseExitedShadow = new DropShadow(); //WHITE Color (Default On and onMouseExited)
    


    @FXML
    private void vsPCbuttonClicked(ActionEvent event) throws IOException {
        //Transition to the GamePlay.fxml
        GameConfig.setMode(1);  // pc mode
        SwitchTo.DifficultySelectionScene(event);
    }


    @Override

    public void initialize(URL url, ResourceBundle rb) 
    {
        Player current = GameApplication.getplayerSocket().getPlayer();

        mouseEnteredShadow.setColor(Color.GRAY); //set the shadow color of the  Region.
        mouseExitedShadow.setColor(Color.WHITE);



        
        usernameLabel.setText(current.getPlayerName());
        scoreValueLabel.setText( String.valueOf(current.getPlayerScore()));

        username.setCellValueFactory(new PropertyValueFactory<>("name"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
//        level.setCellValueFactory(new PropertyValueFactory<>("level"));
        allUsersTable.setItems(updateView.GetObservable());
    }
    
 
        private void changeRegionColor(Region region,  DropShadow shadowType)
        {
            region.setEffect(shadowType);
        }
    
         //Floating effect for PlayersList Region
            @FXML private void playersListRegionMouseEntered(MouseEvent event)
            {
                changeRegionColor(playersListRegion, mouseEnteredShadow);
            }
            
            @FXML private void playersListRegionMouseExited(MouseEvent event)
            {
                changeRegionColor(playersListRegion, mouseExitedShadow);
            }
    

}
