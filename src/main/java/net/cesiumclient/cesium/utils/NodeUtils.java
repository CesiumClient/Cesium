package net.cesiumclient.cesium.utils;

import com.mojang.brigadier.tree.CommandNode;

import java.util.ArrayList;
import java.util.List;

public class NodeUtils {
    public static List<CommandNode<?>> NodeDescendants(CommandNode<?> rootNode) {
        List<CommandNode<?>> descendants = new ArrayList<>();
        try{
            List<CommandNode<?>> children = new ArrayList<>(rootNode.getChildren());
            while (!children.isEmpty()) {
                CommandNode<?> childNode = children.remove(0);
                descendants.add(childNode);

                children.addAll(childNode.getChildren());
            }
        } catch(Exception ignored) { }


        return descendants;
    }
}
