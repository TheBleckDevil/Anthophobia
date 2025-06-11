package net.blackdevil.anthophobia;

import com.mojang.logging.LogUtils;
import net.blackdevil.anthophobia.block.ModBlocks;
import net.blackdevil.anthophobia.effect.ModEffects;
import net.blackdevil.anthophobia.enchantment.ModEnchantmentEffects;
import net.blackdevil.anthophobia.item.ModCreativeModeTabs;
import net.blackdevil.anthophobia.item.ModItems;
import net.blackdevil.anthophobia.potion.ModPotions;
import net.blackdevil.anthophobia.sound.ModSounds;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(Anthophobia.MODID)
public class Anthophobia {
    public static final String MODID = "anthophobia";

    // Helper method to create ResourceLocations correctly

    private static final Logger LOGGER = LogUtils.getLogger();

    public Anthophobia(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);  // pass modEventBus here
        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);
        ModEnchantmentEffects.register(modEventBus);


        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // 👇 Call your custom bootstrap class to link features
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            // Add your items to the INGREDIENTS tab here
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            // Add your blocks to the BUILDING_BLOCKS tab here
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Server starting logic here
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLCommonSetupEvent event) {
            // Client setup code here (e.g., item properties)
        }

    }
}
