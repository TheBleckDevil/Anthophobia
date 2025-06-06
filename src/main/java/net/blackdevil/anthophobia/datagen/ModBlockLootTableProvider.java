package net.blackdevil.anthophobia.datagen;

import net.blackdevil.anthophobia.block.ModBlocks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Optional;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        addFoxgloveLootTable(ModBlocks.FOXGLOVE_BLOCK.get());
        dropSelf(ModBlocks.CHISA_BLOCK.get());
    }

    private void addFoxgloveLootTable(Block block) {
        LootPool.Builder pool = LootPool.lootPool()
                .setRolls(UniformGenerator.between(1.0F, 1.0F))
                .add(LootItem.lootTableItem(block.asItem())
                        .when(
                                LootItemBlockStatePropertyCondition
                                        .hasBlockStateProperties(block)
                                        .setProperties(
                                                StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER)
                                        )
                        )
                );

        LootTable.Builder table = LootTable.lootTable().withPool(pool);

        add(block, table);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Set.of(
                ModBlocks.FOXGLOVE_BLOCK.get(),
                ModBlocks.CHISA_BLOCK.get()
        );
    }
}

