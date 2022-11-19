package io.github.ivymc.ivycore.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigBuilder <T extends ConfigData> {
    private final Path path;
    private final Class<T> clazz;
    private T data;
    private JsonObject object;


    public final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public ConfigBuilder(Path path, Class<T> clazz) {
        this.path = path;
        this.clazz = clazz;
    }
    private final Path configPath = FabricLoader.getInstance().getConfigDir().resolve("totconfig");
    public void writeConfig() throws Exception {
        if(Files.notExists(configPath)) {
            Files.createDirectories(configPath);
        }
        var config = clazz.getConstructor().newInstance();
        Files.writeString(configPath.resolve(path), GSON.toJson(config));
        object = jsonReader(configPath.resolve(path).toFile());
        data = config;
        data.onRead(object);
    }

    public static JsonObject jsonReader(File file) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(file));
        return JsonParser.parseReader(reader).getAsJsonObject();
    }

    public void readConfig() throws Exception {
        object = jsonReader(configPath.resolve(path).toFile());
        data = GSON.fromJson(Files.readString(configPath.resolve(path)), clazz);
        data.onRead(object);
    }

    public T getData() {
        return data;
    }

    public JsonObject getObject() {
        return object;
    }
}