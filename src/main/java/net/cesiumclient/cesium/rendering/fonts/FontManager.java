package net.cesiumclient.cesium.rendering.fonts;

import net.cesiumclient.cesium.Cesium;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class FontManager {
    public static Font Minecraftia;
    public static Font Minecraftia10px;

    static {
        try {
            Minecraftia = Font.createFont(Font.TRUETYPE_FONT,new File(Cesium.getClazz().getResource("/assets/cesium/Minecraftia-Regular.ttf").toURI()));
            Minecraftia10px = Minecraftia.deriveFont(10);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
