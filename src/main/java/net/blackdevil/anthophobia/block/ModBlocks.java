package net.blackdevil.anthophobia.block;

import com.mojang.blaze3d.shaders.Effect;
import net.blackdevil.anthophobia.Anthophobia;
import net.blackdevil.anthophobia.block.custom.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforgespi.locating.ForgeFeature;

import javax.annotation.Nullable;


public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS  = DeferredRegister.createBlocks(Anthophobia.MODID);



    public static final DeferredBlock<TallFlowerBlock> FOXGLOVE_BLOCK = BLOCKS.register("foxglove_block",
            () -> new FoxgloveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH)));

    public static final DeferredBlock<Block> CHISA_BLOCK = BLOCKS.register("chisa_block",
            () -> new ChisaBlock(BlockBehaviour.Properties.of().instabreak().noOcclusion().noCollission().sound(SoundType.GRASS)));

    public static final DeferredBlock<FlowerBlock> LYCORIS_RADIATA_BLOCK = BLOCKS.register("lycoris_radiata_block",
            () -> new LycorisRadiataBlock(MobEffects.POISON, 0.0F, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));

    public static final DeferredBlock<FlowerBlock> BLOOD_ROSE = BLOCKS.register("blood_rose",
            () -> new BloodRose(MobEffects.POISON, 0.0F, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));

    public static final DeferredBlock<TallFlowerBlock> BLOOD_ROSE_BUSH = BLOCKS.register("blood_rose_bush",
            () -> new BloodRoseBush(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH)));

    public static final DeferredBlock<Block> WITHERED_GRASS = BLOCKS.register("withered_grass",
            () -> new WitheredGrass(BlockBehaviour.Properties.of().sound(SoundType.GRASS).randomTicks().explosionResistance(0.6f)));

    public static final DeferredBlock<Block> WITHERED_LOG = BLOCKS.register("withered_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> WITHERED_WOOD = BLOCKS.register("withered_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_WITHERED_LOG = BLOCKS.register("stripped_withered_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_WITHERED_WOOD = BLOCKS.register("stripped_withered_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));



    public static final DeferredBlock<Block> WITHERED_PLANKS = BLOCKS.register("withered_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}