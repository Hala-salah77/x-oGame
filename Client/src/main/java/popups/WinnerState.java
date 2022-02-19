package popups;

import actions.GameApplication;
import actions.GameConfig;
import com.jfoenix.controls.JFXButton;
import com.tictactoe.tictactoefx.GamePlayController;
import com.tictactoe.tictactoefx.SwitchTo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.json.simple.JSONObject;
import player.PlayerHandler;

public class WinnerState implements Initializable {

    @FXML
    private JFXButton exitButton;

    @FXML
    private Label result_txt;


    @FXML
    private void resetButtonClicked(ActionEvent event) {
        System.out.println("Reset was Pressed");

        if (GameConfig.getMode() == 1) {
            GamePlayController game = GameApplication.getGamePlayController();
            game.currPlayerMark = "X";
            PlayerHandler.resetGame();
        } else if (GameConfig.getMode() == 2) {
//            PlayerHandler.updateFriendBoard(GameConfig.getXOList());
            PlayerHandler.resetGameRequest();
        }
        GameApplication.getPopUpWindow().close();
    }


    @FXML
    private void exitButtonClicked(ActionEvent event) {
        System.out.println("Exit was pressed");
        GameApplication.getPopUpWindow().close();
        try {
            SwitchTo.changeTo(GameApplication.getWindow(), 2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (GameConfig.getMode() == 2) {
            JSONObject jsonObject = GameConfig.getWinnerPobUpJson();
            int winner_id = Integer.parseInt(jsonObject.get("winner_id").toString());
            if (winner_id != 0) {
                if (winner_id == GameApplication.getplayerSocket().getPlayer().getID()) {
                    result_txt.setText("Congrats, You've won! \n Your new Score is " + GameApplication.getplayerSocket().getPlayer().getPlayerScore());
                } else {
                    result_txt.setText("Oops, You failed.. Good luck second time.");
                }
            } else {
                result_txt.setText("Game finished, It's a Tie.");
            }
        } else if (GameConfig.getMode() == 1) {
            if (GameConfig.getWinner().equals("X")) {
                result_txt.setText("Player X Won!");
            } else if (GameConfig.getWinner().equals("O")) {
                result_txt.setText("Player O Won!");
            } else if (GameConfig.getWinner().equals("Tie")) {
                result_txt.setText("It is a Tie!");
            }
        }

    }

}
