package io.github.ivymc.ivycore.config;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigKey <T extends ConfigData> {
    private final Gson GSON;
    public JsonObject object;
    public final Class<? super T> clazz;
    public T data;
    public final Path path;

    public ConfigKey(Class<? super T> clazz, Path path, Gson gson) {
        this.clazz = clazz;
        this.path = path;
        this.GSON = gson;
    }

    public void writeConfig() throws Exception {
        var config = (T) clazz.getConstructor().newInstance();
        Files.writeString(path, GSON.toJson(config));
        object = jsonReader(path.toFile());
        data = config;
        data.onRead(object);
    }

    public static JsonObject jsonReader(File file) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(file));
        return JsonParser.parseReader(reader).getAsJsonObject();
    }

    public void readConfig() throws Exception {
        object = jsonReader(path.toFile());
        data = (T)GSON.fromJson(Files.readString(path), clazz);
        data.onRead(object);
    }
}
