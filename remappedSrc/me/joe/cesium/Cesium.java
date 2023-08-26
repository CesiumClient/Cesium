package me.joe.cesium;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import me.joe.cesium.config.Config;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Cesium implements ClientModInitializer {
    public static final Minecra
    public static Config config = new Config();
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
