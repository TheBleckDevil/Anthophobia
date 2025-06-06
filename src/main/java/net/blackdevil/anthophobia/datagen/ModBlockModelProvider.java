package net.blackdevil.anthophobia.datagen;

import net.blackdevil.anthophobia.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockModelProvider extends BlockModelProvider {
    public ModBlockModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("foxglove_block_bottom", "block/cross")
                .texture("cross", modLoc("block/foxglove_block_bottom"));

        withExistingParent("foxglove_block_top", "block/cross")
                .texture("cross", modLoc("block/foxglove_block_top"));

        // Create chisa_block model starting from the base cube model
        BlockModelBuilder chisaModel = withExistingParent("chisa_block", "block/block")
                .texture("stem", modLoc("block/chisa_stem"))
                .texture("flower", modLoc("block/chisa_flower"));

// Stem: 9 pixels tall, cross shape, 1 pixel wide planes centered in block (7.5 to 8.5)
        chisaModel.element()
                .from(8f, 0f, 0f).to(8.5f, 9f, 16f)
                .face(Direction.WEST).texture("#stem").end()
                .face(Direction.EAST).texture("#stem").end()
                .end();

// Plane 2: thin along Z, full X, faces NORTH and SOUTH
        chisaModel.element()
                .from(0f, 0f, 8).to(16f, 9f, 8.5f)
                .face(Direction.NORTH).texture("#stem").end()
                .face(Direction.SOUTH).texture("#stem").end()
                .end();


// Flower on top, slightly overlapping the stem (start Y just below 9 to overlap)
        chisaModel.element()
                .from(4f, 8f, 4f).to(12f, 11f, 12f)
                .face(Direction.UP).texture("#flower").end()
                .end();
    }
}

