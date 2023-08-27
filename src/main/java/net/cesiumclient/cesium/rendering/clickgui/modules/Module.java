package net.cesiumclient.cesium.rendering.clickgui.modules;

import lombok.Getter;
import net.cesiumclient.cesium.rendering.clickgui.modules.settings.Setting;
import net.cesiumclient.cesium.rendering.clickgui.modules.settings.impl.BoolSetting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class Module {
    @Getter
    private String name;
    @Getter
    private List<Setting> settings;

    public Module(String name, List<Setting> settings){
        this.name = name;
        List<Setting> b = new ArrayList<Setting>(settings);
        b.add(new BoolSetting("Enabled",false));
        this.settings = b;
    }
}
