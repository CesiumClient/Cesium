package net.cesiumclient.cesium.rendering.clickgui.modules.settings.impl;

import net.cesiumclient.cesium.rendering.clickgui.modules.settings.Setting;

public class BoolSetting extends Setting<Boolean> {
    public BoolSetting(String name, boolean value) {
        super(name, value, value);
    }
    public BoolSetting(String name, boolean value,boolean defaultValue) {
        super(name, value, defaultValue);
    }
}
