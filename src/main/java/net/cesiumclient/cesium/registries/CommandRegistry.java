package net.cesiumclient.cesium.registries;

import com.mojang.brigadier.CommandDispatcher;
import net.cesiumclient.cesium.Cesium;
import net.cesiumclient.cesium.commands.Command;
import net.minecraft.client.network.ClientCommandSource;
import net.minecraft.command.CommandSource;

import java.util.ArrayList;
import java.util.List;

public class CommandRegistry {
    public static final CommandDispatcher<CommandSource> DISPATCHER = new CommandDispatcher<>();
    public static final CommandSource COMMAND_SOURCE = new ClientCommandSource(null, Cesium.client);
    public static List<Command> COMMANDS = new ArrayList<>();
    public static void registerCommands() {

    }
    public static void registerCommand(Command commandInstance) {
            commandInstance.register(DISPATCHER);
            commandInstance.onRegistered(DISPATCHER,commandInstance.builder); // builder should be asssigned from .register call
            COMMANDS.add(commandInstance);
            Cesium.LOGGER.info("registered");
    }
}
