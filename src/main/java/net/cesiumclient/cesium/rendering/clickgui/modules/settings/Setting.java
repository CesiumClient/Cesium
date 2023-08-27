package net.cesiumclient.cesium.rendering.clickgui.modules.settings;

import net.cesiumclient.cesium.config.ConfigEntry;

public abstract class Setting<T> {
    public String name;
    public T value;
    public T default_value;

    public Setting(String name, T value, T default_value) {
        this.name = name;
        this.value = value;
        this.default_value = default_value;
    }

    public void reset(){
        value = default_value;
    }
}