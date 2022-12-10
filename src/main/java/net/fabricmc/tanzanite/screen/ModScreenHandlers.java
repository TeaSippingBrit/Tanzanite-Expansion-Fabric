package net.fabricmc.tanzanite.screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<ChemicalInfuserScreenHandler> CHEMICAL_INFUSER_SCREEN_HANDLER;
    public static void registerAllScreenHandlers() {
        CHEMICAL_INFUSER_SCREEN_HANDLER = new ScreenHandlerType<>(ChemicalInfuserScreenHandler::new);
    }
}
