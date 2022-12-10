package net.fabricmc.tanzanite.recipe;

import net.fabricmc.tanzanite.TanzaniteExpansion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(TanzaniteExpansion.MOD_ID, ChemicalInfuserRecipe.Serializer.ID),
                ChemicalInfuserRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(TanzaniteExpansion.MOD_ID, ChemicalInfuserRecipe.Type.ID),
                ChemicalInfuserRecipe.Type.INSTANCE);
    }
}
