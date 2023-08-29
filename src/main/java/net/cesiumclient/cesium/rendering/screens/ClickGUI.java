package net.cesiumclient.cesium.rendering.screens;

import net.cesiumclient.cesium.Cesium;
import net.cesiumclient.cesium.rendering.renderers.ClickGUIRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.navigation.GuiNavigation;
import net.minecraft.client.gui.navigation.GuiNavigationPath;
import net.minecraft.client.gui.navigation.NavigationDirection;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class ClickGUI extends Screen {
    public ClickGUI() {
        super(Text.of("Click GUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta){
        ClickGUIRenderer.render(context,mouseX,mouseY,false,false,-1,-1,-1);
    }
    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        ClickGUIRenderer.render(new DrawContext(Cesium.client,Cesium.client.getBufferBuilders().getEntityVertexConsumers()),-100,-100,false,false,keyCode,scanCode,modifiers);
        return true;
    }
}
