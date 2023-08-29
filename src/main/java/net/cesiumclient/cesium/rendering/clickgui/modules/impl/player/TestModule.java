package net.cesiumclient.cesium.rendering.clickgui.modules.impl.player;

import net.cesiumclient.cesium.rendering.clickgui.modules.Module;
import net.cesiumclient.cesium.rendering.clickgui.modules.settings.impl.BoolSetting;
import net.cesiumclient.cesium.rendering.clickgui.modules.settings.impl.EnumSetting;
import net.cesiumclient.cesium.rendering.clickgui.modules.settings.impl.SliderSetting;
import net.cesiumclient.cesium.rendering.clickgui.modules.settings.impl.StringSetting;

import java.util.List;

public class TestModule extends Module {
    public TestModule() {
        super("Test Module", List.of(
                new StringSetting("test (again?!)", "real"),
                new BoolSetting("test",true,true),
                new SliderSetting("slider test",0.0, 0.0, -50, 50),
                new StringSetting("test (again?!)", "real"),
                new BoolSetting("test",true,true),
                new SliderSetting("slider test",0.0, 0.0, -50, 50),
                new EnumSetting<>("enum test", List.of(
                        "Test", "Test2", "Test3"
                ))
        ));
    }
}
