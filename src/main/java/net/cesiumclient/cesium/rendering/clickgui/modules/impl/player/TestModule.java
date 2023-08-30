package net.cesiumclient.cesium.rendering.clickgui.modules.impl.player;

import net.cesiumclient.cesium.Cesium;
import net.cesiumclient.cesium.rendering.clickgui.modules.Module;
import net.cesiumclient.cesium.rendering.clickgui.modules.settings.impl.*;

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
                )),
                new ButtonSetting("button",TestModule::handleClick),
                new LimitedStringSetting("limited test","test",5)
        ));
    }

    public static void handleClick(){
        Cesium.LOGGER.info("Button Click");
    }
}
