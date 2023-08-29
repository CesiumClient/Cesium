package net.cesiumclient.cesium.rendering.clickgui.modules.settings.impl;

import net.cesiumclient.cesium.Cesium;
import net.cesiumclient.cesium.rendering.clickgui.modules.settings.Setting;
import net.cesiumclient.cesium.rendering.screens.ClickGUI;
import net.minecraft.client.gui.screen.Screen;
import org.lwjgl.glfw.GLFW;

import java.util.Objects;

public class StringSetting extends Setting<String> {
    public boolean selected = false;
    private Runnable keyHandler = null;
    public String lastSafeDisplayString = "";
    public StringSetting(String name, String value) {
        super(name, value, value);
    }
    public StringSetting(String name, String value,String defaultValue) {
        super(name, value, defaultValue);
    }
    public StringSetting(String name, String value,String defaultValue, Runnable keyHandler) {
        super(name, value, defaultValue);
        this.keyHandler = keyHandler;
    }
    public void onKey(int keyCode, int scanCode, int modifiers){
        if(keyHandler!=null)
            keyHandler.run();
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
            value = value.concat(Objects.requireNonNull(GLFW.glfwGetKeyName(keyCode, scanCode)));
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
