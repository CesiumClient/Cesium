package net.cesiumclient.cesium.utils;

import net.minecraft.client.gui.DrawContext;

public class ScreenUtils {
    public static int getScaledIconSize(DrawContext context,int division){
        return Math.min(context.getScaledWindowHeight(),context.getScaledWindowWidth()) / division;
    }
    public static int getScaledIconSize(DrawContext context,double multiplier){
        return (int) ((Math.min(context.getScaledWindowHeight(),context.getScaledWindowWidth()) * multiplier) + 0.5);
    }
}
