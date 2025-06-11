package net.blackdevil.anthophobia.datagen;

import net.blackdevil.anthophobia.Anthophobia;
import net.blackdevil.anthophobia.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Anthophobia.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.WITHERED_LOG.get().asItem())
                .add(ModBlocks.WITHERED_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_WITHERED_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_WITHERED_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.WITHERED_PLANKS.get().asItem());

    }
}
