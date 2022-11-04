package io.github.ivymc.ivycore;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

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
