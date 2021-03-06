package io.github.redstoneparadox.nicetohave.mixin.block;

import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallMountedBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import io.github.redstoneparadox.nicetohave.block.CustomButtonBlock;
import io.github.redstoneparadox.nicetohave.config.Config;

@Mixin(AbstractButtonBlock.class)
public abstract class AbstractButtonBlockMixin extends WallMountedBlock {

    // private boolean canPlaceUnderwater = Config.Redstone.INSTANCE.getUnderwaterSwitches();

    protected AbstractButtonBlockMixin(Settings block$Settings_1) {
        super(block$Settings_1);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void ctor(boolean boolean_1, Settings block$Settings_1, CallbackInfo ci) {
        //setDefaultState(getDefaultState().with(Properties.WATERLOGGED, false));
    }

    @Inject(method = "appendProperties", at = @At("HEAD"))
    private void appendProperties(StateManager.Builder<Block, BlockState> stateFactory$Builder_1, CallbackInfo ci) {
        // stateFactory$Builder_1.add(Properties.WATERLOGGED);
    }

    @Inject(method = "getPressTicks", at = @At("HEAD"), cancellable = true)
    private void getPressTicks(CallbackInfoReturnable<Integer> cir) {
        AbstractButtonBlock self = (AbstractButtonBlock)(Object)this;

        if (self instanceof CustomButtonBlock) {
            cir.setReturnValue(((CustomButtonBlock) self).getPressTicks());
        }
    }

    /*
    @Override
    public FluidState getFluidState(BlockState blockState_1) {
        if (canPlaceUnderwater && blockState_1.get(Properties.WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(blockState_1);
    }
     */

    /*
    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
        FluidState fluidState_1 = itemPlacementContext_1.getWorld().getFluidState(itemPlacementContext_1.getBlockPos());
        BlockState normalState = super.getPlacementState(itemPlacementContext_1);
        if (canPlaceUnderwater) {
            return normalState.with(Properties.WATERLOGGED, fluidState_1.getFluid() == Fluids.WATER);
        }
        return normalState;
    }

     */

    /*
    @Override
    public BlockState getStateForNeighborUpdate(BlockState blockState_1, Direction direction_1, BlockState blockState_2, WorldAccess iWorld_1, BlockPos blockPos_1, BlockPos blockPos_2) {
        if (canPlaceUnderwater && blockState_1.get(Properties.WATERLOGGED)) {
            iWorld_1.getFluidTickScheduler().schedule(blockPos_1, Fluids.WATER, Fluids.WATER.getTickRate(iWorld_1));
        }
        return super.getStateForNeighborUpdate(blockState_1, direction_1, blockState_2, iWorld_1, blockPos_1, blockPos_2);
    }

     */
}
