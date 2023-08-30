package net.cesiumclient.cesium.mixin;

import net.cesiumclient.cesium.rendering.clickgui.modules.impl.render.AntiTNTLag;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Explosion.class)
public abstract class ExplosionMixin {
    @Shadow public abstract void affectWorld(boolean particles);

    @Inject(at=@At("HEAD"),method = "affectWorld",cancellable = true)
    public void affectWorld(boolean particles, CallbackInfo ci){
        if(AntiTNTLag.enabled){
            if(!particles) return;
            this.affectWorld(false);
            ci.cancel();
        }
    }
}
