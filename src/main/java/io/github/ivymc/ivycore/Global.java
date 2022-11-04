package io.github.ivymc.ivycore;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Global {
    public Global(@NotNull String id) {
        MOD_ID = id;
        LOGGER = LoggerFactory.getLogger(MOD_ID);
    }
    public String MOD_ID;
    public Logger LOGGER;

    public Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
