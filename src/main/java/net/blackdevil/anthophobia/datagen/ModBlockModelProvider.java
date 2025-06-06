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

        BlockModelBuilder chisaModel = withExistingParent("chisa_block", "block/block");

        // Add cross stem by "baking in" the cross parent with the stem texture
        chisaModel.element()
                .from(7, 0, 0).to(9, 16, 16)  // Plane along X=8 (2 pixels thick)
                .face(Direction.WEST).texture("#stem").end()
                .face(Direction.EAST).texture("#stem").end()
                .end();

        chisaModel.element()
                .from(0, 0, 7).to(16, 16, 9)  // Plane along Z=8 (2 pixels thick)
                .face(Direction.NORTH).texture("#stem").end()
                .face(Direction.SOUTH).texture("#stem").end()
                .end();

        // Add the flower element on top manually
        chisaModel.element() // Flower (top)
                .from(4f, 16.1f, 4f).to(12f, 18f, 12f)
                .face(Direction.UP).texture("#flower").end()
                .face(Direction.DOWN).texture("#flower").end()
                .face(Direction.NORTH).texture("#flower").end()
                .face(Direction.SOUTH).texture("#flower").end()
                .face(Direction.EAST).texture("#flower").end()
                .face(Direction.WEST).texture("#flower").end()
                .end();

        chisaModel.texture("flower", modLoc("block/chisa_flower"));
        chisaModel.texture("stem", modLoc("block/chisa_stem"));
    }

}

