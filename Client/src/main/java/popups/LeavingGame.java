package popups;

import java.net.URL;
import java.util.ResourceBundle;

import actions.GameApplication;
import actions.GameConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.json.simple.JSONObject;

public class LeavingGame implements Initializable {
    private JSONObject jsonData ;
    @FXML private  void okButtonClicked(ActionEvent event)
    {
        GameApplication.getPopUpWindow().close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jsonData= GameConfig.getGameFaildPobUp();

    }    
    
}
