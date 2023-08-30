package net.cesiumclient.cesium.rendering.clickgui.modules;

import lombok.Getter;
import net.cesiumclient.cesium.Cesium;
import net.cesiumclient.cesium.rendering.clickgui.categories.Category;
import net.cesiumclient.cesium.rendering.clickgui.modules.settings.Setting;
import net.cesiumclient.cesium.rendering.clickgui.modules.settings.impl.BoolSetting;
import net.cesiumclient.cesium.rendering.clickgui.modules.settings.impl.ButtonSetting;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public abstract class Module {
    @Getter
    private String name;
    @Getter
    private List<Setting> settings;
    public boolean isExpanded;
    @Getter
    public BoolSetting enabled;

    public void onEnable() {
    }

    public void onDisable() {
    }

    public Module(String name) {
        this.name = name;
        List<Setting> b = new ArrayList<>();
        BoolSetting set = new BoolSetting("Enabled", false);
        b.add(set);
        enabled = set;
        b.add(new ButtonSetting("Reset All", this::resetAll));
        this.settings = b;
    }

    public Module(String name, Category target) {
        this.name = name;
        List<Setting> b = new ArrayList<>();
        BoolSetting set = new BoolSetting("Enabled", false);
        b.add(set);
        enabled = set;
        b.add(new ButtonSetting("Reset All", this::resetAll));
        this.settings = b;
        target.addModule(this);
    }

    public Module(String name, List<Setting> settings) {
        this.name = name;
        List<Setting> b = new ArrayList<>(settings);
        BoolSetting set = new BoolSetting("Enabled", false);
        b.add(set);
        enabled = set;
        b.add(new ButtonSetting("Reset All", this::resetAll));
        this.settings = b;
    }

    public Module(String name, List<Setting> settings, Category target) {
        this.name = name;
        List<Setting> b = new ArrayList<>(settings);
        BoolSetting set = new BoolSetting("Enabled", false);
        b.add(set);
        enabled = set;
        b.add(new ButtonSetting("Reset All", this::resetAll));
        this.settings = b;
        target.addModule(this);
    }

    private void resetAll() {
        for (Setting setting : settings)
            if (setting != enabled)
                setting.reset();
    }
}
