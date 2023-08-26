package net.cesiumclient.cesium;

import lombok.Getter;
import net.cesiumclient.cesium.config.Config;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Cesium implements ClientModInitializer {
    public static final MinecraftClient client = MinecraftClient.getInstance();

    @Getter
    private static Config config = new Config();
    public static final Logger LOGGER = LoggerFactory.getLogger("jmod");
    public static Thread main_thread = Thread.currentThread();
    //public static KeyBinding restoreScreenKey;

    public static long lastServerTick = System.currentTimeMillis();

    public static void saveConfig() {
        config.save();
    }

    public static void servertick() {
        lastServerTick = System.currentTimeMillis();
    }
    @Override
    public void onInitializeClient() {

    }
}
