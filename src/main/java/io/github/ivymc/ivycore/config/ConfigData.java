package io.github.ivymc.ivycore.config;

import com.google.gson.JsonObject;

public abstract class ConfigData {
    public abstract void onRead(JsonObject jsonObject) throws Exception;
}
