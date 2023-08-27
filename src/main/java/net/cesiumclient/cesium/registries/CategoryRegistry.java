package net.cesiumclient.cesium.registries;

import lombok.Getter;
import net.cesiumclient.cesium.rendering.clickgui.categories.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRegistry {

    @Getter
    private static List<Category> CATEGORIES = new ArrayList<>();

    public static void register(Category category){
        CATEGORIES.add(category);
    }
}
