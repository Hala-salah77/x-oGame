
package com.tictactoe.tictactoefx;

import actions.PlayRequest;
import animatefx.animation.Flash;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.JFXFillTransition;
import com.jfoenix.validation.RequiredFieldValidator;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.FontIcon;
import playerModel.PlayerModel;


public class FXMLController implements Initializable {
   private Stage stage;
   private Scene scene;
//====================================

    @FXML
    private JFXButton mySignupButton;
    @FXML
    private JFXTextField usernameTF;
    @FXML
    Alert alert = new Alert(Alert.AlertType.ERROR);
//==================================================================
    @FXML
    private JFXButton minimize;

    @FXML
    private JFXButton closebutton;

    @FXML
    private void closeAction(ActionEvent event) {
            System.exit(0);
    }

    @FXML
    private void minimizeAction(ActionEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
//==========================================================================
    @FXML
    private JFXPasswordField passwordTF;
    RequiredFieldValidator validator = new RequiredFieldValidator();



    @FXML
    private void signUpButtonClicked(ActionEvent event) throws IOException {
        //Transition into RegisterForm.fxml
        SwitchTo.registerFormScene(event);
    }


    @FXML
    private void signInButtonClicked(ActionEvent event) throws IOException {
        //Check if usernameTF was left empty
        if (usernameTF.getText().trim().isEmpty()) {
            validator.setMessage("*Input Required");
            usernameTF.getValidators().add(validator);
            usernameTF.validate();
        }

        //Check if passwordTF was left empty
        if (passwordTF.getText().trim().isEmpty()) {
            validator.setMessage("*Input Required");
            passwordTF.getValidators().add(validator);
            passwordTF.validate();
        }
        //make sure that both fields aren't empty before attempting to switch the scene.
        validate();
    }
    private void validate() {
        Map<String, String> map = new HashMap<>();
        map.put("type", "login");
        map.put("email", usernameTF.getText());
        map.put("password", passwordTF.getText());
        System.out.println(map);
        PlayRequest.sendJSON(map);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }

}
