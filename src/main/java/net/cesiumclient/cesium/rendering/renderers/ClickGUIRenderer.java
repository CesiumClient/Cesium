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
import net.cesiumclient.cesium.rendering.clickgui.modules.settings.Setting;
import net.cesiumclient.cesium.rendering.clickgui.modules.settings.impl.*;
import net.cesiumclient.cesium.rendering.fonts.FontManager;
import net.cesiumclient.cesium.utils.ColorUtils;
import net.cesiumclient.cesium.utils.Constants;
import net.cesiumclient.cesium.utils.ScreenUtils;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.glfw.GLFW;

import java.awt.*;

public class ClickGUIRenderer {
    static FontRenderer categoryNames;
    static FontRenderer moduleNames;
    static FontRenderer generic;

    static boolean initialize = true;
    public static boolean drag = false;


    static void renderBoolSetting(MatrixStack stack, int x, int y, int size, Setting<Boolean> setting,int mouseX, int mouseY,boolean leftClicked){
        int bigX = (int) (x + size / 2.0);
        int bigY = (int) (y - size / 2.0);
        int bigX1 = (int) (x + size + (size / 2.0));
        int bigY2 = (int) (y + size / 2.0);
        Renderer2d.renderQuad(stack,new Color(50,50,50),bigX,bigY,bigX1, bigY2);
        if(leftClicked && ScreenUtils.isMouseOver(mouseX,mouseY,bigX,bigX1,bigY,bigY2)){
            setting.value = !setting.value; // toggle
        }
        if(setting.value){
            Renderer2d.renderQuad(stack,Constants.ColorMain,(float) x + (size / 2.0) * 1.4,(float) y - size / 3f,(float) x + size + (size / 3f), (float) y + size / 3f); // checked
        }
        generic.drawString(stack,setting.name,(x + size + (size / 2.0f) + 2f),y - (generic.getStringHeight(setting.name) / 2),1,1,1,1);
    }
    static void renderStringSetting(MatrixStack stack, int x, int y, int x2, StringSetting setting, int mouseX, int mouseY, boolean leftClicked){
//        generic.drawString(stack,setting.name,x + 3,y - generic.getStringHeight(setting.name),1,1,1,1);// + (generic.getStringHeight(setting.name) / 2),1,1,1,1);
//        Color c = setting.selected ? new Color(65, 65, 65) : new Color(50,50,50);
//        Renderer2d.renderQuad(stack,c,x + 3,y - (generic.getStringHeight(setting.name) * 1),x2 - 3,y - (generic.getStringHeight(setting.name) * 1) + 11);
//        generic.drawString(stack,setting.value,x + 4,y - (generic.getStringHeight(setting.value)) + 6,1,1,1,1);

        generic.drawString(stack, setting.name, x + 3, y - generic.getStringHeight(setting.name) / 2, 1, 1, 1, 1);


        Color c = setting.selected ? new Color(85, 85, 85) : new Color(50, 50, 50);
        Renderer2d.renderQuad(stack, c, x + 3, y + (generic.getStringHeight(setting.name) / 2), x2 - 3, y + (generic.getStringHeight(setting.name) / 2) + 11);


        if(leftClicked && ScreenUtils.isMouseOver(mouseX,mouseY,x+3,x2-3,y + (generic.getStringHeight(setting.name) / 2),y + (generic.getStringHeight(setting.name) / 2) + 11)){
            setting.selected = true;
        } else if (leftClicked && !ScreenUtils.isMouseOver(mouseX,mouseY,x+3,x2-3,y + (generic.getStringHeight(setting.name) / 2),y + (generic.getStringHeight(setting.name) / 2) + 11)){
            setting.selected = false;
        }

        if(generic.getStringWidth(setting.value) >= ((x2 - 3) - (x + 3)) - generic.getStringWidth("...")){
            generic.drawString(stack, setting.lastSafeDisplayString + "...", x + 4, y + (generic.getStringHeight(setting.value) / 2) + 1, 1, 1, 1, 1);
        } else{
            setting.lastSafeDisplayString = setting.value;
            generic.drawString(stack, setting.value, x + 4, y + (generic.getStringHeight(setting.value) / 2) + 1, 1, 1, 1, 1);
        }
    }
    static void renderLimitedStringSetting(MatrixStack stack, int x, int y, int x2, LimitedStringSetting setting, int mouseX, int mouseY, boolean leftClicked){
//        generic.drawString(stack,setting.name,x + 3,y - generic.getStringHeight(setting.name),1,1,1,1);// + (generic.getStringHeight(setting.name) / 2),1,1,1,1);
//        Color c = setting.selected ? new Color(65, 65, 65) : new Color(50,50,50);
//        Renderer2d.renderQuad(stack,c,x + 3,y - (generic.getStringHeight(setting.name) * 1),x2 - 3,y - (generic.getStringHeight(setting.name) * 1) + 11);
//        generic.drawString(stack,setting.value,x + 4,y - (generic.getStringHeight(setting.value)) + 6,1,1,1,1);

        generic.drawString(stack, setting.name, x + 3, y - generic.getStringHeight(setting.name) / 2, 1, 1, 1, 1);


        Color c = setting.selected ? new Color(85, 85, 85) : new Color(50, 50, 50);
        Renderer2d.renderQuad(stack, c, x + 3, y + (generic.getStringHeight(setting.name) / 2), x2 - 3, y + (generic.getStringHeight(setting.name) / 2) + 11);


        if(leftClicked && ScreenUtils.isMouseOver(mouseX,mouseY,x+3,x2-3,y + (generic.getStringHeight(setting.name) / 2),y + (generic.getStringHeight(setting.name) / 2) + 11)){
            setting.selected = true;
        } else if (leftClicked && !ScreenUtils.isMouseOver(mouseX,mouseY,x+3,x2-3,y + (generic.getStringHeight(setting.name) / 2),y + (generic.getStringHeight(setting.name) / 2) + 11)){
            setting.selected = false;
        }

        if(generic.getStringWidth(setting.value) >= ((x2 - 3) - (x + 3)) - generic.getStringWidth("...")){
            generic.drawString(stack, setting.lastSafeDisplayString + "...", x + 4, y + (generic.getStringHeight(setting.value) / 2) + 1, 1, 1, 1, 1);
        } else{
            setting.lastSafeDisplayString = setting.value;
            generic.drawString(stack, setting.value, x + 4, y + (generic.getStringHeight(setting.value) / 2) + 1, 1, 1, 1, 1);
        }
    }
    static void renderSliderSetting(MatrixStack stack, int x, int y, int x1, int x2, SliderSetting setting, int mouseX, int mouseY, boolean drag){
        generic.drawString(stack, setting.name, x + 3, y - generic.getStringHeight(setting.name) / 2 + 2, 1, 1, 1, 1);
        generic.drawString(stack, String.valueOf(setting.sliderPosition), x2 - (generic.getStringWidth(String.valueOf(setting.sliderPosition)) + 2), y - generic.getStringHeight(setting.name) / 2 + 2, 1, 1, 1, 1);

        int size = 7;

        double sliderx1 = (double) (x1 + ((x2 - x1)) / 2) - ((double) size / 2);
        double sliderx2 = (double) (x1 + ((x2 - x1)) / 2) + ((double) size / 2);

        double y1 = (y + 11) - ((double) size / 2);
        double y2 = (y + 11) + ((double) size / 2);

        if(drag && ScreenUtils.isMouseOver(mouseX,mouseY, (int) ((float)sliderx1 + setting.fakeSliderPosition), (int) ((float)sliderx2 + setting.fakeSliderPosition),(float)y1,(float)y2) || setting.dragging){
            setting.dragging = true;
            double relativeMouseX = mouseX - sliderx1;
            double newSliderPosition = relativeMouseX - size / 2.0;

            setting.fakeSliderPosition = MathHelper.clamp(newSliderPosition,setting.minRange + 10,setting.maxRange - 10);
            setting.sliderPosition = setting.fakeSliderPosition * 1.25;
        }
        if(!drag && setting.dragging)
            setting.dragging = false;


        sliderx1 += setting.fakeSliderPosition;
        sliderx2 += setting.fakeSliderPosition;



        Renderer2d.renderRoundedQuad(stack,Constants.ColorMain,x + 3, y + (generic.getStringHeight(setting.name) / 2) + 4, x2 - 3, y + (generic.getStringHeight(setting.name) / 2) + 7,1,3);
        Renderer2d.renderRoundedQuad(stack,new Color(255,255,255), sliderx1, y1, sliderx2, y2,3,3);
    }
    static void renderDropdownSetting(MatrixStack stack, int x, int y, int x1, int x2, EnumSetting<?> setting, int mouseX, int mouseY, boolean leftClick){
        generic.drawString(stack, setting.name, x + 3, y - generic.getStringHeight(setting.name) / 2, 1, 1, 1, 1);

        Renderer2d.renderQuad(stack, new Color(50, 50, 50), x + 3, y + (generic.getStringHeight((String) (setting.selectedOption != null ? setting.selectedOption : "")) / 2), x2 - 3, y + ((generic.getStringHeight((String) (setting.selectedOption != null ? setting.selectedOption : ""))) / 2) + 11);
        generic.drawString(stack, (String) (setting.selectedOption != null ? setting.selectedOption : ""), x + 4, y + (generic.getStringHeight((String) (setting.selectedOption != null ? setting.selectedOption : "")) / 2) + 1, 1, 1, 1, 1);
        Renderer2d.renderLine(stack, new Color(150, 150, 150),x2 - 5 - generic.getStringWidth(">"),y + (generic.getStringHeight((String) (setting.selectedOption != null ? setting.selectedOption : "")) / 2),x2 - 5 - generic.getStringWidth(">"),y + ((generic.getStringHeight((String) (setting.selectedOption != null ? setting.selectedOption : ""))) / 2) + 11);
        generic.drawString(stack, ">", x2-4 - generic.getStringWidth(">"), y + (generic.getStringHeight(">") / 2) + 1, 1, 1, 1, 1);
        
        int height = 0;
        int height1 = 0;
        if(setting.showOptions){
            for(Object option : setting.value){ // bg
                String strVal = String.valueOf(option);
                height1 += generic.getStringHeight(strVal) + 2;
            }
            Renderer2d.renderQuad(stack,new Color(40,40,40),x2,y + (generic.getStringHeight((String) (setting.selectedOption != null ? setting.selectedOption : "")) / 2),x2 + 100,y + (generic.getStringHeight((String) (setting.selectedOption != null ? setting.selectedOption : "")) / 2) + height1);

            //this code is so fucking shit

            for(Object option : setting.value){
                String strVal = String.valueOf(option);
                generic.drawString(stack,strVal,x2 + 3,y + (generic.getStringHeight(strVal) / 2) + height + 1,1,1,1,1);

                //Renderer2d.renderQuad(stack,new Color(Color.CYAN.getRed(),Color.CYAN.getGreen(),Color.CYAN.getBlue(),Color.CYAN.getAlpha() / 3),x2,y + height + 4.5,x2+100,y + height + generic.getStringHeight(strVal) + 6.5); // bounds check

                if(ScreenUtils.isMouseOver(mouseX,mouseY,x2,x2 + 100f,y + height + 4.5f,y + height + generic.getStringHeight(strVal) + 6.5f)){
                    Renderer2d.renderQuad(stack,new Color(255, 255, 255,50),x2,y + height + 4.5f,x2+100f,y + height + generic.getStringHeight(strVal) + 6.5f); // highlight

                    if(leftClick)
                        setting.selectedOption = option;
                }

                height += generic.getStringHeight(strVal) + 2;

                if(option!=setting.value.get(setting.value.size() - 1))
                    Renderer2d.renderLine(stack, new Color(65, 65, 65), x2 + 5, y + (generic.getStringHeight(strVal) / 2) + height - 1, x2 + 96, y + (generic.getStringHeight(strVal) / 2) + height - 1);
            }
        }

        if(leftClick && ScreenUtils.isMouseOver(mouseX,mouseY,x2 - 5 - generic.getStringWidth(">"),x2, y + (generic.getStringHeight((String) (setting.selectedOption != null ? setting.selectedOption : "")) / 2),y + ((generic.getStringHeight((String) (setting.selectedOption != null ? setting.selectedOption : ""))) / 2) + 11)){
            setting.showOptions = !setting.showOptions;
        } else if(leftClick && !ScreenUtils.isMouseOver(mouseX,mouseY,x2 - 5 - generic.getStringWidth(">"),x2, y + (generic.getStringHeight((String) (setting.selectedOption != null ? setting.selectedOption : "")) / 2),y + ((generic.getStringHeight((String) (setting.selectedOption != null ? setting.selectedOption : ""))) / 2) + 11)){
            setting.showOptions = false;
        }
    }

