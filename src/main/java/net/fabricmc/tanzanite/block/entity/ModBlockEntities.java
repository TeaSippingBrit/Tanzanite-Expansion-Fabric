package net.fabricmc.tanzanite.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.tanzanite.TanzaniteExpansion;
import net.fabricmc.tanzanite.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<ChemicalInfuserBlockEntity> CHEMICAL_INFUSER;
    public static void registerBlockEntities() {
        CHEMICAL_INFUSER = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(TanzaniteExpansion.MOD_ID, "chemical_infuser"), FabricBlockEntityTypeBuilder.create(ChemicalInfuserBlockEntity::new,
                ModBlocks.CHEMICAL_INFUSER).build(null));
    }
}
