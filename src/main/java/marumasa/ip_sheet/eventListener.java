package marumasa.ip_sheet;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;


import java.net.http.HttpResponse;

public class eventListener implements Listener {

    private final Config cfg;
    private final minecraft mc;

    public eventListener(Config config, minecraft minecraft) {
        cfg = config;
        mc = minecraft;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        final String LoginIP = getIP(String.valueOf(event.getAddress()));
        mc.getLogger().info(LoginIP);
        final HttpResponse<String> getData = request.get(cfg.URL + "?type=isAllow&ip=" + LoginIP);
        event.disallow(Result.KICK_OTHER, String.valueOf(getData));

        mc.getLogger().info(LoginIP);
    }

    private String getIP(String data) {
        return data.split("/")[1].split(":")[0];
    }
}