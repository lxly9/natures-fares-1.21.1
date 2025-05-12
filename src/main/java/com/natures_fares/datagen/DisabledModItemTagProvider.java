package com.natures_fares.datagen;

import com.natures_fares.util.ItemDisabler;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class DisabledModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public static final TagKey<Item> DISABLED_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of("item_disabler", "disabled_items"));

    public DisabledModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        ItemDisabler.ALL_WOOD_VARIANTS.forEach(id ->
                getOrCreateTagBuilder(DISABLED_ITEMS).add(id));
    }
}