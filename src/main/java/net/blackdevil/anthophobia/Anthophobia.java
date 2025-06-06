package net.blackdevil.anthophobia;

import com.mojang.logging.LogUtils;
import net.blackdevil.anthophobia.block.ModBlocks;
import net.blackdevil.anthophobia.effect.ModEffects;
import net.blackdevil.anthophobia.enchantment.ModEnchantmentEffects;
import net.blackdevil.anthophobia.item.ModCreativeModeTabs;
import net.blackdevil.anthophobia.potion.ModPotions;
import net.blackdevil.anthophobia.sound.ModSounds;
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
    private static final Logger LOGGER = LogUtils.getLogger();


    public Anthophobia(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

       // ModItems.refister(modEventBus);
        ModBlocks.register(modEventBus);

        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);

        ModPotions.register(modEventBus);
        ModEnchantmentEffects.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        // ModContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event){

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event){
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event){

    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents{
        @SubscribeEvent
        public static void onClientSetup(FMLCommonSetupEvent event) {
          //  ModItemProperties.addCustomItemProperties();
        }
    }
}
