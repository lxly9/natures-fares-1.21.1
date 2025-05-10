package com.natures_fares.mixin;

import com.natures_fares.util.ItemDisabler;
import net.minecraft.item.Item;
import net.minecraft.resource.featuretoggle.ToggleableFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(method = "isEnabled", at = @At("HEAD"), cancellable = true)
    private void modifyIsEnabled(CallbackInfoReturnable<Boolean> cir) {
        Item self = (Item) this;

        if (shouldDisable(self)) {
            cir.setReturnValue(false);
        }
    }

    @Unique
    private boolean shouldDisable(Item item) {
        return ItemDisabler.shouldDisable(item);
    }
}