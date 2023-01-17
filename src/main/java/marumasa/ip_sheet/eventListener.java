package marumasa.ip_sheet;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

public class eventListener implements Listener {

    private final Config cfg;
    private final minecraft mc;

    public eventListener(Config config, minecraft minecraft) {
        cfg = config;
        mc = minecraft;
    }

    @EventHandler
    public void onLogin(AsyncPlayerPreLoginEvent event) {
        final String LoginIP = getIP(String.valueOf(event.getAddress()));

        final String getJSON = request.get(cfg.URL + "?type=isAllow&ip=" + LoginIP);
        if (getJSON == null) {
            event.disallow(Result.KICK_OTHER, cfg.ErrorMessage);
            sendLogger(LoginIP, cfg.ErrorMessage);
        } else if (getJSON.contains("false")) {
            event.disallow(Result.KICK_OTHER, cfg.KickMessage);
            sendLogger(LoginIP, cfg.KickMessage);
        }
    }

    private String getIP(String data) {
        return data.split("/")[1].split(":")[0];
    }

    private void sendLogger(String LoginIP, String text) {
        mc.getLogger().info("[" + LoginIP + "] " + text);
    }
}