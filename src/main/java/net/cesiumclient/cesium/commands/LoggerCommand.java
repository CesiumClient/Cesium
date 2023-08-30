package net.cesiumclient.cesium.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.cesiumclient.cesium.Cesium;
import net.cesiumclient.cesium.commands.arguments.StringArrayArgumentType;
import net.cesiumclient.cesium.commands.types.ArgumentEntry;

import java.util.List;

public class LoggerCommand extends Command {
    public LoggerCommand() {
        super("log", List.of(
                ArgumentEntry.create("type", StringArrayArgumentType.create(List.of(
                        "info",
                        "warn",
                        "error"
                ))),
                ArgumentEntry.create("message", StringArgumentType.string())
        ));
    }

    @Override
    public void onRun(String[] args) {
        switch (args[0].toLowerCase()){
            case "info" ->{
                Cesium.LOGGER.info(args[1]);
            }
            case "warn" ->{
                Cesium.LOGGER.warn(args[1]);
            }
            case "error" ->{
                Cesium.LOGGER.error(args[1]);
            }
        }
    }
}
