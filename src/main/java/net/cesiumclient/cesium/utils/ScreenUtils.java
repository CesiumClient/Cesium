package net.cesiumclient.cesium.utils;

import net.minecraft.client.gui.DrawContext;

public class ScreenUtils {
    public static int getScaledIconSize(DrawContext context,int division){
        return Math.min(context.getScaledWindowHeight(),context.getScaledWindowWidth()) / division;
    }
    public static int getScaledIconSize(DrawContext context,double multiplier){
        return (int) ((Math.min(context.getScaledWindowHeight(),context.getScaledWindowWidth()) * multiplier) + 0.5);
    }
    public static boolean isMouseOver(int mouseX, int mouseY, int x1, int x2, int y1, int y2){
        return (mouseX > x1 && mouseX < x2) && (mouseY > y1 && mouseY < y2);
    }
    public static boolean isMouseOver(int mouseX, int mouseY, float x1, float x2, float y1, float y2){
        x1 = (int) x1 + 0.5f;
        x2 = (int) x2 + 0.5f;
        y1 = (int) y1 + 0.5f;
        y2 = (int) y2 + 0.5f;

        return (mouseX > x1 && mouseX < x2) && (mouseY > y1 && mouseY < y2);
    }
}
