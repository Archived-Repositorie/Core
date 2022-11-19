package io.github.ivymc.ivycore.registry;

import net.minecraft.util.Identifier;

public record RegistryKey<T extends RegistryType<?>>(T registryType, Identifier id) {}
