package net.cesiumclient.cesium.itemgroups;

import net.minecraft.block.Blocks;
import net.minecraft.item.Items;

import java.util.List;

public class ExtendedItemsGroup extends CustomItemGroup {

    public ExtendedItemsGroup() {
        super("extended", Blocks.COMMAND_BLOCK,"Extended",List.of(
                Items.COMMAND_BLOCK,
                Items.COMMAND_BLOCK_MINECART,
                Items.STRUCTURE_BLOCK,
                Items.STRUCTURE_VOID,
                Items.BARRIER,
                Items.LIGHT
        ));
    }
}
