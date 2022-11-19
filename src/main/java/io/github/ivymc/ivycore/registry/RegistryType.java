package io.github.ivymc.ivycore.registry;

import net.minecraft.item.Item;

public class RegistryType <T> {
    private Class<T> clazz;
    public RegistryType(Class<T> clazz) {
        this.clazz = clazz;
    }
}
