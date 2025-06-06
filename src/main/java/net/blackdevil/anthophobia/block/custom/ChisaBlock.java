package net.blackdevil.anthophobia.block.custom;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ChisaBlock extends FlowerBlock {

    public ChisaBlock(BlockBehaviour.Properties properties) {
        super(MobEffects.MOVEMENT_SLOWDOWN, 100, properties);
    }
}
