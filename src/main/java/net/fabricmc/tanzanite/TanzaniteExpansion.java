package net.fabricmc.tanzanite;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.tanzanite.block.ModBlocks;
import net.fabricmc.tanzanite.fluid.ModFluids;
import net.fabricmc.tanzanite.item.ModItems;
import net.fabricmc.tanzanite.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TanzaniteExpansion implements ModInitializer {
	public static final String MOD_ID = "tanzaniteexpansion";
	public static final Logger LOGGER = LoggerFactory.getLogger("MOD_ID");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModFluids.register();
		ModLootTableModifiers.modifyLootTables();
	}
}