package net.fabricmc.tanzanite.block.custom;

import net.fabricmc.tanzanite.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class PolydenumCropBlock extends CropBlock {
    public static final IntProperty AGE = IntProperty.of("age",0,6);
    public PolydenumCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.POLYDENUM_SEEDS;
    }
    @Override
    public int getMaxAge() {
        return 6;
    }
    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
