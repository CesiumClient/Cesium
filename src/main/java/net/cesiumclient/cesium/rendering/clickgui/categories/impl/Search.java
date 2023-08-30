package net.cesiumclient.cesium.rendering.clickgui.categories.impl;

import lombok.Getter;
import net.cesiumclient.cesium.registries.CategoryRegistry;
import net.cesiumclient.cesium.rendering.clickgui.categories.Category;
import net.cesiumclient.cesium.rendering.clickgui.modules.Module;
import net.cesiumclient.cesium.rendering.clickgui.modules.settings.impl.StringSetting;

import java.util.ArrayList;
import java.util.List;

public class Search extends Category {
    public static StringSetting search = new StringSetting("Module Name","");
    public Search() {
        super("Search");
    }
    @Override
    public List<Module> getModules(){
        List<Module> result = new ArrayList<>();

        for (Category category : CategoryRegistry.getCATEGORIES()) {
            if(category instanceof Search) continue;

            for (Module module : category.getModules()) {
                String moduleName = module.getName();
                if (moduleName.toLowerCase().contains(search.value.toLowerCase()) && search.value.toLowerCase().matches(".*\\w.*")) {
                    result.add(module);
                }
            }
        }

        return result;
    }
}
