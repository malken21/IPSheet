package marumasa.ip_sheet;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    public final String URL;
    public final String KickMessage;

    public Config(final minecraft plugin) {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();

        URL = config.getString("URL");
        KickMessage = config.getString("KickMessage");
    }
}