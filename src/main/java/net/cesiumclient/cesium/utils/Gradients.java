package net.cesiumclient.cesium.utils;

import net.minecraft.text.Style;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Gradients {
    public static List<Style> Gradient(int lightest, int darkest, int steps) {
        Color lightestColor = new Color(lightest);
        Color darkestColor = new Color(darkest);

        List<Style> gradient = new ArrayList<>();
        for (int i = 0; i < steps; i++) {
            float ratio = (float) i / (steps - 1);
            int red = (int) (lightestColor.getRed() + ratio * (darkestColor.getRed() - lightestColor.getRed()));
            int green = (int) (lightestColor.getGreen() + ratio * (darkestColor.getGreen() - lightestColor.getGreen()));
            int blue = (int) (lightestColor.getBlue() + ratio * (darkestColor.getBlue() - lightestColor.getBlue()));
            int alpha = (int) (lightestColor.getAlpha() + ratio * (darkestColor.getAlpha() - lightestColor.getAlpha()));

            int colorValue = new Color(red, green, blue, alpha).getRGB();
            gradient.add(Style.EMPTY.withColor(colorValue));
        }

        return gradient;
    }
    public static List<Style> Rainbow(int steps) {
        List<Style> gradient = new ArrayList<>();
        float hue = 0;
        for(int i = 0; i < steps; i++){
            Color color = Color.getHSBColor(hue,1f,1f);
            gradient.add(Style.EMPTY.withColor(color.getRGB()));
            hue += (float) 1 / steps;
        }
        return gradient;
    }
}
