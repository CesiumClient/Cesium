package net.cesiumclient.cesium.rendering.clickgui.categories.impl;

import net.cesiumclient.cesium.rendering.clickgui.categories.Category;
import net.cesiumclient.cesium.rendering.clickgui.modules.Module;
import net.cesiumclient.cesium.rendering.clickgui.modules.impl.player.TestModule;

import java.util.List;

public class Addons extends Category {
    public Addons() {
        super("Addons", List.of(
                new TestModule(),
                new TestModule(),
                new TestModule(),
                new TestModule(),
                new TestModule(),
                new TestModule()
        ));
    }
}
