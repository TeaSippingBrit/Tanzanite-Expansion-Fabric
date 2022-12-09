package net.fabricmc.tanzanite.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.tanzanite.TanzaniteExpansion;
import net.fabricmc.tanzanite.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {
    public static FlowableFluid STILL_LIQUID_TANZANITE;
    public static FlowableFluid FLOWING_LIQUID_TANZANITE;
    public static Block LIQUID_TANZANITE_BLOCK;
    public static Item LIQUID_TANZANITE_BUCKET;

    public static void register() {
        STILL_LIQUID_TANZANITE = Registry.register(Registry.FLUID,
                new Identifier(TanzaniteExpansion.MOD_ID, "liquid_tanzanite"), new LiquidTanzanite.Still());
        FLOWING_LIQUID_TANZANITE = Registry.register(Registry.FLUID,
                new Identifier(TanzaniteExpansion.MOD_ID, "flowing_liquid_tanzanite"), new LiquidTanzanite.Flowing());

        LIQUID_TANZANITE_BLOCK = Registry.register(Registry.BLOCK, new Identifier(TanzaniteExpansion.MOD_ID, "liquid_tanzanite_block"),
                new FluidBlock(ModFluids.STILL_LIQUID_TANZANITE, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        LIQUID_TANZANITE_BUCKET = Registry.register(Registry.ITEM, new Identifier(TanzaniteExpansion.MOD_ID, "liquid_tanzanite_bucket"),
                new BucketItem(ModFluids.STILL_LIQUID_TANZANITE, new FabricItemSettings().group(ModItemGroup.TANZANITE).recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}
