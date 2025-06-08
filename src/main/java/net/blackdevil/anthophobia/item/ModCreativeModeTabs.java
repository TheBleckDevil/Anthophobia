package net.blackdevil.anthophobia.item;

import net.blackdevil.anthophobia.Anthophobia;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Anthophobia.MODID);


    public static final Supplier<CreativeModeTab> FLOWERS_TAB = CREATIVE_MODE_TAB.register("flowers_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FOXGLOVE.get()))
                    .title(Component.translatable("creativetab.anthophobia.flowers_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.FOXGLOVE);
                        output.accept(ModItems.CHISA);
                        output.accept(ModItems.LYCORIS_RADIATA);
                        output.accept(ModItems.BLOOD_ROSE_ITEM);
                        output.accept(ModItems.BLOOD_ROSE_BUSH_ITEM);





                    }).build());
        public static void register(IEventBus eventBus) {
            CREATIVE_MODE_TAB.register(eventBus);
        }
    }

