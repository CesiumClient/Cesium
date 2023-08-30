package net.cesiumclient.cesium.mixin;

import net.cesiumclient.cesium.Cesium;
import net.cesiumclient.cesium.commands.Command;
import net.cesiumclient.cesium.registries.CommandRegistry;
import net.cesiumclient.cesium.utils.CUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin {
    @Shadow public abstract void acknowledge(SignedMessage message, boolean displayed);

    // a little tiny bit more optimized :3dsunglasses:
    // still shit though :/
    @Inject(at = @At("HEAD"), method = "sendChatMessage", cancellable = true)
    private void onSendChatMessage(String message, CallbackInfo ci) {
        if(CUtils.confirming_thing){
            CUtils.lastKnownMessage = message;
            CUtils.confirm_result = true;
            ci.cancel();
        }
        for(Command c : CommandRegistry.COMMANDS){
            String[] split = message.split("(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)\\s+");
            if(c.CMD.equals(split[0].replaceFirst(Cesium.getConfig().cfg().Prefix.getValue(),""))){
                ci.cancel();
                String[] args = split;
                List<String> list = new ArrayList<>(Arrays.asList(args));
                list.remove(0);
                args = list.toArray(new String[0]);
                try {
                    c.onRun(args);
                } catch(Exception invalidArgs) { // lefty moment (we had chat logging methods in jmod. why didnt you use them 💀) anyways ive made this port of the original mixin use them.
                    CUtils.error("Error executing command: " + c.CMD);
                    CUtils.error(String.valueOf(invalidArgs));
                    invalidArgs.printStackTrace();
                    if(invalidArgs instanceof ArrayIndexOutOfBoundsException) {
                        CUtils.error("Not Enough arguments specified!");
                    }
                }
            }
        }
    }
}