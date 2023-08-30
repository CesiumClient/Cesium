package net.cesiumclient.cesium.registries;

import net.cesiumclient.cesium.rendering.clickgui.modules.impl.render.AntiTNTLag;

public class ModuleInitializer {
    public static void initialize() {
        new AntiTNTLag();
    }
}
