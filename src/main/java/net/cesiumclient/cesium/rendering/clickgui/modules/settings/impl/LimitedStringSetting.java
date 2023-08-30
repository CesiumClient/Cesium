package net.cesiumclient.cesium.rendering.clickgui.modules.settings.impl;

import net.cesiumclient.cesium.rendering.clickgui.modules.settings.Setting;
import org.lwjgl.glfw.GLFW;

import java.util.Objects;

public class LimitedStringSetting extends Setting<String> {
    public boolean selected = false;
    public String lastSafeDisplayString = "";
    public int maxCharacters = 0;
    public LimitedStringSetting(String name, String value, int maxCharacters) {
        super(name, value, value);
        this.maxCharacters = maxCharacters;
    }
    public LimitedStringSetting(String name, String value,String defaultValue, int maxCharacters) {
        super(name, value, defaultValue);
        this.maxCharacters = maxCharacters;
    }
    public void onKey(int keyCode, int scanCode, int modifiers){
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            selected = false;
            return;
        }
        if (keyCode == GLFW.GLFW_KEY_BACKSPACE) {
            if(value.length() > 0) {
                value = value.substring(0,value.length() - 1);
            }
            return;
        }
        if(keyCode == GLFW.GLFW_KEY_SPACE){
            value = value.concat(" ");
            return;
        }

        try{
            if(value.concat(Objects.requireNonNull(GLFW.glfwGetKeyName(keyCode, scanCode))).length() <= maxCharacters)
                value = value.concat(Objects.requireNonNull(GLFW.glfwGetKeyName(keyCode, scanCode)));
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
