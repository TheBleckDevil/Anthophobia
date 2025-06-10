package net.blackdevil.anthophobia.block.custom;

import net.blackdevil.anthophobia.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ChisaBlock extends Block {
    public static final IntegerProperty CHISAS = IntegerProperty.create("chisas", 1, 4);

    // Optional: Define shapes per chisas count, or use a single shape
    private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 8, 14);

    public ChisaBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(CHISAS, 1));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CHISAS);
    }

    // This lets you "stack" by placing the block multiple times
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState existingState = context.getLevel().getBlockState(context.getClickedPos());
        if (existingState.is(this)) {
            int currentCount = existingState.getValue(CHISAS);
            if (currentCount < 4) {
                return existingState.setValue(CHISAS, currentCount + 1);
            }
        }
        BlockState defaultState = this.defaultBlockState();
        return canSurvive(defaultState, context.getLevel(), context.getClickedPos()) ? defaultState : null;
    }

    // This allows placing the block to replace the existing block and stack it
    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return !context.isSecondaryUseActive() // not sneaking
                && context.getItemInHand().is(this.asItem()) // holding same block
                && state.getValue(CHISAS) < 4
                || super.canBeReplaced(state, context);
    }

    // Simple shape, can customize if you want different shapes per CHISAS value
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }


    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, net.minecraft.world.level.LevelAccessor levelAccessor, BlockPos pos, BlockPos neighborPos) {
        if (!canSurvive(state, levelAccessor, pos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(state, direction, neighborState, levelAccessor, pos, neighborPos);
    }

    @Override
    public void playerDestroy(net.minecraft.world.level.Level level, net.minecraft.world.entity.player.Player player, BlockPos pos, BlockState state, net.minecraft.world.level.block.entity.BlockEntity blockEntity, net.minecraft.world.item.ItemStack tool) {
        int count = state.getValue(CHISAS);
        popResource(level, pos, new ItemStack(this, count));
        super.playerDestroy(level, player, pos, state, blockEntity, tool);
    }
    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged(state, level, pos, block, fromPos, isMoving);

        if (!state.canSurvive(level, pos)) {
            // Drop the block items
            popResource(level, pos, new ItemStack(this, state.getValue(CHISAS)));
            // Remove the block
            level.removeBlock(pos, false);
        }

    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockState belowState = world.getBlockState(pos.below());
        return belowState.is(ModBlocks.WITHERED_GRASS.get());
    }

}