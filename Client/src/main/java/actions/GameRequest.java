package actions;

import org.json.simple.JSONObject;
import player.PlayerHandler;
import player.SocketPlayer;

import java.util.Map;
import java.util.Set;

public class GameRequest {
    static SocketPlayer player;

    public static void sendJSON(Map<String, String> fields) {
        player = GameApplication.getplayerSocket();
        JSONObject jsonMsg = new JSONObject();
        jsonMsg.putAll(fields);
        player.ps.println(jsonMsg.toJSONString());
    }

    public static void sendJSONObject(JSONObject jsonObject) {
        player = GameApplication.getplayerSocket();
        player.ps.println(jsonObject.toJSONString());
    }

}
