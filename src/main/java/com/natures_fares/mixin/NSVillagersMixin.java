package com.natures_fares.mixin;

import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerTypeHelper;
import net.hibiscus.naturespirit.registration.NSBiomes;
import net.hibiscus.naturespirit.util.NSVillagers;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NSVillagers.class)
public class NSVillagersMixin {

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/fabricmc/fabric/api/object/builder/v1/villager/VillagerTypeHelper;register(Lnet/minecraft/util/Identifier;)Lnet/minecraft/village/VillagerType;"))
    private static VillagerType redirectRegister(Identifier id) {
        if (id.getPath().equals("coconut")) {
            return null;
        }
        return VillagerTypeHelper.register(id);
    }
    @Inject(method = "registerVillagers", at = @At("HEAD"), remap = false)
    private static void removeCoconutMapping(CallbackInfo ci) {
        VillagerType.BIOME_TO_TYPE.remove(NSBiomes.TROPICAL_SHORES);
    }
}

