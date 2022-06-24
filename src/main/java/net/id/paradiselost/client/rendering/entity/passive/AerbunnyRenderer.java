package net.id.paradiselost.client.rendering.entity.passive;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.id.paradiselost.ParadiseLost;
import net.id.paradiselost.client.model.ParadiseLostModelLayers;
import net.id.paradiselost.client.model.entity.AerbunnyModel;
import net.id.paradiselost.entities.passive.AerbunnyEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class AerbunnyRenderer extends MobEntityRenderer<AerbunnyEntity, AerbunnyModel> {

    private static final Identifier TEXTURE = ParadiseLost.locate("textures/entity/aerbunny.png");

    public AerbunnyRenderer(EntityRendererFactory.Context context) {
        super(context, new AerbunnyModel(context.getPart(ParadiseLostModelLayers.AERBUNNY)), 0.3F);
    }

    @Override
    public AerbunnyModel getModel() {
        return super.getModel();
    }

    @Override
    protected void setupTransforms(AerbunnyEntity entity, MatrixStack matrices, float animationProgress, float bodyYaw, float tickDelta) {
        super.setupTransforms(entity, matrices, animationProgress, bodyYaw, tickDelta);
        if (entity.isBaby()) {
            matrices.scale(0.6F, 0.6F, 0.6F);
        }
    }

    @Override
    public Identifier getTexture(AerbunnyEntity entity) {
        return TEXTURE;
    }
}
