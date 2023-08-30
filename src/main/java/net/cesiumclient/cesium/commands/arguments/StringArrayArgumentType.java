package net.cesiumclient.cesium.commands.arguments;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.command.CommandSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class StringArrayArgumentType implements ArgumentType<String> {

    private static final Collection<String> EXAMPLES = List.of("test,1,2,real (but a list!)");
    public List<String> suggestions = new ArrayList<>();
    public static StringArrayArgumentType create(List<String> suggestions) {
        StringArrayArgumentType bla = new StringArrayArgumentType();
        bla.suggestions = suggestions;
        return bla;
    }

    @Override
    public String parse(StringReader reader) throws CommandSyntaxException {
        String argument = reader.readString();
        String entry = null;

        for (String p : suggestions) {
            if (p.equalsIgnoreCase(argument)) {
                entry = p;
                break;
            }
        }

        return entry;
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        return CommandSource.suggestMatching(suggestions.stream(), builder);
    }

    @Override
    public Collection<String> getExamples() {
        return EXAMPLES;
    }
}
