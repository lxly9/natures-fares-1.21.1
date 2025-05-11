package com.natures_fares.mixin;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.resource.featuretoggle.ToggleableFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import java.util.Objects;

import static com.natures_fares.util.ItemDisabler.ALL_WOOD_VARIANTS;

@Mixin(Item.class)
public abstract class ItemMixin implements ToggleableFeature {

    @Shadow
    private final RegistryEntry.Reference<Item> registryEntry = Registries.ITEM.createEntry((Item) (Object) this);

    @Unique
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return !ALL_WOOD_VARIANTS.contains(registryEntry.registryKey().getValue());
    }
}