package net.cesiumclient.cesium.mixin;

import net.cesiumclient.cesium.Cesium;
import net.cesiumclient.cesium.utils.Constants;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(at=@At("HEAD"),method = "render")
    public void render(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci){
        context.drawTextWithShadow(Cesium.client.textRenderer,
                "Cesium Client " + FabricLoader.getInstance().getModContainer("cesium").get().getMetadata().getVersion().getFriendlyString(),
                5,5, Constants.ColorMain.getRGB());
    }
}
