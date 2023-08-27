package net.cesiumclient.cesium.rendering.screens;

import net.cesiumclient.cesium.rendering.renderers.ClickGUIRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGUI extends Screen {
    public ClickGUI() {
        super(Text.of("Click GUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta){
        ClickGUIRenderer.render(context,mouseX,mouseY);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY){

        return false;
    }
}
