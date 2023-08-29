package net.cesiumclient.cesium.mixin;

import net.cesiumclient.cesium.Cesium;
import net.cesiumclient.cesium.rendering.renderers.ClickGUIRenderer;
import net.cesiumclient.cesium.rendering.screens.ClickGUI;
import net.minecraft.client.gui.ParentElement;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ParentElement.class)
public interface ParentElementMixin {
    @Inject(method = "mouseClicked", at = @At("HEAD"))
    private void mouseClicked(double mouseX, double mouseY, int button, CallbackInfoReturnable<Boolean> cir) {
        if(Cesium.client.currentScreen instanceof ClickGUI){
            ClickGUIRenderer.drag = true;
            if(button == GLFW.GLFW_MOUSE_BUTTON_1)
                ClickGUIRenderer.onClicked((int) mouseX, (int) mouseY);
            else if (button == GLFW.GLFW_MOUSE_BUTTON_2)
                ClickGUIRenderer.onRightClicked((int) mouseX, (int) mouseY);
        }
    }
    @Inject(method = "mouseReleased", at = @At("HEAD"))
    private void mouseReleased(double mouseX, double mouseY, int button, CallbackInfoReturnable<Boolean> cir) {
        if(Cesium.client.currentScreen instanceof ClickGUI){
            ClickGUIRenderer.drag = false;
        }
    }
}
