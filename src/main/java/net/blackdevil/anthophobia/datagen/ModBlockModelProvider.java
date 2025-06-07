package net.blackdevil.anthophobia.datagen;

import net.blackdevil.anthophobia.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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

        withExistingParent("lycoris_radiata", "block/cross")
                .texture("cross", modLoc("block/lycoris_radiata"));

        }
    }


