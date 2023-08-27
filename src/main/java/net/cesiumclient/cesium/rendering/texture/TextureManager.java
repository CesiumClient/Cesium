package net.cesiumclient.cesium.rendering.texture;

import lombok.SneakyThrows;
import net.cesiumclient.cesium.Cesium;
import net.minecraft.util.Identifier;

import java.io.IOException;

public class TextureManager {
    public static final Identifier CSLNBGS = new Identifier("cesium", "/cesium_nobg_icon.png");;

    @SneakyThrows
    public static void initTextures()  {
        Cesium.client.getTextureManager().bindTexture(CSLNBGS);
    }
}
