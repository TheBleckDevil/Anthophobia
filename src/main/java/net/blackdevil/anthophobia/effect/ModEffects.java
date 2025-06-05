package net.blackdevil.anthophobia.effect;

import net.blackdevil.anthophobia.Anthophobia;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, Anthophobia.MODID);



    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
