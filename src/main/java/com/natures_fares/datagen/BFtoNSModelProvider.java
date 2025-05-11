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
        registerFruitLogModels(blockStateModelGenerator, NSWoods.CYPRESS.getLog(), NSWoods.CYPRESS.getWood(), NSWoods.CYPRESS.getLeaves());
        registerFruitLogModels(blockStateModelGenerator, NSWoods.GHAF.getLog(), NSWoods.GHAF.getWood(), NSWoods.GHAF.getLeaves());
        registerFruitLogModels(blockStateModelGenerator, NSWoods.LARCH.getLog(), NSWoods.LARCH.getWood(), NSWoods.LARCH.getLeaves());
        registerFruitLogModels(blockStateModelGenerator, NSWoods.SAXAUL.getLog(), NSWoods.SAXAUL.getWood(), NSWoods.SAXAUL.getLeaves());
        registerFruitLogModels(blockStateModelGenerator, NSWoods.PALO_VERDE.getLog(), NSWoods.PALO_VERDE.getWood(), NSWoods.PALO_VERDE.getLeaves());
        registerFruitLogModels(blockStateModelGenerator, NSWoods.CYPRESS.getStrippedLog(), NSWoods.CYPRESS.getStrippedWood(), NSWoods.CYPRESS.getLeaves());
        registerFruitLogModels(blockStateModelGenerator, NSWoods.GHAF.getStrippedLog(), NSWoods.GHAF.getStrippedWood(), NSWoods.GHAF.getLeaves());
        registerFruitLogModels(blockStateModelGenerator, NSWoods.LARCH.getStrippedLog(), NSWoods.LARCH.getStrippedWood(), NSWoods.LARCH.getLeaves());
        registerFruitLogModels(blockStateModelGenerator, NSWoods.SAXAUL.getStrippedLog(), NSWoods.SAXAUL.getStrippedWood(), NSWoods.SAXAUL.getLeaves());
        registerFruitLogModels(blockStateModelGenerator, NSWoods.PALO_VERDE.getStrippedLog(), NSWoods.PALO_VERDE.getStrippedWood(), NSWoods.PALO_VERDE.getLeaves());
        LOGGER.info("Generated block state models for Nature's Fares");
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
