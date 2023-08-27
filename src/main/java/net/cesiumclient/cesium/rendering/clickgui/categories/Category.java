package net.cesiumclient.cesium.rendering.clickgui.categories;

import lombok.Getter;
import net.cesiumclient.cesium.Cesium;
import net.cesiumclient.cesium.rendering.clickgui.modules.Module;
import net.minecraft.util.math.MathHelper;

import java.util.ArrayList;
import java.util.List;

public abstract class Category {
    @Getter
    private String title;

    @Getter
    private List<Module> modules;

    public int x1 = 0;
    public int x2 = 0;
    public int y1 = 0;
    public int y2 = 0;

    public Category(String title){
        this.title = title;
        this.modules = new ArrayList<>();
    }
    public Category(String title, List<Module> modules){
        this.title = title;
        this.modules = modules;
    }
    public boolean isDragFirstFrame = false;
    private int offsetX = 0;
    private int offsetY = 0;

    public boolean isMouseOver(int mouseX, int mouseY){
        return (mouseX > x1 && mouseX < x2) && (mouseY > y1 && mouseY < y2);
    }

    public void drag(int mouseX, int mouseY){
        if(isDragFirstFrame){
            offsetX = x1 - mouseX;
            offsetY = y1 - mouseY;
            isDragFirstFrame = false;
        }

        int windowWidth = Cesium.client.getWindow().getScaledWidth();
        int windowHeight = Cesium.client.getWindow().getScaledHeight();

        int width = x2 - x1;
        int height = y2 - y1;

        if(mouseX + offsetX <= 5 || mouseX + offsetX >= windowWidth - 5 || mouseY + offsetY <= 5 || mouseY + offsetY >= windowHeight - 5 || mouseX + width + offsetX <= 5 || mouseX + width + offsetX >= windowWidth - 5 || mouseY + height + offsetY <= 5 || mouseY + height + offsetY >= windowHeight - 5){
            return;
        }

        x1 = mouseX + offsetX;
        x2 = mouseX + width + offsetX;
        y1 = mouseY + offsetY;
        y2 = mouseY + height + offsetY;
    }
    public void enddrag(){
        offsetX = 0;
        offsetY = 0;
        isDragFirstFrame = false;
    }
}
