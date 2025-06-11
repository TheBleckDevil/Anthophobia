package net.blackdevil.anthophobia.datagen;

import net.blackdevil.anthophobia.Anthophobia;
import net.blackdevil.anthophobia.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Anthophobia.MODID, exFileHelper);

    }

    @Override
    protected void registerStatesAndModels() {
        tallFlower(ModBlocks.FOXGLOVE_BLOCK.get(), "foxglove_block");
        crossFlower(ModBlocks.LYCORIS_RADIATA_BLOCK.get(), "lycoris_radiata_block");
        crossFlower(ModBlocks.BLOOD_ROSE.get(), "blood_rose");
        tallFlower(ModBlocks.BLOOD_ROSE_BUSH.get(), "blood_rose_bush");


        logBlock(((RotatedPillarBlock) ModBlocks.WITHERED_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.WITHERED_WOOD.get()), blockTexture(ModBlocks.WITHERED_LOG.get()), blockTexture(ModBlocks.WITHERED_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_WITHERED_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_WITHERED_WOOD.get()), blockTexture(ModBlocks.STRIPPED_WITHERED_LOG.get()), blockTexture(ModBlocks.STRIPPED_WITHERED_LOG.get()));

        blockItem(ModBlocks.WITHERED_LOG);
        blockItem(ModBlocks.WITHERED_WOOD);
        blockItem(ModBlocks.STRIPPED_WITHERED_LOG);
        blockItem(ModBlocks.STRIPPED_WITHERED_WOOD);

        blockWithItem(ModBlocks.WITHERED_PLANKS);

    }

    private void tallFlower(Block block, String name) {
        getVariantBuilder(block)
                .partialState()
                .with(TallFlowerBlock.HALF, DoubleBlockHalf.LOWER)
                .modelForState()
                .modelFile(models().cross(name + "_bottom", modLoc("block/" + name + "_bottom")))
                .addModel()
                .partialState()
                .with(TallFlowerBlock.HALF, DoubleBlockHalf.UPPER)
                .modelForState()
                .modelFile(models().cross(name + "_top", modLoc("block/" + name + "_top")))
                .addModel();



        }
    private void crossFlower(Block block, String name) {
        getVariantBuilder(block).partialState().setModels(
                ConfiguredModel.builder()
                        .modelFile(models().cross(name, modLoc("block/" + name)))
                        .build()
        );
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("anthophobia:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("anthophobia:block/" + deferredBlock.getId().getPath() + appendix));
    }
}