/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tictactoe.database.playerModel;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleStringProperty;


public class Player {
    private int id; // autoGenerate in database
    private SimpleStringProperty name;
    private String uname;
    private String password; //it's a VARCHAR in database with size (32)
    private String email;
    private int status; // it's a ENUM in database which contain offline(0), online(1), busy(2)
    private int score;
    private JFXButton btn=new JFXButton();

    public String getName() {
        return name.get();
    }
    public void setName(String n){
        name.set(n);
    }
    public String getScore(){
        return Integer.toString(score);
    }
    public JFXButton getStatus(){
        if(status==0){
            btn.setStyle("-fx-background-color: #F8327E;");
            btn.setText("Offline");
            return btn;
        }
        else if (status==1){
            btn.setStyle("-fx-background-color: #54dfc4;");
            btn.setText("Online");
            return btn;
        }
        btn.setStyle("-fx-background-color: #f09b13;");
        btn.setText("Busy");
        return btn;
    }
    // p constactor used for GUI only
    public Player(String username, String userPassword, String userEmail) {
        uname = username;
        name = new SimpleStringProperty(username);
        password = userPassword;
        email = userEmail;
        status = 0;  
        score = 0; 
    }

    // Player constructor for database  
    public Player(int userId, String username,  String userEmail, int userStatus, int userScore) {
        id = userId;
        uname = username;
        name = new SimpleStringProperty(username);
        email = userEmail;
        status = userStatus;
        score = userScore;
    }

    public Player() {
    }

    // player data setter
   public void setID(int id) {
        this.id = id;
    }

    public void setPlayerName(String username) {
        uname = username;
    }

    public void setPlayerPassword(String userPassword) {
            password = userPassword;

    }

    public void setPlayerEmail(String userEmail) {
            email = userEmail;

    }

    public void setPlayerStatus(int userStatus) {
        status = userStatus;
    }

    public void setPlayerScore(int userScore) {
        score = userScore;
    }


    // Player data getter
    public int getID() {
        return id;
    }

    public String getPlayerName() {
        return uname;
    }

    public String getPlayerPassword() {
        return password;
    }

    public String getPlayerEmail() {
        return email;
    }

    public int getPlayerStatus() {
        return status;
    }

    public int getPlayerScore() {
        return score;
    }

}
