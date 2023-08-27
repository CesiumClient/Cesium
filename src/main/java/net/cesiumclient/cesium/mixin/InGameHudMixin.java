package net.cesiumclient.cesium.mixin;

import net.cesiumclient.cesium.Cesium;
import net.cesiumclient.cesium.rendering.renderers.CesiumIconRenderer;
import net.cesiumclient.cesium.rendering.renderers.ClickGUIRenderer;
import net.cesiumclient.cesium.rendering.texture.TextureManager;
import net.cesiumclient.cesium.utils.ScreenUtils;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Inject(at=@At("HEAD"),method = "render")
    public void render(DrawContext context, float tickDelta, CallbackInfo ci){
        if(Cesium.getConfig().cfg().ShowHUDIcon.getValue()){
            CesiumIconRenderer.render(context);
        }

        //logo reference

        //context.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        //int i = context.getScaledWindowWidth() / 2 - 128;
        //context.drawTexture(true ? MINCERAFT_TEXTURE : LOGO_TEXTURE, i, 30, 0.0f, 0.0f, 256, 44, 256, 64);
        //int j = context.getScaledWindowWidth() / 2 - 64;
        //int k = 30 + 44 - 7;
        //context.drawTexture(EDITION_TEXTURE, j, k, 0.0f, 0.0f, 128, 14, 128, 16);
        //context.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
    }
}
