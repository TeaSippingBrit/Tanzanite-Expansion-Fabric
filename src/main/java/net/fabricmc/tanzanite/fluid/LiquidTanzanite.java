package net.fabricmc.tanzanite.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.Optional;

public abstract class LiquidTanzanite extends FlowableFluid {
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }
    @Override
    protected boolean isInfinite() {
        return true;
    }
    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        final BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }
    @Override
    protected int getFlowSpeed(WorldView world) {
        return 8;
    }
    @Override
    protected int getLevelDecreasePerBlock(WorldView world) {
        return 1;
    }
    @Override
    public int getTickRate(WorldView world) {
        return 5;
    }
    @Override
    protected float getBlastResistance() {
        return 100F;
    }
    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return false;
    }
    @Override
    protected void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
        if (!state.isStill() && !(Boolean)state.get(FALLING)) {
            if (random.nextInt(64) == 0) {
                world.playSound((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5,
                        SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F,
                        random.nextFloat() + 0.5F, true);
            }
        } else if (random.nextInt(10) == 0) {
            world.addParticle(ParticleTypes.UNDERWATER, (double)pos.getX() + random.nextDouble(), (double)pos.getY() + random.nextDouble(),
                    (double)pos.getZ() + random.nextDouble(), 0.0, 0.0, 0.0);
        }

    }

    @Override
    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.of(SoundEvents.ITEM_BUCKET_FILL);
    }
    @Override
    public Fluid getStill() {
        return ModFluids.STILL_LIQUID_TANZANITE;
    }
    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_LIQUID_TANZANITE;
    }
    @Override
    public Item getBucketItem() {
        return ModFluids.LIQUID_TANZANITE_BUCKET;
    }
    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModFluids.LIQUID_TANZANITE_BLOCK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }
    @Override
    public boolean isStill(FluidState state) {
        return false;
    }
    public static class Flowing extends LiquidTanzanite {
        public Flowing() {

        }
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }
        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }
        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }
    public static class Still extends LiquidTanzanite {
        public Still() {

        }
        @Override
        public int getLevel(FluidState state) {
            return 8;
        }
        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }
}