    static void renderButton(MatrixStack stack, int x, int y, int x1, int x2, ButtonSetting setting, int mouseX, int mouseY, boolean leftClick){
        Color c = new Color(40,40,40);
        if(ScreenUtils.isMouseOver(mouseX,mouseY,x1+3,x2-3,y+2,y + generic.getStringHeight(setting.name) + 2)){
            c = new Color(85,85,85);
            if(leftClick)
                setting.click();
        }
        Renderer2d.renderQuad(stack, c, x1 + 3,y + 2,x2 - 3, y + generic.getStringHeight(setting.name) + 2);
        generic.drawString(stack,setting.name, ((x1 + 3) + ((float) ((x2 - 3) - (x1 + 3)) / 2)) - generic.getStringWidth(setting.name) / 2,(y + 2) + (((y + 2)-(y + generic.getStringHeight(setting.name) + 2)) / 2) + generic.getStringHeight(setting.name) / 2,1,1,1,1);
    }

    public static void render(DrawContext context, int mouseX, int mouseY,boolean leftClicked, boolean rightClicked,int keyCode, int scanCode, int modifiers){
        if (categoryNames == null) {
            categoryNames = new FontRenderer(new Font[]{
                    FontManager.OpenSansExtraBold//new Font("Ubuntu", Font.PLAIN, 8)
            }, 10f);

            moduleNames = new FontRenderer(new Font[]{
                    FontManager.OpenSansBold//new Font("Ubuntu", Font.BOLD, 8)
            }, 8f);

            generic = new FontRenderer(new Font[]{
                    FontManager.OpenSansRegular//new Font("Ubuntu", Font.PLAIN, 8)
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

            if(category.initialize){
                category.x1 = (i*100)+10;
                category.x2 = ((i*100)+10)+90;
//                Cesium.LOGGER.info("x1: " + category.x1 + " | x2: " + category.x2 + " | category: " + category.getTitle());
                category.y1 = 30;
                category.y2 = 45;

                category.initialize = false;
            }

            if(drag && (category.isMouseOver(mouseX,mouseY) || category.dragging)){
                if(!category.dragging)
                    category.isDragFirstFrame = true;
                category.drag(mouseX,mouseY);
                category.dragging = true;
            } else{
                if(category.dragging)
                    category.enddrag();
                category.dragging = false;
            }

            if (rightClicked && category.isMouseOver(mouseX,mouseY)) {
                category.collapsed = !category.collapsed;
            }

            Renderer2d.renderQuad(fs, new Color(30,30,30), category.x1,category.y1,category.x2,category.y2);

            float strWidth = categoryNames.getStringWidth(category.getTitle());

            categoryNames.drawString(fs,category.getTitle(),(category.x1 + (((float) (category.x2 - category.x1) / 2))) - (strWidth / 2),((float) (category.y1 + category.y2) / 2) - (categoryNames.getStringHeight(category.getTitle()) / 2), colorsText[0], colorsText[1], colorsText[2], 1f);

            int minBodySize = 3;

            int height = 0;
            int height1 = 0;


            int yOffset = 3;

            if(!category.collapsed){
                //module height calc
                for(Module module : category.getModules()){
                    String name = module.getName();
                    int stringHeight = (int) ((moduleNames.getStringHeight(name) + 2) + 0.5);
                    height1 += stringHeight;

                    if(module.isExpanded){
                        if(module.getSettings().size() > 0)
                            height1 += 2;

                        for (Setting<?> setting : module.getSettings()){
                            if(setting instanceof BoolSetting boolSetting){
                                if(setting==module.enabled) continue;
                                height1 += 8 + (generic.getStringHeight(boolSetting.name) / 2);
                            } else if (setting instanceof StringSetting stringSetting) {
                                height1 += (generic.getStringHeight(stringSetting.name) / 2) + 16;
                            } else if(setting instanceof SliderSetting sliderSetting){
                                height1 += (generic.getStringHeight(sliderSetting.name)) + 8;
                            } else if (setting instanceof EnumSetting<?> enumSetting) {
                                height1 += (generic.getStringHeight((String) (enumSetting.selectedOption != null ? enumSetting.selectedOption : "")) / 2) + 16;
                            } else if (setting instanceof ButtonSetting buttonSetting){
                                height1 += generic.getStringHeight(buttonSetting.name) + 4;
                            } else if (setting instanceof LimitedStringSetting ltdStringSetting) {
                                height1 += (generic.getStringHeight(ltdStringSetting.name) / 2) + 16;
                            }
                        }

                        if(module.getSettings().size() > 0)
                            height1 += 2;
                    }
                }
            }

            Renderer2d.renderQuad(fs,new Color((float) 30 /255, (float) 30 /255, (float) 30 /255,0.7f), category.x1, category.y2, category.x2, category.y2 + MathHelper.clamp(height1,minBodySize,Double.MAX_VALUE));

            if(category.collapsed)
                moduleNames.drawString(fs,"...", category.x1 + (((float) (category.x2 - category.x1) / 2) - (moduleNames.getStringWidth("...") / 2)), (float) (category.y2 + (MathHelper.clamp(height1,minBodySize,Double.MAX_VALUE) / 2)) - 7,1,1,1,1);

            //modules
            if(!category.collapsed) {
                for (Module module : category.getModules()) {
                    String name = module.getName();
                    int stringHeight = (int) ((moduleNames.getStringHeight(name) + 2) + 0.5);
                    height += stringHeight;
                    moduleNames.drawString(fs, name, category.x1 + 3, category.y2 + (height - stringHeight), 1f, 1f, 1f, 1f);

                    //click handler
                    //clicked & (is in bounds)
                    if (leftClicked && ScreenUtils.isMouseOver(mouseX, mouseY, category.x1, category.x2, category.y2 + (height - stringHeight), category.y2 + height)) {
                        module.enabled.value = !module.enabled.value;
                        if(module.enabled.value)
                            module.onEnable();
                        else
                            module.onDisable();
                    } else if (rightClicked && ScreenUtils.isMouseOver(mouseX, mouseY, category.x1, category.x2, category.y2 + (height - stringHeight), category.y2 + height)) {
                        module.isExpanded = !module.isExpanded;
                    }

                    if (module.enabled.value) {
                        Renderer2d.renderQuad(fs, Constants.ColorMain, category.x1, category.y2 + (height - stringHeight), category.x1 + 1, category.y2 + (height - 1));
                    }
                    boolean isHandlingTextbox = false;
                    if (module.isExpanded) {
                        if(module.getSettings().size() > 0)
                            height += 2;
                        for (Setting<?> setting : module.getSettings()) {
                            if (setting instanceof BoolSetting boolSetting) {
                                if(setting==module.enabled) continue;
                                renderBoolSetting(fs, category.x1, (int) (category.y2 + (height + (generic.getStringHeight(setting.name) / 2))), 8, boolSetting, mouseX, mouseY, leftClicked);
                                height += 8 + (generic.getStringHeight(setting.name) / 2);
                            } else if (setting instanceof StringSetting stringSetting) {
                                renderStringSetting(fs, category.x1, (int) (category.y2 + (height + (generic.getStringHeight(setting.name) / 2) - 3)), category.x2, stringSetting, mouseX, mouseY, leftClicked);
                                if(stringSetting.selected){
                                    isHandlingTextbox = true;
                                    if(keyCode != -1){
                                        stringSetting.onKey(keyCode,scanCode,modifiers);
                                    }
                                }
                                height += (generic.getStringHeight(setting.name) / 2) + 16;
                            } else if(setting instanceof SliderSetting sliderSetting){
                                renderSliderSetting(fs, category.x1, (int) (category.y2 + (height + (generic.getStringHeight(setting.name) / 2) - 3)), category.x1, category.x2, sliderSetting, mouseX, mouseY, drag);
                                height += (generic.getStringHeight(setting.name)) + 8;
                            } else if (setting instanceof EnumSetting<?> enumSetting) {
                                renderDropdownSetting(fs, category.x1, (int) (category.y2 + (height + (generic.getStringHeight(setting.name) / 2) - 3)),category.x1, category.x2, enumSetting, mouseX, mouseY, leftClicked);
                                height += (generic.getStringHeight((String) (enumSetting.selectedOption != null ? enumSetting.selectedOption : "")) / 2) + 16;
                            } else if (setting instanceof ButtonSetting buttonSetting){
                                renderButton(fs,category.x1,category.y2 + height,category.x1,category.x2,buttonSetting,mouseX,mouseY,leftClicked);
                                height += generic.getStringHeight(buttonSetting.name) + 4;
                            }else if (setting instanceof LimitedStringSetting ltdStringSetting) {
                                renderLimitedStringSetting(fs, category.x1, (int) (category.y2 + (height + (generic.getStringHeight(setting.name) / 2) - 3)), category.x2, ltdStringSetting, mouseX, mouseY, leftClicked);
                                if (ltdStringSetting.selected) {
                                    isHandlingTextbox = true;
                                    if (keyCode != -1) {
                                        ltdStringSetting.onKey(keyCode, scanCode, modifiers);
                                    }
                                }
                                height += (generic.getStringHeight(ltdStringSetting.name) / 2) + 16;
                            }
                        }
                        if(module.getSettings().size() > 0)
                            height += 2;
                    }

                    if(module!=category.getModules().get(category.getModules().size() - 1))
                        Renderer2d.renderLine(fs, new Color(65, 65, 65), category.x1 + 4, category.y2 + height, category.x2 - 4, category.y2 + height);
                }
            }
        }
        if(keyCode == GLFW.GLFW_KEY_ESCAPE || Cesium.clickGuiKey.matchesKey(keyCode,scanCode))
            Cesium.client.setScreen(null);

        //other stuff

        fs.pop();
    }
    public static void onClicked(int mX,int mY){
        render(new DrawContext(Cesium.client,Cesium.client.getBufferBuilders().getEntityVertexConsumers()),mX,mY,true,false,-1,-1,-1);
    }
    public static void onRightClicked(int mX,int mY){
        render(new DrawContext(Cesium.client,Cesium.client.getBufferBuilders().getEntityVertexConsumers()),mX,mY,false,true,-1,-1,-1);
    }
}
