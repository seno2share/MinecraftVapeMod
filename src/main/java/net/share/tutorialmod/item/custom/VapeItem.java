package net.share.tutorialmod.item.custom;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import java.util.function.Consumer;
import net.minecraft.client.model.HumanoidModel;
import com.mojang.blaze3d.vertex.PoseStack;

public class VapeItem extends Item {
    public VapeItem(Properties properties) {
        super(properties);
    }


    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.CUSTOM;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private static final HumanoidModel.ArmPose SWING_POSE = HumanoidModel.ArmPose.create("SWING", false, (model, entity, arm) -> {
                if (arm == HumanoidArm.RIGHT)
                {
                    model.rightArm.xRot = -1.5f;
                    model.rightArm.yRot = -0.4f;
                    model.rightArm.zRot = 0.0f;
                } else
                {
                    model.leftArm.xRot = -1.5f;
                    model.leftArm.yRot = 0.4f;
                    model.leftArm.zRot = 0.0f;
                }
            });

            @Override
            public HumanoidModel.ArmPose getArmPose(LivingEntity entityLiving, InteractionHand hand, ItemStack itemStack)
            {
                if (!itemStack.isEmpty())
                {
                    if (entityLiving.getUsedItemHand() == hand && entityLiving.getUseItemRemainingTicks() > 0)
                    {
                        return SWING_POSE;
                    }
                }
                return HumanoidModel.ArmPose.EMPTY;
            }

            @Override
            public boolean applyForgeHandTransform(PoseStack poseStack, LocalPlayer player, HumanoidArm arm, ItemStack itemInHand, float partialTick, float equipProcess, float swingProcess) {
                applyItemArmTransform(poseStack, arm);
                if (player.getUseItem() != itemInHand) {
                    return true;
                }
                if (player.isUsingItem()) {
                    poseStack.translate(0.0, -0.05, 0.0);
                }
                return true;
            }

            private void applyItemArmTransform(PoseStack poseStack, HumanoidArm arm) {
                int i = arm == HumanoidArm.RIGHT ? 1 : -1;
                poseStack.translate(i * 0.56F, -0.52F, -0.72F);
            }
        });
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            Player player = pContext.getPlayer();
            boolean hitVape = false;


        }

        return InteractionResult.SUCCESS;
    }
}
