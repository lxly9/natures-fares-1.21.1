package com.natures_fares.mixin;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.resource.featuretoggle.ToggleableFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import static com.natures_fares.util.ItemDisabler.ALL_WOOD_VARIANTS;

@Mixin(Block.class)
public abstract class BlockMixin implements ToggleableFeature {

    @Shadow
    private final RegistryEntry.Reference<Block> registryEntry = Registries.BLOCK.createEntry((Block) (Object) this);

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return ALL_WOOD_VARIANTS.contains(registryEntry.registryKey().getValue());
    }
}