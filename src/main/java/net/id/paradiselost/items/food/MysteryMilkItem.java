package net.id.paradiselost.items.food;

import net.id.paradiselost.items.ParadiseLostItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class MysteryMilkItem extends Item {
    public MysteryMilkItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        return stack.isEmpty() ? new ItemStack(ParadiseLostItems.VIAL) : stack;
    }
}
