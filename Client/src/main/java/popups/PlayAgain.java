package popups;

import java.net.URL;
import java.util.ResourceBundle;

import actions.GameApplication;
import actions.GameConfig;
import actions.GameRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.json.simple.JSONObject;
import player.PlayerHandler;

public class PlayAgain implements Initializable {
    private JSONObject jsonData ;

    
    @FXML private void noButtonClicked(ActionEvent event)
    {
        // ... user chose "No"
        jsonData.put("response", "false");
        GameRequest.sendJSONObject(jsonData);
        GameApplication.getPopUpWindow().close();

    }
    
    @FXML private void yesButtonClicked(ActionEvent event)
    {
        jsonData.put("response", "true");
        GameRequest.sendJSONObject(jsonData);
        PlayerHandler.resetGame();
        //App.getPopUpWindow().close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

        jsonData= GameConfig.getResetPobUP();
        jsonData.replace("type", "resetGameAnswer");
       
        
    }    
    
}
