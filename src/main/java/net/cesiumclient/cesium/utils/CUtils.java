package net.cesiumclient.cesium.utils;

import net.cesiumclient.cesium.Cesium;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.concurrent.CompletableFuture;


//sorry for the shitcode this is from jmod, i didnt feel like rewritingf it.
public class CUtils {
    public static final String TabSpaces = "    ";
    public static final String TabHyphens = "----";

    public static void overlay(String message) {
        if (Cesium.client.player != null)
            Cesium.client.player.sendMessage(Text.of(message), true);
    }

    //regular
    public static void info(String message) {
        if (Cesium.client.player != null)
            Cesium.client.player.sendMessage(Text.of(Cesium.getConfig().cfg().FormattingColorSecondary + "[" + Cesium.getConfig().cfg().FormattingColorMain + "Cesium" + Cesium.getConfig().cfg().FormattingColorSecondary + "]" + Formatting.RESET + " " + message), false);
    }

    public static void warn(String message) {
        if (Cesium.client.player != null)
            Cesium.client.player.sendMessage(
                    Text.of(Cesium.getConfig().cfg().FormattingColorSecondaryWrn
                            + "["
                            + Cesium.getConfig().cfg().FormattingColorMainWrn
                            + Cesium.getConfig().cfg().WrnKey
                            + Cesium.getConfig().cfg().FormattingColorSecondaryWrn
                            + "]"
                            + Cesium.getConfig().cfg().FormattingColorSecondary
                            + "["
                            + Cesium.getConfig().cfg().FormattingColorMain
                            + "Cesium"
                            + Cesium.getConfig().cfg().FormattingColorSecondary
                            + "]" + Formatting.RESET + " " + message
                    ), false
            );
    }

    public static void error(String message) {
        if (Cesium.client.player != null)
            Cesium.client.player.sendMessage(
                    Text.of(Cesium.getConfig().cfg().FormattingColorSecondaryErr
                            + "["
                            + Cesium.getConfig().cfg().FormattingColorMainErr
                            + Cesium.getConfig().cfg().ErrKey
                            + Cesium.getConfig().cfg().FormattingColorSecondaryErr
                            + "]"
                            + Cesium.getConfig().cfg().FormattingColorSecondary
                            + "["
                            + Cesium.getConfig().cfg().FormattingColorMain
                            + "Cesium"
                            + Cesium.getConfig().cfg().FormattingColorSecondary
                            + "]" + Formatting.RESET + " " + message
                    ), false
            );
    }

    //indent overloads
    public static void info(String message, int indent) {
        if (Cesium.client.player != null)
            Cesium.client.player.sendMessage(Text.of(Cesium.getConfig().cfg().FormattingColorSecondary + "[" + Cesium.getConfig().cfg().FormattingColorMain + "Cesium" + Cesium.getConfig().cfg().FormattingColorSecondary + "]" + Formatting.RESET + " " + TabHyphens.repeat(indent) + message), false);
    }

    public static void warn(String message, int indent) {
        if (Cesium.client.player != null)
            Cesium.client.player.sendMessage(
                    Text.of(Cesium.getConfig().cfg().FormattingColorSecondaryWrn
                            + "["
                            + Cesium.getConfig().cfg().FormattingColorMainWrn
                            + Cesium.getConfig().cfg().WrnKey
                            + Cesium.getConfig().cfg().FormattingColorSecondaryWrn
                            + "]"
                            + Cesium.getConfig().cfg().FormattingColorSecondary
                            + "["
                            + Cesium.getConfig().cfg().FormattingColorMain
                            + "Cesium"
                            + Cesium.getConfig().cfg().FormattingColorSecondary
                            + "]" + Formatting.RESET + " " + TabHyphens.repeat(indent) + message
                    ), false
            );
    }

    public static void error(String message, int indent) {
        if (Cesium.client.player != null)
            Cesium.client.player.sendMessage(
                    Text.of(Cesium.getConfig().cfg().FormattingColorSecondaryErr
                            + "["
                            + Cesium.getConfig().cfg().FormattingColorMainErr
                            + Cesium.getConfig().cfg().ErrKey
                            + Cesium.getConfig().cfg().FormattingColorSecondaryErr
                            + "]"
                            + Cesium.getConfig().cfg().FormattingColorSecondary
                            + "["
                            + Cesium.getConfig().cfg().FormattingColorMain
                            + "Cesium"
                            + Cesium.getConfig().cfg().FormattingColorSecondary
                            + "]" + Formatting.RESET + " " + TabHyphens.repeat(indent) + message
                    ), false
            );
    }

    //indent overloads + choice
    public static void info(String message, int indent, boolean hyphens) {
        if (Cesium.client.player != null)
            Cesium.client.player.sendMessage(Text.of(Cesium.getConfig().cfg().FormattingColorSecondary + "[" + Cesium.getConfig().cfg().FormattingColorMain + "Cesium" + Cesium.getConfig().cfg().FormattingColorSecondary + "]" + Formatting.RESET + " " + (hyphens ? TabHyphens : TabSpaces).repeat(indent) + message), false);
    }

