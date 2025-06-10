package net.blackdevil.anthophobia.item;

import net.blackdevil.anthophobia.Anthophobia;
import net.blackdevil.anthophobia.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Anthophobia.MODID);

    public static final DeferredItem<BlockItem> FOXGLOVE = ITEMS.register("foxglove",
            () -> new BlockItem(ModBlocks.FOXGLOVE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> CHISA = ITEMS.register("chisa",
            () -> new BlockItem(ModBlocks.CHISA_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> LYCORIS_RADIATA = ITEMS.register("lycoris_radiata",
            () -> new BlockItem(ModBlocks.LYCORIS_RADIATA_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> BLOOD_ROSE_ITEM = ITEMS.register("blood_rose_item",
            () -> new BlockItem(ModBlocks.BLOOD_ROSE.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> BLOOD_ROSE_BUSH_ITEM = ITEMS.register("blood_rose_bush_item",
            () -> new BlockItem(ModBlocks.BLOOD_ROSE_BUSH.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> WITHERED_GRASS = ITEMS.register("withered_grass",
            () -> new BlockItem(ModBlocks.WITHERED_GRASS.get(), new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
