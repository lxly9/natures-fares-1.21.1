package com.natures_fares.util;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class ItemDisabler {

    public static final List<Identifier> WOOD_TYPES = List.of(
            Identifier.of("natures_spirit", "cypress"),
            Identifier.of("natures_spirit", "ghaf"),
            Identifier.of("natures_spirit", "larch"),
            Identifier.of("natures_spirit", "saxaul"),
            Identifier.of("natures_spirit", "palo_verde")
    );

    public static final List<String> WOOD_TYPES_TO_DISABLE = List.of(
            "mahogany"
    );

    private static List<Identifier> getWoodVariants(Identifier woodTypeId) {
        String modid = woodTypeId.getNamespace();
        String path = woodTypeId.getPath();

        return List.of(
                Identifier.of(modid, path + "_planks"),
                Identifier.of(modid, path + "_stairs"),
                Identifier.of(modid, path + "_slab"),
                Identifier.of(modid, path + "_fence"),
                Identifier.of(modid, path + "_fence_gate"),
                Identifier.of(modid, path + "_door"),
                Identifier.of(modid, path + "_trapdoor"),
                Identifier.of(modid, path + "_button"),
                Identifier.of(modid, path + "_pressure_plate"),
                Identifier.of(modid, path + "_sign"),
                Identifier.of(modid, path + "_hanging_sign"),
                Identifier.of(modid, path + "_boat"),
                Identifier.of(modid, path + "_chest_boat"),
                Identifier.of("bountifulfares", path + "_pickets"),
                Identifier.of(modid, path + "_trellis")
        );
    }

    public static final Set<Identifier> ALL_WOOD_VARIANTS = WOOD_TYPES.stream()
            .flatMap(typeId -> getWoodVariants(typeId).stream())
            .collect(Collectors.toSet());
}
