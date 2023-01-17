package marumasa.ip_sheet;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

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
        final String getData = String.valueOf(request.get(cfg.URL + "?type=isAllow&ip=" + LoginIP));
        event.setKickMessage(getData);

        mc.getLogger().info(LoginIP);
    }

    private String getIP(String data) {
        return data.split("/")[1].split(":")[0];
    }
}