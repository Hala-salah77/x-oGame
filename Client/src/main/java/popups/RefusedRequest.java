package popups;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import actions.GameApplication;
import actions.GameConfig;
import com.tictactoe.tictactoefx.SwitchTo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.json.simple.JSONObject;

public class RefusedRequest implements Initializable {





    @FXML private Label informingLabel;
    private JSONObject jsonData;
   
   @FXML private void okButtonClicked(ActionEvent event)
   {
      // jsonData.put("response", "true");
       GameApplication.getPopUpWindow().close();


   }
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jsonData = GameConfig.getRejectedPobUpJson();



       // informingLabel.setText(jsonData.get("from_name").toString());


       informingLabel.setText("ٍSorry,Your request has been rejected. Try with another player.");
    }
   // jsonData.replace("type", "rejectedRequest");

}
