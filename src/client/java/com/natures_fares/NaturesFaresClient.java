package com.natures_fares;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.hibiscus.naturespirit.registration.NSWoods;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;

public class NaturesFaresClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.GHAF.getLog(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.GHAF.getStrippedLog(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.GHAF.getWood(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.GHAF.getStrippedWood(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.CYPRESS.getLog(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.CYPRESS.getStrippedLog(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.CYPRESS.getWood(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.CYPRESS.getStrippedWood(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.LARCH.getLog(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.LARCH.getStrippedLog(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.LARCH.getWood(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.LARCH.getStrippedWood(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.MAHOGANY.getLog(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.MAHOGANY.getStrippedLog(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.MAHOGANY.getWood(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.MAHOGANY.getStrippedWood(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.SAXAUL.getLog(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.SAXAUL.getStrippedLog(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.SAXAUL.getWood(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.SAXAUL.getStrippedWood(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.PALO_VERDE.getLog(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.PALO_VERDE.getStrippedLog(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.PALO_VERDE.getWood(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(NSWoods.PALO_VERDE.getStrippedWood(), RenderLayer.getCutout());

		ColorProviderRegistry.BLOCK.register(
				(blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? BiomeColors.getFoliageColor(blockAndTintGetter, blockPos) : -1, NSWoods.LARCH.getLog());
	}
}