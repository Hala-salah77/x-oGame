package popups;

import actions.GameApplication;
import actions.GameConfig;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.tictactoe.tictactoefx.SwitchTo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.json.simple.JSONObject;
import org.kordamp.ikonli.javafx.FontIcon;
import player.PlayerHandler;


public class SaveSuccess implements Initializable {
    private JSONObject jsonData;

//    @FXML private FontIcon heartIcon;
    @FXML private void okButtonClicked(ActionEvent event)
    {
        GameApplication.getPopUpWindow().close();
        try {
            PlayerHandler.updatePlayers();
            SwitchTo.changeTo(GameApplication.getWindow(), 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        jsonData=GameConfig.getSaveGameSuccesPobUp();


    }    
    
}
