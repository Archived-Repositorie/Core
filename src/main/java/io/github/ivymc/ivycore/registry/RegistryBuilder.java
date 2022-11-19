package io.github.ivymc.ivycore.registry;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class RegistryBuilder {
    private final HashMap<RegistryKey<?>,Object> registries = new HashMap<>();
    public <T> T add(RegistryType<? super T> registryType, Identifier id, T item) {
        registries.put(new RegistryKey<>(registryType, id), item);
        return item;
    }

    public <V> V get(RegistryType<? super V> registryType, Identifier id) {
        var find = registries.get(new RegistryKey<>(registryType, id));
        if(find == null) {
            return null;
        }
        return (V) find;
    }
}
