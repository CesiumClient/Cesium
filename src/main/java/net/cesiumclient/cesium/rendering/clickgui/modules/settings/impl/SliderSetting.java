package net.cesiumclient.cesium.rendering.clickgui.modules.settings.impl;

import net.cesiumclient.cesium.rendering.clickgui.modules.settings.Setting;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;

public class SliderSetting extends Setting<Double> {
    public final double minRange;
    public final double maxRange;
    public double fakeSliderPosition = 0;
    public double sliderPosition = 0;
    public boolean isDragFirstFrame = false;
    public boolean dragging = false;
    public int offsetX = 0;
    public int offsetY = 0;
    public SliderSetting(String name, double value, double default_value, double minRange, double maxRange) {
        super(name, value, default_value);
        this.minRange = -50;//minRange;
        this.maxRange = 50;//maxRange;
    }
    public SliderSetting(String name, double value, double minRange, double maxRange) {
        super(name, value, value);
        this.minRange = -50;//minRange;
        this.maxRange = 50;//maxRange;
    }
    @Override
    public void reset(){
        sliderPosition = 0;
        fakeSliderPosition = 0;
    }
}
