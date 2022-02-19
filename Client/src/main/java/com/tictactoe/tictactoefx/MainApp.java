package com.tictactoe.tictactoefx;

import actions.GameApplication;
import actions.GameRequest;
import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import player.SocketPlayer;
import playerModel.PlayerList;

import java.util.HashMap;
import java.util.Map;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // connect to server socket
        GameApplication.setplayerSocket();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setResizable(false);
        stage.setTitle("Tic-Tac-ToeFX");
        GameApplication.setWindow(stage);
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(e -> {
           try{
               super.stop();
               GameApplication.getplayerSocket().closeSocket();
           }catch(Exception ee){
               ee.getMessage();
           }
            Platform.exit();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
