package net.blackdevil.anthophobia.datagen;

import net.blackdevil.anthophobia.Anthophobia;
import net.blackdevil.anthophobia.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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
}