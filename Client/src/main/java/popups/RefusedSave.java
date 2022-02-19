package popups;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import actions.GameApplication;
import actions.GameConfig;
import actions.GameRequest;
import com.tictactoe.tictactoefx.SwitchTo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.json.simple.JSONObject;

public class RefusedSave implements Initializable
{
    private JSONObject jsonData;

    @FXML private void okButtonClicked(ActionEvent event)
    {
        GameApplication.getPopUpWindow().close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
      //  String name = jsonData.get("from_name").toString();
      jsonData=GameConfig.getSaveGameRejectedPobUp();


    }    
    
}
