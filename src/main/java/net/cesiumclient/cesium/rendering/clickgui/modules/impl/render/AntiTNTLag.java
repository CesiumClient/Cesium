package net.cesiumclient.cesium.rendering.clickgui.modules.impl.render;

import net.cesiumclient.cesium.registries.CategoryRegistry;
import net.cesiumclient.cesium.rendering.clickgui.modules.Module;
import net.cesiumclient.cesium.rendering.clickgui.modules.settings.Setting;

import java.util.List;

public class AntiTNTLag extends Module {
    public static boolean enabled = false;
    public AntiTNTLag() {
        super("Anti TNT Lag", CategoryRegistry.RENDER);
    }
    @Override
    public void onEnable(){
        enabled = true;
    }
    @Override
    public void onDisable(){
        enabled = false;
    }
}
