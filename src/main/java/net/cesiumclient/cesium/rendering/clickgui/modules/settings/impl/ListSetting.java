package net.cesiumclient.cesium.rendering.clickgui.modules.settings.impl;

import net.cesiumclient.cesium.rendering.clickgui.modules.settings.Setting;

import java.util.List;

public class ListSetting<T> extends Setting<List<T>> {
    public boolean showOptions = false;
    public Object selectedOption;
    public ListSetting(String name, List<T> value, List<T> default_value) {
        super(name, value, default_value);
        if(value.size() > 0)
            selectedOption = value.get(0);
    }
    public ListSetting(String name, List<T> value) {
        super(name, value, value);
        if(value.size() > 0)
            selectedOption = value.get(0);
    }
    @Override
    public void reset(){
        if(value.size() > 0)
            selectedOption = value.get(0);
    }
}
