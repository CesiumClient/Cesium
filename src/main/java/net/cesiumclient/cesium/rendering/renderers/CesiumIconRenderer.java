package net.cesiumclient.cesium.rendering.renderers;

import me.x150.renderer.font.FontRenderer;
import net.cesiumclient.cesium.Cesium;
import net.cesiumclient.cesium.rendering.texture.TextureManager;
import net.cesiumclient.cesium.utils.ScreenUtils;
import net.minecraft.client.gui.DrawContext;

import java.awt.*;

public class CesiumIconRenderer {
    public static int getHeight(DrawContext context){
        return ScreenUtils.getScaledIconSize(context,Cesium.getConfig().cfg().CesiumHUDIconSize.getValue() / 20);
    }
    public static void render(DrawContext context){
        // icon
        context.setShaderColor(1.0f, 1.0f, 1.0f, .5f);

        int width = ScreenUtils.getScaledIconSize(context,Cesium.getConfig().cfg().CesiumHUDIconSize.getValue() / 20);
        int height = width; // i could just inline width but ehhhhhhhhhhhhhhhh this allows me to copy and paste the code

        int x = -((int)(width / 10));
        int y = -((int)(height / 10));

        width *= Cesium.client.options.getGuiScale().getValue();
        height *= Cesium.client.options.getGuiScale().getValue();
        x *= Cesium.client.options.getGuiScale().getValue();
        y *= Cesium.client.options.getGuiScale().getValue();
        context.drawTexture(TextureManager.CSLNBGS,x,y,0,0,width,height,width,height);
        context.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
    }
}
