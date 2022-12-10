package net.fabricmc.tanzanite.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.tanzanite.TanzaniteExpansion;
import net.fabricmc.tanzanite.block.ModBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    public static final Item TANZANITE = registerItem("tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    public static final Item POLYDENUM_SHARD = registerItem("polydenum_shard",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    public static final Item POLYDENUM_SEEDS = registerItem("polydenum_seeds",
            new AliasedBlockItem(ModBlocks.POLYDENUM_CROP, new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    public static final Item IRADIUM_CRYSTAL = registerItem("iradium_crystal",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(TanzaniteExpansion.MOD_ID, name), item);
    }    

    public static void registerModItems() {
        TanzaniteExpansion.LOGGER.debug("Registering Mod Items for " + TanzaniteExpansion.MOD_ID);
    }
}
