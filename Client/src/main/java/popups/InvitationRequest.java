

package popups;

import actions.GameApplication;
import actions.GameConfig;
import actions.GameRequest;
import com.tictactoe.tictactoefx.SwitchTo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.json.simple.JSONObject;
import player.SocketPlayer;
import playerModel.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InvitationRequest implements Initializable {

    @FXML
    private Label requestLabel, headerLabel, contentLabel;
    private JSONObject jsonData ;

    @FXML
    private void noButtonClicked(ActionEvent event) throws IOException {

        // ... player2 chose "No"
        jsonData.put("response", "false");
        GameRequest.sendJSONObject(jsonData);

        /*try {
            GameConfig.setRejectedPobUpJson(jsonData);
            SwitchTo.RequestRejectedPopupScene();

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        GameApplication.getPopUpWindow().close();

    }

    @FXML
    private void yesButtonClicked(ActionEvent event) {
        // ... player2 chose "Yes"
        jsonData.put("response", "true");
        GameRequest.sendJSONObject(jsonData);
        GameApplication.getPopUpWindow().close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jsonData = GameConfig.getRequestPobUpJson();
        requestLabel.setText(jsonData.get("from_name").toString());
        if (jsonData.containsKey("old_game")) {
//            App.getPopUpWindow().setTitle("Resume Old Game");
            headerLabel.setText("Want to resume the old game with you!");
            contentLabel.setText("Are You want to resume it?");
        } else {
            headerLabel.setText("Want To Play With You");
            contentLabel.setText("Are You Ready?");
        }
        jsonData.replace("type", "acceptRequest");
    }

}

