package net.cesiumclient.cesium.utils;

import java.awt.*;

public class ColorUtils {
    public static double[] Split(Color color){
        return new double[]{ color.getRed() / 255.0, color.getGreen() / 255.0, color.getBlue() / 255.0, color.getAlpha() / 255.0 };
    }
    public static float[] SplitFloat(Color color){
        return new float[]{ color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f };
    }
}
