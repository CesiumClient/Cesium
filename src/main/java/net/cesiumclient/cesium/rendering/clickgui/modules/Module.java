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
    public boolean isExpanded;
    @Getter
    public BoolSetting enabled;
    public void onEnable(){}
    public void onDisable(){}
    public Module(String name, List<Setting> settings){
        this.name = name;
        List<Setting> b = new ArrayList<>(settings);
        BoolSetting set = new BoolSetting("Enabled",false);
        b.add(set);
        enabled = set;
        this.settings = b;
    }
}
