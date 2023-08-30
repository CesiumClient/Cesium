package net.cesiumclient.cesium.mixin;

import net.cesiumclient.cesium.rendering.clickgui.modules.impl.render.AntiTNTLag;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.TntEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.TntEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TntEntityRenderer.class)
public class TntEntityRendererMixin {
    @Inject(at=@At("HEAD"),method = "render(Lnet/minecraft/entity/TntEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V",cancellable = true)
    public void shouldRender(TntEntity tntEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci){
        if(AntiTNTLag.enabled)
            ci.cancel();
    }
    @Inject(at=@At("HEAD"),method = "render(Lnet/minecraft/entity/Entity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V",cancellable = true)
    public void shouldRender(Entity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
        if (AntiTNTLag.enabled)
            ci.cancel();
    }
}
