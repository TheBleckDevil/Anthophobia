package net.blackdevil.anthophobia.item;

import net.blackdevil.anthophobia.Anthophobia;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Anthophobia.MODID);




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
