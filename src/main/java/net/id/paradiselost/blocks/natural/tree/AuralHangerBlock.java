package net.id.paradiselost.blocks.natural.tree;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.id.paradiselost.blocks.util.DynamicColorBlock;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class AuralHangerBlock extends ParadiseLostHangerBlock implements DynamicColorBlock {

    private final Vec3i[] gradientColors;

    public AuralHangerBlock(Settings settings, Vec3i[] gradientColors) {
        super(settings);
        this.gradientColors = gradientColors;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public BlockColorProvider getBlockColorProvider() {
        return (state, world, pos, tintIndex) -> MathHelper.packRgb(pos.getX(), pos.getY(), pos.getZ()) | ((2*(pos.getY() / 256 % 2) - 1) << 24);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public ItemColorProvider getBlockItemColorProvider() {
        return (state, tintIndex) -> AuralLeavesBlock.getAuralColor(BlockPos.ORIGIN, gradientColors);
    }
}
