package net.cesiumclient.cesium.commands.arguments;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.cesiumclient.cesium.Cesium;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.command.CommandSource;
import net.minecraft.text.Text;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PlayerListEntryArgumentType implements ArgumentType<PlayerListEntry> {
    private static final DynamicCommandExceptionType NO_SUCH_PLAYER = new DynamicCommandExceptionType(name -> Text.literal("Player list entry with name " + name + " doesn't exist."));

    private static final Collection<String> EXAMPLES = List.of("xmpf", "ProxyGangster");

    public static PlayerListEntryArgumentType create() {
        return new PlayerListEntryArgumentType();
    }

    public static PlayerListEntry get(CommandContext<?> context) {
        return context.getArgument("player", PlayerListEntry.class);
    }

    @Override
    public PlayerListEntry parse(StringReader reader) throws CommandSyntaxException {
        String argument = reader.readString();
        PlayerListEntry playerListEntry = null;

        for (PlayerListEntry p : Cesium.client.player.networkHandler.getPlayerList()) {
            if (p.getProfile().getName().equalsIgnoreCase(argument)) {
                playerListEntry = p;
                break;
            }
        }
        if (playerListEntry == null) throw NO_SUCH_PLAYER.create(argument);

        return playerListEntry;
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        return CommandSource.suggestMatching(Cesium.client.player.networkHandler.getPlayerList().stream().map(playerListEntry -> playerListEntry.getProfile().getName()), builder);
    }

    @Override
    public Collection<String> getExamples() {
        return EXAMPLES;
    }
}