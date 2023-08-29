package net.cesiumclient.cesium.rendering.clickgui.categories.impl;

import net.cesiumclient.cesium.rendering.clickgui.modules.impl.player.TestModule;
import net.cesiumclient.cesium.rendering.clickgui.categories.Category;

import java.util.List;

public class Player extends Category {
    public Player() {
        super("Player", List.of(
                new TestModule(),
                new TestModule(),
                new TestModule()
        ));
    }
}
