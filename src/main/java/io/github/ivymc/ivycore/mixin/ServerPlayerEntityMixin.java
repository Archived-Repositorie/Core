package io.github.ivymc.ivycore.mixin;

import io.github.ivymc.ivycore.events.PlayerEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {
    @Inject(method = "onDisconnect", at = @At("RETURN"))
    public void onPlayerJoin(CallbackInfo ci) {
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;
        PlayerEvents.DISCONNECTED.events.forEach(event -> event.onEvent(player, player.getServer()));
    }
    @Inject(method = "tick", at = @At("HEAD"))
    public void onPlayerTick(CallbackInfo ci) {
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;
        PlayerEvents.TICK.events.forEach(event -> event.onEvent(player, player.getServer()));
    }
}
