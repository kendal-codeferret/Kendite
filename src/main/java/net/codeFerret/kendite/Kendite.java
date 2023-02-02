package net.codeFerret.kendite;

import com.mojang.logging.LogUtils;
import net.codeFerret.kendite.block.ModBlocks;
import net.codeFerret.kendite.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Kendite.MOD_ID)
public class Kendite {
    public static final String MOD_ID = "kendite";
    private static final Logger LOGGER = LogUtils.getLogger();
    public Kendite() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::buildContents);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void buildContents(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RAW_KENDITE);
            event.accept(ModItems.KENDITE_INGOT);
        }
        else if (event.getTab() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.KENDITE_SWORD);
        }
        else if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.RAW_KENDITE_BLOCK);
            event.accept(ModBlocks.KENDITE_ORE);
            event.accept(ModBlocks.DEEPSLATE_KENDITE_ORE);
        }
        else if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.KENDITE_BLOCK);
        }
        else if (event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.KENDITE_PICKAXE);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
