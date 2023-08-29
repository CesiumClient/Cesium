package net.cesiumclient.cesium.rendering.fonts;

import net.cesiumclient.cesium.Cesium;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class FontManager {
    public static Font Minecraftia;
    public static Font OpenSansRegular;
    public static Font OpenSansBold;
    public static Font OpenSansExtraBold;

    static {
        try {
            Minecraftia = Font.createFont(Font.TRUETYPE_FONT,new File(Cesium.getClazz().getResource("/assets/cesium/fonts/Minecraftia-Regular.ttf").toURI()));
            OpenSansRegular = Font.createFont(Font.TRUETYPE_FONT,new File(Cesium.getClazz().getResource("/assets/cesium/fonts/OpenSans-Regular.ttf").toURI()));
            OpenSansBold = Font.createFont(Font.TRUETYPE_FONT,new File(Cesium.getClazz().getResource("/assets/cesium/fonts/OpenSans-SemiBold.ttf").toURI()));
            OpenSansExtraBold = Font.createFont(Font.TRUETYPE_FONT,new File(Cesium.getClazz().getResource("/assets/cesium/fonts/OpenSans-ExtraBold.ttf").toURI()));
        } catch (FontFormatException | IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
