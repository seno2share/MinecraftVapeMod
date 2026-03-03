package net.share.tutorialmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.share.tutorialmod.TutorialMod;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> VAPE_ITEMS_TAB = CREATIVE_MODE_TABS.register("vape_items.tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COOLMINT_FLUM.get()))
                    .title(Component.translatable("creativetab.tutorialmod.vape_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.COOLMINT_FLUM.get());
                        output.accept(ModItems.CLEAR_FLUM.get());
                        output.accept(ModItems.BLUERAZZICE_FLUM.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
