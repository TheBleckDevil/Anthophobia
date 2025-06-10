package net.blackdevil.anthophobia.block.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import java.util.Random;


public class WitheredGrass extends Block {

    public WitheredGrass(BlockBehaviour.Properties properties) {
        super(properties);
    }
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockPos targetPos = pos.offset(
                random.nextInt(3) - 1,
                random.nextInt(3) - 1,
                random.nextInt(3) - 1
        );

        BlockState targetState = level.getBlockState(targetPos);

        if (targetState.is(Blocks.GRASS_BLOCK) ||
                targetState.is(Blocks.DIRT) ||
                targetState.is(Blocks.COARSE_DIRT) ||
                targetState.is(Blocks.PODZOL) ||
                targetState.is(Blocks.MYCELIUM)) {
            // Spread unconditionally, no light check
            level.setBlock(targetPos, this.defaultBlockState(), 3);
        }
    }
}