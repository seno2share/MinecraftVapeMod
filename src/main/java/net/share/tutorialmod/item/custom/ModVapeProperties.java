package net.share.tutorialmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModVapeProperties {
    public static final FoodProperties VAPE = new FoodProperties.Builder().nutrition(1).saturationModifier(0.2f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1), 0.5f)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 100), 0.2f)
            .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 100), 0.5f).build();
}
