package org.harakiry;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    private static FileConfiguration config;

    private static File file;

    public void loadYamlFile(AntiBHOP plugin) {
        file = new File(plugin.getDataFolder(), "config.yml");
        if (!file.exists()) { // проверка на то, есть ли файл, если нет - создаётся папка и сохраняется файл.
            plugin.getDataFolder().mkdirs();
            plugin.saveResource("config.yml", true);
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getConfig() {
        return config;
    }

    public void reloadConfig(AntiBHOP plugin) {
        if (!file.exists()) { //проверка на то, есть ли файл, если нет - создаётся папка и сохраняется файл.
            plugin.getDataFolder().mkdirs();
            plugin.saveResource("config.yml", true);
        }
        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            Bukkit.getConsoleSender().sendMessage("Не удалось перезагрузить конфигурацию!");
        }
    }
}

