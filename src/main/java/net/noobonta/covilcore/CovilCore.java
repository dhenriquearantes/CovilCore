package net.noobonta.covilcore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

public final class CovilCore extends JavaPlugin {
    public static CovilCore plugin;
    public static boolean jacobContestActive = false;
    public static Material jacobsMaterial;
    public static World HubWorld;
    private FileGeneration fileGeneration;
    public static Map<UUID, PotionEffect[]> deathEffectsMap;

    public void onLoad() {
        CommandAPI.onLoad(new CommandAPIBukkitConfig(this).verboseOutput(true));
        deathEffectsMap = (Map)new HashMap<>();
        HubWorld = getServer().getWorld("Vila");
    }

    public void onEnable() {
        plugin = this;
        this.fileGeneration = new FileGeneration(this);
        this.fileGeneration.onEnable();
        JacobsContest jacobsContest = new JacobsContest();
        Events events = new Events();
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(events, this);
        pluginManager.registerEvents(jacobsContest, this);
        CommandAPI.onEnable();
        Commands.onCommand();
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            (new PlaceholderRegister(this)).register();
        }

    }

    public void onDisable() {
        this.fileGeneration.onDisable();
        CommandAPI.onDisable();
    }
}

