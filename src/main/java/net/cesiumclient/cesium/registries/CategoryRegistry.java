package net.cesiumclient.cesium.registries;

import lombok.Getter;
import net.cesiumclient.cesium.rendering.clickgui.categories.Category;
import net.cesiumclient.cesium.rendering.clickgui.categories.impl.*;

import java.util.ArrayList;
import java.util.List;

public class CategoryRegistry {

    @Getter
    private static List<Category> CATEGORIES = new ArrayList<>();

    public static final Player PLAYER = new Player();
    public static final Combat COMBAT = new Combat();
    public static final Movement MOVEMENT = new Movement();
    public static final Render RENDER = new Render();
    public static final World WORLD = new World();
    public static final Client CLIENT = new Client();
    public static final Miscellaneous MISC = new Miscellaneous();
    public static final Addons ADDONS = new Addons();

    public static void register(Category category) {
        CATEGORIES.add(category);
    }

    public static void initialize() {
        register(PLAYER);
        register(COMBAT);
        register(MOVEMENT);
        register(RENDER);
        register(WORLD);
        register(CLIENT);
        register(MISC);
        register(ADDONS);
        register(new Search());
    }
}
