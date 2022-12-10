package net.fabricmc.tanzanite;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.tanzanite.block.ModBlocks;
import net.fabricmc.tanzanite.fluid.ModFluids;
import net.fabricmc.tanzanite.screen.ChemicalInfuserScreen;
import net.fabricmc.tanzanite.screen.ModScreenHandlers;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class TanzaniteExpansionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POLYDENUM_CROP, RenderLayer.getCutout());
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_LIQUID_TANZANITE, ModFluids.FLOWING_LIQUID_TANZANITE,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        0xA100caf7
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_LIQUID_TANZANITE, ModFluids.FLOWING_LIQUID_TANZANITE);

        HandledScreens.register(ModScreenHandlers.CHEMICAL_INFUSER_SCREEN_HANDLER, ChemicalInfuserScreen::new);
    }
}
