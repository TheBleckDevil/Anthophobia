package net.blackdevil.anthophobia.datagen;

import net.blackdevil.anthophobia.Anthophobia;
import net.blackdevil.anthophobia.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Anthophobia.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Existing foxglove tall flower registration — keep it as is
        tallFlower(ModBlocks.FOXGLOVE_BLOCK.get(), "foxglove_block");
        generateChisaModel();
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
    private void generateChisaModel() {
        BlockModelBuilder chisaModel = models().withExistingParent("chisa_block", mcLoc("block/block"))
                .texture("stem", modLoc("block/chisa_stem"))
                .texture("flower", modLoc("block/chisa_flower"));

        // Stem pillar: 2x2 column from (7,0,7) to (9,12,9)
        chisaModel.element()
                .from(0, 0, 7.5f).to(16, 12, 8.5f)
                .face(Direction.NORTH).texture("#stem").end()
                .face(Direction.SOUTH).texture("#stem").end()
                .end();

        chisaModel.element()
                .from(7.5f, 0, 0).to(8.5f, 12, 16)
                .face(Direction.WEST).texture("#stem").end()
                .face(Direction.EAST).texture("#stem").end()
                .end();


        // Flower disc: flat-ish part on top
        chisaModel.element()
                .from(5, 12, 6).to(11, 14, 10)
                .face(Direction.UP).texture("#flower").end()
                .face(Direction.DOWN).texture("#flower").end()
                .face(Direction.NORTH).texture("#flower").end()
                .face(Direction.SOUTH).texture("#flower").end()
                .face(Direction.WEST).texture("#flower").end()
                .face(Direction.EAST).texture("#flower").end()
                .end();

        simpleBlock(ModBlocks.CHISA_BLOCK.get(), models().getExistingFile(modLoc("block/chisa_block")));
    }
}