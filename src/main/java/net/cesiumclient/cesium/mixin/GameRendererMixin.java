package net.cesiumclient.cesium.mixin;

import net.cesiumclient.cesium.Cesium;
import net.cesiumclient.cesium.rendering.texture.TextureManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.BufferBuilderStorage;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Shadow @Final private BufferBuilderStorage buffers;

    @Shadow @Final private static Identifier NAUSEA_OVERLAY;

    @Inject(at=@At("HEAD"),method="render")
    public void render(float tickDelta, long startTime, boolean tick, CallbackInfo ci){
        //TextureManager.CSLNBGS.render(5,5, (byte) 0);
        //drawTexture(0,0,100,100);
    }
    public void drawTexture(int x, int y, int width, int height) {
        DrawContext context = new DrawContext(Cesium.client, this.buffers.getEntityVertexConsumers());
        context.getMatrices().push();
        width = context.getScaledWindowWidth();
        height = context.getScaledWindowHeight();
        context.drawTexture(NAUSEA_OVERLAY,x,y,1,1,width,height,width,height); //TextureManager.CSLNBGS
        context.getMatrices().pop();
    }
}
