package net.noobonta.covilcore;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class FileGeneration {
    private final JavaPlugin plugin;

    private final File configFile;

    private final YamlConfiguration config;

    public FileGeneration(JavaPlugin plugin) {
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), "config.yml");
        this.config = YamlConfiguration.loadConfiguration(this.configFile);
    }

    public void saveConfig() {
        try {
            this.config.save(this.configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onEnable() {
        if (!this.configFile.exists())
            this.plugin.saveResource("config.yml", false);
    }

    public void onDisable() {
        saveConfig();
    }
}

