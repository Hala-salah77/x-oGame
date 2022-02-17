/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playerModel;


import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import player.PlayerHandler;

import java.io.IOException;

public class Player {
    private int id; // autoGenerate in database
    private SimpleStringProperty name;
    private String uname;
    private String password; //it's a VARCHAR in database with size (32)
    private String email;
    private int status; // it's a ENUM in database which contain offline(0), online(1), busy(2)
    private int score;
    public JFXButton btn = new JFXButton();
    // constructor used for GUI only

    public Player(String username, String userPassword, String userEmail){
        name = new SimpleStringProperty(username);
        uname = username;
        password = userPassword;
        email = userEmail;
        status = 0; // offline as initial
        score = 0; // as initial value
    }
    public String getName() {
        return name.get();
    }

    public void setName(String n){
        name.set(n);
    }

    public Player(String name, int status, int score) {
        this.name = new SimpleStringProperty(name);
        this.status = status;
        this.score = score;
    }

    public JFXButton getStatus(){
        if(status==0){
            btn.setStyle("-fx-background-color: #F8327E;");
            btn.setText("Offline");
            btn.setDisable(true);
            return btn;
        }
        else if (status==1){
            btn.setStyle("-fx-background-color: #54dfc4;");
            btn.setText("Online");
            return btn;
        }
        btn.setStyle("-fx-background-color: #f09b13;");
        btn.setDisable(true);
        btn.setText("Busy");
        return btn;
    }
    public String getScore(){
        return Integer.toString(score);
    }


    // constructors used for retrieve in databaseManager only
    public Player(int userId, String username, String userPassword, String userEmil, int userStatus, int userScore){
        id = userId;
        uname = username;
        name = new SimpleStringProperty(username);
        email = userEmil;
        password = userPassword;
        status = userStatus;
        score = userScore;

    }

    public Player(){
        event();
    }

    // setDATA for player
    public void setPlayerName(String username){
        name = new SimpleStringProperty(username);
        uname = username;
    }
    public void setPlayerPassword(String userPassword){
            password = userPassword;

    }
    public void setPlayerEmail(String userEmail){

            email = userEmail;

    }
    public void setPlayerStatus(int userStatus){
        status = userStatus;
    }
    public void setPlayerScore(int userScore){
        score = userScore;
    }
 

    // getDATA for player
    public int getID(){
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
    public String getPlayerName(){
        return uname;
    }
    public String getPlayerPassword(){
        return password;
    }
    public String getPlayerEmail(){
        return email;
    }
    public int getPlayerStatus(){
        return status;
    }
    public int getPlayerScore(){
        return score;
    }

    public void event(){
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    PlayerHandler.sendPlayRequest(id);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
