package com.natures_fares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hibiscus.naturespirit.registration.NSWoods;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

import static com.natures_fares.datagen.BFtoNSTemplateGenerator.registerFruitLogModels;


public class BFtoNSModelProvider extends FabricModelProvider {
    public BFtoNSModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        registerFruitLogModels(blockStateModelGenerator, NSWoods.GHAF.getLog(), NSWoods.GHAF.getWood(), NSWoods.GHAF.getLeaves());
        LOGGER.info("Generated block state models for Nature's Fares");
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
