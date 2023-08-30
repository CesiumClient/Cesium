package net.cesiumclient.cesium.itemgroups;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;

import java.util.List;

public abstract class CustomItemGroup {
    protected String id;
    protected Block icon;
    protected String title;
    protected List<Item> items;

    public CustomItemGroup(String id, Block icon, String title, List<Item> items){
        this.id = id;
        this.icon = icon;
        this.title = title;
        this.items = items;

        RegistryKey<ItemGroup> TESTING_GROUP = ItemGroupUtils.register(id);
        Registry.register(Registries.ITEM_GROUP, TESTING_GROUP, ItemGroup.create(ItemGroup.Row.TOP, 0).displayName(Text.of(title)).icon(() -> new ItemStack(icon))
        .entries((displayContext, entries) -> {
            for(Item i : items){
                entries.add(i);
            }
        }).build());
    }

    public List<Item> getItems() {
        return items;
    }

    public Block getIcon() {
        return icon;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
