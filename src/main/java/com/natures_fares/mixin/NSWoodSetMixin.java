package com.natures_fares.mixin;

import net.hecco.bountifulfares.block.custom.FruitLogBlock;
import net.hecco.bountifulfares.block.custom.StrippedFruitLogBlock;
import net.hibiscus.naturespirit.NatureSpirit;
import net.hibiscus.naturespirit.registration.sets.WoodSet;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.hecco.bountifulfares.registry.content.BFBlocks;

import static com.natures_fares.util.ItemDisabler.WOOD_TYPES;
import static net.hecco.bountifulfares.BountifulFares.isModLoaded;

@Mixin(WoodSet.class)
public abstract class NSWoodSetMixin {
    @Final @Shadow private Identifier name;
    @Final @Shadow private WoodSet.WoodPreset woodPreset;

    @Inject(method = "createLog", at = @At("HEAD"), cancellable = true)
    private void replaceLog(CallbackInfoReturnable<Block> cir) {
        if (shouldReplace()) return;

        String logName;
        if (this.woodPreset == WoodSet.WoodPreset.BAMBOO) {
            logName = this.name.getPath() + "_block";
        } else if (this.woodPreset == WoodSet.WoodPreset.NETHER) {
            logName = this.name.getPath() + "_stem";
        } else {
            logName = this.name.getPath() + "_log";
        }

        FruitLogBlock log = new FruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.APPLE_LOG));
        cir.setReturnValue(registerNsBlock(logName, log));
    }

    @Inject(method = "createStrippedLog", at = @At("HEAD"), cancellable = true)
    private void replaceStrippedLog(CallbackInfoReturnable<Block> cir) {
        if (shouldReplace()) return;

        String logName;
        if (this.woodPreset == WoodSet.WoodPreset.BAMBOO) {
            logName = this.name.getPath() + "_block";
        } else if (this.woodPreset == WoodSet.WoodPreset.NETHER) {
            logName = this.name.getPath() + "_stem";
        } else {
            logName = this.name.getPath() + "_log";
        }

        FruitLogBlock strippedLog = new FruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.APPLE_LOG));
        cir.setReturnValue(registerNsBlock("stripped_" + logName, strippedLog));
    }

    @Inject(method = "createWood", at = @At("HEAD"), cancellable = true)
    private void replaceWood(CallbackInfoReturnable<Block> cir) {
        if (shouldReplace()) return;

        String woodName;
        if (this.woodPreset == WoodSet.WoodPreset.BAMBOO) {
            woodName = this.name.getPath() + "_block";
        } else if (this.woodPreset == WoodSet.WoodPreset.NETHER) {
            woodName = this.name.getPath() + "_hyphae";
        } else {
            woodName = this.name.getPath() + "_wood";
        }

        FruitLogBlock wood = new FruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.APPLE_LOG));
        cir.setReturnValue(registerNsBlock(woodName, wood));
    }

    @Inject(method = "createStrippedWood", at = @At("HEAD"), cancellable = true)
    private void replaceStrippedWood(CallbackInfoReturnable<Block> cir) {
        if (shouldReplace()) return;

        String woodName;
        if (this.woodPreset == WoodSet.WoodPreset.NETHER) {
            woodName = this.name.getPath() + "_hyphae";
        } else {
            woodName = this.name.getPath() + "_wood";
        }

        StrippedFruitLogBlock strippedWood = new StrippedFruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.APPLE_LOG));
        cir.setReturnValue(registerNsBlock("stripped_" + woodName, strippedWood));
    }

    @Unique
    private boolean shouldReplace() {
        String wood = name.getPath();
        return !isModLoaded("natures_spirit") && !wood.equals(WOOD_TYPES);
    }

    @Unique
    private Block registerNsBlock(String logName, Block block) {
        registerNsBlockItem(logName, block);
        return Registry.register(Registries.BLOCK, Identifier.of(NatureSpirit.MOD_ID, logName), block);
    }

    @Unique
    private static void registerNsBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(NatureSpirit.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }
}