package actions;

import com.tictactoe.tictactoefx.GamePlayController;
import javafx.application.Platform;
import javafx.stage.Stage;
import player.SocketPlayer;

public class GameApplication {

    private static Stage window;
    private static Stage popUpWindow;
    private static SocketPlayer playerSocket;
    private static GamePlayController gamePlayController;


    public static void setWindow(Stage stage) {
        window = stage;
    }

    public static Stage getWindow() {
        return window;
    }

    public static void setPopUpWindow(Stage stage) {
        popUpWindow = stage;
    }

    public static Stage getPopUpWindow() {
        return popUpWindow;
    }

    public static void setplayerSocket() {
        playerSocket = new SocketPlayer();
    }

    public static SocketPlayer getplayerSocket() {
        // connect to server socket
        if (playerSocket.socket.isClosed())
            setplayerSocket();


        return playerSocket;
    }

    public static void setGamePlayController(GamePlayController gamePlayController1) {
        gamePlayController = gamePlayController1;
    }

    public static GamePlayController getGamePlayController() {
        return gamePlayController;
    }
}
