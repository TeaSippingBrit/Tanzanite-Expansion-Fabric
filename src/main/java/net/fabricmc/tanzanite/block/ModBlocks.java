package net.fabricmc.tanzanite.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.tanzanite.TanzaniteExpansion;
import net.fabricmc.tanzanite.block.custom.ChemicalInfuserBlock;
import net.fabricmc.tanzanite.block.custom.PolydenumCropBlock;
import net.fabricmc.tanzanite.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block", new Block(FabricBlockSettings.of(Material.METAL).strength(3).requiresTool()), ModItemGroup.TANZANITE);
    public static final Block TANZANITE_ORE = registerBlock("tanzanite_ore", new OreBlock(FabricBlockSettings.of(Material.METAL).strength(3).requiresTool(),UniformIntProvider.create(3,7)), ModItemGroup.TANZANITE);
    public static final Block DEEPSLATE_TANZANITE_ORE = registerBlock("deepslate_tanzanite_ore", new OreBlock(FabricBlockSettings.of(Material.METAL).strength(4.5f, 3f).requiresTool(),UniformIntProvider.create(3,7)), ModItemGroup.TANZANITE);
    public static final Block POLYDENUM_BLOCK = registerBlock("polydenum_block", new Block(FabricBlockSettings.of(Material.METAL).strength(3).requiresTool()), ModItemGroup.TANZANITE);
    public static final Block POLYDENUM_CROP = registerBlockWithoutItem("polydenum_crop", new PolydenumCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));
    public static final Block CHEMICAL_INFUSER = registerBlock("chemical_infuser", new ChemicalInfuserBlock(FabricBlockSettings.of(Material.METAL).strength(3).requiresTool().nonOpaque()), ModItemGroup.TANZANITE);
    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(TanzaniteExpansion.MOD_ID, name), block);
    }
    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(TanzaniteExpansion.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(TanzaniteExpansion.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        TanzaniteExpansion.LOGGER.debug("Registering ModBlocks for " + TanzaniteExpansion.MOD_ID);
    }
}
