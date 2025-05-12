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
        if (!shouldReplace()) return;

        String logName = getLogName();
        FruitLogBlock log = new FruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.APPLE_LOG));
        cir.setReturnValue(registerNsBlock(logName, log));
    }

    @Inject(method = "createStrippedLog", at = @At("HEAD"), cancellable = true)
    private void replaceStrippedLog(CallbackInfoReturnable<Block> cir) {
        if (!shouldReplace()) return;

        String logName = getLogName();
        FruitLogBlock strippedLog = new FruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.STRIPPED_APPLE_LOG));
        cir.setReturnValue(registerNsBlock("stripped_" + logName, strippedLog));
    }

    @Inject(method = "createWood", at = @At("HEAD"), cancellable = true)
    private void replaceWood(CallbackInfoReturnable<Block> cir) {
        if (!shouldReplace()) return;

        String woodName = getWoodName();
        FruitLogBlock wood = new FruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.APPLE_WOOD));
        cir.setReturnValue(registerNsBlock(woodName, wood));
    }

    @Inject(method = "createStrippedWood", at = @At("HEAD"), cancellable = true)
    private void replaceStrippedWood(CallbackInfoReturnable<Block> cir) {
        if (!shouldReplace()) return;

        String woodName = getWoodName();
        StrippedFruitLogBlock strippedWood = new StrippedFruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.STRIPPED_APPLE_WOOD));
        cir.setReturnValue(registerNsBlock("stripped_" + woodName, strippedWood));
    }

    @Unique
    private boolean shouldReplace() {
        return isModLoaded("natures_spirit") && WOOD_TYPES.contains(name);
    }

    @Unique
    private String getLogName() {
        if (this.woodPreset == WoodSet.WoodPreset.BAMBOO) {
            return name.getPath() + "_block";
        } else if (this.woodPreset == WoodSet.WoodPreset.NETHER) {
            return name.getPath() + "_stem";
        } else {
            return name.getPath() + "_log";
        }
    }

    @Unique
    private String getWoodName() {
        if (this.woodPreset == WoodSet.WoodPreset.BAMBOO) {
            return name.getPath() + "_block";
        } else if (this.woodPreset == WoodSet.WoodPreset.NETHER) {
            return name.getPath() + "_hyphae";
        } else {
            return name.getPath() + "_wood";
        }
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