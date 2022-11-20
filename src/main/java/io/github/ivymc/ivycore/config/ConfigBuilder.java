package io.github.ivymc.ivycore.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigBuilder{
    private final Path configPath;


    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public ConfigBuilder(Path configPath) {
        this.configPath = FabricLoader.getInstance().getConfigDir().resolve(configPath);
    }
    public ConfigBuilder(String modID) {
        this.configPath = FabricLoader.getInstance().getConfigDir().resolve(modID);
    }
    public void loadConfig() throws Exception {
        if(Files.notExists(configPath)) {
            Files.createDirectories(configPath);
        }
    }
    public <T extends ConfigData> ConfigKey<T> createConfigKey(Path path, Class<? super T> clazz) {
        return new ConfigKey<>(clazz, this.configPath.resolve(path), GSON);
    }
}