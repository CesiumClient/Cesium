package net.cesiumclient.cesium.rendering.renderers;

import com.mojang.datafixers.kinds.Const;
import io.netty.util.Constant;
import me.x150.renderer.font.FontRenderer;
import me.x150.renderer.render.Renderer2d;
import me.x150.renderer.util.RendererUtils;
import net.cesiumclient.cesium.Cesium;
import net.cesiumclient.cesium.registries.CategoryRegistry;
import net.cesiumclient.cesium.rendering.clickgui.categories.Category;
import net.cesiumclient.cesium.rendering.clickgui.modules.Module;
import net.cesiumclient.cesium.rendering.fonts.FontManager;
import net.cesiumclient.cesium.rendering.texture.TextureManager;
import net.cesiumclient.cesium.utils.ColorUtils;
import net.cesiumclient.cesium.utils.Constants;
import net.cesiumclient.cesium.utils.ScreenUtils;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ClickGUIRenderer {
    static FontRenderer fr;
    static FontRenderer fr1;

    static boolean initialize = true;
    static boolean dragging = false;
    public static boolean drag = false;
    public static void render(DrawContext context, int mouseX, int mouseY){
        if (fr == null) {
            fr = new FontRenderer(new Font[]{
                    FontManager.Minecraftia//new Font("Minecraftia", Font.PLAIN, 8)
            }, 9f);
            fr1 = new FontRenderer(new Font[]{
                    FontManager.Minecraftia//new Font("Minecraftia", Font.BOLD, 8)
            }, 7f);
        }
        MatrixStack fs = RendererUtils.getEmptyMatrixStack();
        fs.push();

        //categories

        float[] colors = ColorUtils.SplitFloat(Constants.ColorMain);
        float[] colorsText = ColorUtils.SplitFloat(Constants.ColorClickGUICategoryText);
        float[] colorsSecondary = ColorUtils.SplitFloat(Constants.ColorSecondary);

        for(int i = 0; i < CategoryRegistry.getCATEGORIES().size(); i++){
            Category category = CategoryRegistry.getCATEGORIES().get(i);

            if(initialize){
                category.x1 = (i*100)+10;
                category.x2 = ((i*100)+10)+90;
                category.y1 = 30;
                category.y2 = 45;

                initialize = false;
            }

            if(drag & (category.isMouseOver(mouseX,mouseY) || dragging)){
                if(!dragging)
                    category.isDragFirstFrame = true;
                category.drag(mouseX,mouseY);
                dragging = true;
            } else{
                if(dragging)
                    category.enddrag();
                dragging = false;
            }

            Renderer2d.renderQuad(fs, new Color(30,30,30), category.x1,category.y1,category.x2,category.y2);

            float strWidth = fr.getStringWidth(category.getTitle());

            fr.drawString(fs,category.getTitle(),(category.x1 + (((float) (category.x2 - category.x1) / 2))) - (strWidth / 2),((float) (category.y1 + category.y2) / 2) - (fr.getStringHeight(category.getTitle()) / 2), colorsText[0], colorsText[1], colorsText[2], 1f);

            int minBodySize = 3;

            int height = 0;
            int height1 = 0;

            int yOffset = 3;


            //module height calc
            for(Module module : category.getModules()){
                String name = module.getName();
                int stringHeight = (int) ((fr1.getStringHeight(name) + 2) + 0.5);
                height1 += stringHeight;
            }

            Renderer2d.renderQuad(fs,new Color((float) 30 /255, (float) 30 /255, (float) 30 /255,0.7f), category.x1, category.y2, category.x2, category.y2 + MathHelper.clamp(height1,minBodySize,Double.MAX_VALUE));

            //modules
            for(Module module : category.getModules()){
                String name = module.getName();
                int stringHeight = (int) ((fr1.getStringHeight(name) + 2) + 0.5);
                height += stringHeight;
                //fr1.drawString(fs,name, category.x1 + 2, category.y1 + height,1f,1f,1f,1f);
            }

        }

        //other stuff

        String credit = "Cesiums ClickGUI is rendered using \"Renderer\" by 0x150";

        float stringHeight = fr.getStringHeight(credit);

        fr.drawString(fs, credit, 5, context.getScaledWindowHeight() - stringHeight - 2, colors[0], colors[1], colors[2], 1f);
        fs.pop();
    }
}
