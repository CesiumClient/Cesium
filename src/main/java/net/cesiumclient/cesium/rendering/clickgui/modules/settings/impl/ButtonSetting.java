package net.cesiumclient.cesium.rendering.clickgui.modules.settings.impl;

import net.cesiumclient.cesium.rendering.clickgui.modules.settings.Setting;
import org.apache.commons.lang3.ObjectUtils;

@SuppressWarnings({"unchecked", "rawtypes"})
public class ButtonSetting extends Setting {
    private Runnable clicked;
    public ButtonSetting(String text, Runnable clicked) {
        super(text, null, null);
        this.clicked = clicked;
    }

    public void click(){
        clicked.run();
    }

    @Override
    public void reset(){

    }
}
