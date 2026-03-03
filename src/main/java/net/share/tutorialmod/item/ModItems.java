package net.share.tutorialmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.share.tutorialmod.TutorialMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> COOLMINT_FLUM = ITEMS.register("coolmint_flum",
            () -> new Item(new Item.Properties().food(ModVapeProperties.VAPE)));

    public static final RegistryObject<Item> CLEAR_FLUM = ITEMS.register("clear_flum",
            () -> new Item(new Item.Properties().food(ModVapeProperties.VAPE)));

    public static final RegistryObject<Item> BLUERAZZICE_FLUM = ITEMS.register("bluerazzice_flum",
            () -> new Item(new Item.Properties().food(ModVapeProperties.VAPE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
