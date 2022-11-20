package io.github.ivymc.ivycore.registry;

public class RegistryType <T> {
    private Class<T> clazz;
    public RegistryType(Class<T> clazz) {
        this.clazz = clazz;
    }
}
