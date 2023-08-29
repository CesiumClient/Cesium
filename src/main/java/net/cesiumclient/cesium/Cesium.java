package net.cesiumclient.cesium;

import lombok.Getter;
import net.cesiumclient.cesium.config.Config;
import net.cesiumclient.cesium.registries.CategoryRegistry;
import net.cesiumclient.cesium.rendering.clickgui.categories.impl.Addons;
import net.cesiumclient.cesium.rendering.clickgui.categories.impl.Player;
import net.cesiumclient.cesium.rendering.screens.ClickGUI;
import net.cesiumclient.cesium.rendering.texture.TextureManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cesium implements ClientModInitializer {
    @Getter
    private static Class<?> clazz;
    public Cesium(){
        clazz = this.getClass();
    }

    public static final MinecraftClient client = MinecraftClient.getInstance();

    @Getter
    private static Config config = new Config();
    public static final Logger LOGGER = LoggerFactory.getLogger("cesium");
    public static Thread main_thread = Thread.currentThread();

    public static KeyBinding clickGuiKey;

    public static long lastServerTick = System.currentTimeMillis();

    public static void saveConfig() {
        config.save();
    }

    public static void servertick() {
        lastServerTick = System.currentTimeMillis();
    }
    @Override
    public void onInitializeClient() {
        CategoryRegistry.register(new Player());
        CategoryRegistry.register(new Addons());

        clickGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding("Open ClickGUI", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_SHIFT, "Cesium"));
        ClientTickEvents.END_CLIENT_TICK.register((client) -> {
            if (clickGuiKey.wasPressed())
                client.setScreen(new ClickGUI());
        });

        new Thread(()->{
            while(client.getTextureManager()==null);
            client.execute(TextureManager::initTextures);
        }).start();
    }
}
