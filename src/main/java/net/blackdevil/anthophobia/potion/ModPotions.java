package net.blackdevil.anthophobia.potion;

import net.blackdevil.anthophobia.Anthophobia;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, Anthophobia.MODID);

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
