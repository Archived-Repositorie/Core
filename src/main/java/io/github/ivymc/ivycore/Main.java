package io.github.ivymc.ivycore;

import com.google.gson.JsonObject;
import io.github.ivymc.ivycore.config.ConfigBuilder;
import io.github.ivymc.ivycore.config.ConfigData;
import io.github.ivymc.ivycore.registry.RegistryBuilder;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.nio.file.Path;

public class Main implements PreLaunchEntrypoint {
    private static final Global g = new Global("ivycore");

    @Override
    public void onPreLaunch() {
        g.LOGGER.info("-------------------------------------------------------------");
        g.LOGGER.info("Thanks for installing our mod!");
        g.LOGGER.info("Created by IvyMC project");
        g.LOGGER.info("Check our other projects at https://github.com/IvyMC-Project/");
        g.LOGGER.info("-------------------------------------------------------------");
    }
}
