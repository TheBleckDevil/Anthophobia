package net.blackdevil.anthophobia.block;

import net.blackdevil.anthophobia.Anthophobia;
import net.blackdevil.anthophobia.block.custom.ChisaBlock;
import net.blackdevil.anthophobia.block.custom.FoxgloveBlock;
import net.blackdevil.anthophobia.block.custom.LycorisRadiataBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;




public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS  = DeferredRegister.createBlocks(Anthophobia.MODID);



    public static final DeferredBlock<TallFlowerBlock> FOXGLOVE_BLOCK = BLOCKS.register("foxglove_block",
            () -> new FoxgloveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH)));

    public static final DeferredBlock<FlowerBlock> CHISA_BLOCK = BLOCKS.register("chisa_block",
            () -> new ChisaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY)));

    public static final DeferredBlock<Block> LYCORIS_RADIATA_BLOCK = BLOCKS.register("lycoris_radiata_block",
            () -> new LycorisRadiataBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION))
    );



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}