package net.codeFerret.kendite.item;

import net.codeFerret.kendite.Kendite;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Kendite.MOD_ID);

    public static final RegistryObject<Item> RAW_KENDITE = ITEMS.register("raw_kendite",
            () -> new Item(new Item.Properties()));

    public  static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
