package net.id.paradiselost.mixin.item;

import net.id.paradiselost.util.ParadiseLostMapColorUtil;
import net.id.paradiselost.world.dimension.ParadiseLostDimension;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.FilledMapItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(FilledMapItem.class)
public abstract class FilledMapMixin {
    /**
     * Changes the color of the paradise_lost void to a pleasant blue.
     * @author Jack Papel
     */
    @Redirect(
            method = "updateColors",
            slice = @Slice(
                from = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/map/MapState;removeBanner(Lnet/minecraft/world/BlockView;II)V"
                )
            ),
            at = @At(
                value = "INVOKE",
                target = "Lnet/minecraft/block/BlockState;getMapColor(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/MapColor;"
            )
    )
    private MapColor updateColors(BlockState instance, BlockView world, BlockPos pos) {
        if (
                ((World) world).getRegistryKey().equals(ParadiseLostDimension.PARADISE_LOST_WORLD_KEY)
                && pos.equals(Vec3i.ZERO)
                && !world.getBlockState(pos).isOf(Blocks.BEDROCK)
        ) {
            return ParadiseLostMapColorUtil.PARADISE_LOST_BACKGROUND;
        } else {
            return instance.getMapColor(world, pos);
        }
    }
}
