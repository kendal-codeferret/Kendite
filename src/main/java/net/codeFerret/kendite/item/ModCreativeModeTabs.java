package net.codeFerret.kendite.item;

import net.codeFerret.kendite.Kendite;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Kendite.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
  public static CreativeModeTab KENDITE_TAB;

  @SubscribeEvent
  public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event)
  {
	KENDITE_TAB =event.registerCreativeModeTab(new ResourceLocation(Kendite.MOD_ID, "kendite_tab"),
			builder -> builder.icon(() -> new ItemStack(ModItems.KENDITE_INGOT.get()))
					.title(Component.translatable("creativemodetab.kendite_tab")));
  }
}
