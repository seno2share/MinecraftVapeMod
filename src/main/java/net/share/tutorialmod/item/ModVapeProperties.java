package net.share.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModVapeProperties {
    public static final FoodProperties VAPE = new FoodProperties.Builder().nutrition(3).saturationModifier(5)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1), 1.0f)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 100), 1.0f)
            .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 100), 0.5f).build();
}
