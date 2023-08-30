package net.cesiumclient.cesium.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.cesiumclient.cesium.Cesium;
import net.cesiumclient.cesium.commands.types.ArgumentEntry;
import net.minecraft.command.CommandSource;

import java.util.List;
@SuppressWarnings({"rawtypes","unchecked"})
public abstract class Command {
    public String CMD;
    public List<ArgumentEntry> ARGS;

    public LiteralArgumentBuilder<CommandSource> builder;
    public Command(String cmd, List<ArgumentEntry> args) {
        CMD = cmd;
        ARGS = args;
    }
    public Command(String cmd) {
        CMD = cmd;
        ARGS = null;
    }

    protected static <T> RequiredArgumentBuilder<CommandSource, T> argument(final String name, final ArgumentType<T> type) {
        return RequiredArgumentBuilder.argument(name, type);
    }
    protected static ArgumentEntry argument_entry(String name, ArgumentType type){
//        List<Object> list = new ArrayList<>();
//        list.add(name);
//        list.add(type);
        return new ArgumentEntry(name,type);
    }

    public void registerWithBuilder(CommandDispatcher<CommandSource> dispatcher, LiteralArgumentBuilder<CommandSource> builder){
        builder.executes(c -> 1);
        Cesium.LOGGER.info("buidler.cmd().string() returns -> " + builder.getLiteral());
        boolean removed = dispatcher.getRoot().getChildren().removeIf(node -> node.getName().equals(builder.getLiteral()));
        dispatcher.register(builder);
        Cesium.LOGGER.warn("Attempted command reregister. Shit may get fucked!");
        Cesium.LOGGER.warn("node removed from RootCommandNode -> " + removed);
    }

    public void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralArgumentBuilder<CommandSource> command = LiteralArgumentBuilder.literal(this.CMD);
        builder = command;
        //0x150 bottom to top method

        if(ARGS != null) {
            if (ARGS.size() == 1) {
                command.then(argument(ARGS.get(0).name(), ARGS.get(0).type()).executes(context -> 1));

            } else if (!ARGS.isEmpty()) {
                ArgumentBuilder final_argBuilder = null;//argument(ARGS.get(0).get(0).toString(), (ArgumentType) ARGS.get(0).get(1)).executes(context -> 1);
                ArgumentBuilder previous = final_argBuilder;
                for (int i = ARGS.size() - 1; i >= 0; i--) {
                    ArgumentEntry entry = ARGS.get(i);
//                    if (ARGS.get(0)==entry) continue;
                    ArgumentBuilder new_arg = argument(entry.name(), entry.type()).executes(context -> 1);
                    if (previous != null)
                        new_arg = new_arg.then(previous);
                    previous = new_arg;
                    final_argBuilder = new_arg;
                }
                command.then(final_argBuilder); // apply arg(s)
            }
        }
        command.executes(context -> 1);
        dispatcher.register(command);
        Cesium.LOGGER.info("called register on dispatcher " + dispatcher);
    }
    public void onRegistered(CommandDispatcher<CommandSource> dispatcher,LiteralArgumentBuilder<CommandSource> builder) {}
    public abstract void onRun(String[] args);
}