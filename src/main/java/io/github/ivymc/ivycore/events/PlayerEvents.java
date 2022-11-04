package io.github.ivymc.ivycore.events;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayerEvents {
    public interface Event {
        void onEvent(ServerPlayerEntity player, MinecraftServer server);
    }

    public static class JOINED {
        public static final List<Event> events = new ArrayList<>();
        public static void register(Event event) {
            events.add(event);
        }
    }

    public static class DISCONNECTED {
        public static final List<Event> events = new ArrayList<>();
        public static void register(Event event) {
            events.add(event);
        }
    }

    public static class TICK {
        public static final List<Event> events = new ArrayList<>();
        public static void register(Event event) {
            events.add(event);
        }
    }
}