    public static void warn(String message, int indent, boolean hyphens) {
        if (Cesium.client.player != null)
            Cesium.client.player.sendMessage(
                    Text.of(Cesium.getConfig().cfg().FormattingColorSecondaryWrn
                            + "["
                            + Cesium.getConfig().cfg().FormattingColorMainWrn
                            + Cesium.getConfig().cfg().WrnKey
                            + Cesium.getConfig().cfg().FormattingColorSecondaryWrn
                            + "]"
                            + Cesium.getConfig().cfg().FormattingColorSecondary
                            + "["
                            + Cesium.getConfig().cfg().FormattingColorMain
                            + "Cesium"
                            + Cesium.getConfig().cfg().FormattingColorSecondary
                            + "]" + Formatting.RESET + " " + (hyphens ? TabHyphens : TabSpaces).repeat(indent) + message
                    ), false
            );
    }

    public static void error(String message, int indent, boolean hyphens) {
        if (Cesium.client.player != null)
            Cesium.client.player.sendMessage(
                    Text.of(Cesium.getConfig().cfg().FormattingColorSecondaryErr
                            + "["
                            + Cesium.getConfig().cfg().FormattingColorMainErr
                            + Cesium.getConfig().cfg().ErrKey
                            + Cesium.getConfig().cfg().FormattingColorSecondaryErr
                            + "]"
                            + Cesium.getConfig().cfg().FormattingColorSecondary
                            + "["
                            + Cesium.getConfig().cfg().FormattingColorMain
                            + "Cesium"
                            + Cesium.getConfig().cfg().FormattingColorSecondary
                            + "]" + Formatting.RESET + " " + (hyphens ? TabHyphens : TabSpaces).repeat(indent) + message
                    ), false
            );
    }

    //indent overloads + option
    public static void info(String message, int indent, char tabkey) {
        if (Cesium.client.player != null)
            Cesium.client.player.sendMessage(Text.of(Cesium.getConfig().cfg().FormattingColorSecondary + "[" + Cesium.getConfig().cfg().FormattingColorMain + "Cesium" + Cesium.getConfig().cfg().FormattingColorSecondary + "]" + Formatting.RESET + " " + String.valueOf(tabkey).repeat(4).repeat(indent) + message), false);
    }

    public static void warn(String message, int indent, char tabkey) {
        if (Cesium.client.player != null)
            Cesium.client.player.sendMessage(
                    Text.of(Cesium.getConfig().cfg().FormattingColorSecondaryWrn
                            + "["
                            + Cesium.getConfig().cfg().FormattingColorMainWrn
                            + Cesium.getConfig().cfg().WrnKey
                            + Cesium.getConfig().cfg().FormattingColorSecondaryWrn
                            + "]"
                            + Cesium.getConfig().cfg().FormattingColorSecondary
                            + "["
                            + Cesium.getConfig().cfg().FormattingColorMain
                            + "Cesium"
                            + Cesium.getConfig().cfg().FormattingColorSecondary
                            + "]" + Formatting.RESET + " " + String.valueOf(tabkey).repeat(4).repeat(indent) + message
                    ), false
            );
    }

    public static void error(String message, int indent, char tabkey) {
        if (Cesium.client.player != null)
            Cesium.client.player.sendMessage(
                    Text.of(Cesium.getConfig().cfg().FormattingColorSecondaryErr
                            + "["
                            + Cesium.getConfig().cfg().FormattingColorMainErr
                            + Cesium.getConfig().cfg().ErrKey
                            + Cesium.getConfig().cfg().FormattingColorSecondaryErr
                            + "]"
                            + Cesium.getConfig().cfg().FormattingColorSecondary
                            + "["
                            + Cesium.getConfig().cfg().FormattingColorMain
                            + "Cesium"
                            + Cesium.getConfig().cfg().FormattingColorSecondary
                            + "]" + Formatting.RESET + " " + String.valueOf(tabkey).repeat(4).repeat(indent) + message
                    ), false
            );
    }

    public static String lastKnownMessage = "";
    public static volatile boolean confirm_result = false;
    public static boolean confirming_thing = false;

    //STRAIGHT ASS 🔥🔥🔥
    public static CompletableFuture<Boolean> confirmation(String confirmationMessage) {
        info(confirmationMessage + " Y/N");
        CompletableFuture<Boolean> resultFuture = new CompletableFuture<>();
        confirming_thing = true;

        new Thread(() -> {
            while (!confirm_result) {
                 Thread.onSpinWait();
            }
            confirm_result = false;
            confirming_thing = false;
            boolean confirmationValue = lastKnownMessage.equalsIgnoreCase("y");
            resultFuture.complete(confirmationValue);
        }).start();

        return resultFuture;
    }


    public static void chat(String message) {
        if (Cesium.client.player != null)
            Cesium.client.player.networkHandler.sendChatMessage(message);
    }

    public static void command(String command) {
        if (Cesium.client.player != null)
            if (command.toCharArray()[0] == '/')
                command = command.replaceFirst("/", "");
        Cesium.client.player.networkHandler.sendCommand(command);
    }
}
