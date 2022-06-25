package net.id.paradiselost.client.rendering.entity.misc;

import com.google.common.collect.ImmutableList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.id.paradiselost.ParadiseLost;
import net.id.paradiselost.client.model.entity.RookModel;
import net.id.paradiselost.entities.misc.RookEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;

import java.util.List;

@Environment(EnvType.CLIENT)
public class RookEyeFeatureRenderer extends EyesFeatureRenderer<RookEntity, RookModel> {

    public static final List<RenderLayer> EYES;
    private final FeatureRendererContext<RookEntity, RookModel> context;

    public RookEyeFeatureRenderer(FeatureRendererContext<RookEntity, RookModel> featureRendererContext) {
        super(featureRendererContext);
        context = featureRendererContext;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, RookEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        var model = getContextModel();
        if(model.blinkTicks <= 0 && model.lookAlpha > 0.185F) {
            VertexConsumer vertexConsumer = vertexConsumers.getBuffer(getEyesTexture(entity));
            getContextModel().render(matrices, vertexConsumer, 15728640, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1);
        }
    }

    @Override
    public RenderLayer getEyesTexture() {
        return EYES.get(0);
    }

    public RenderLayer getEyesTexture(RookEntity entity) {
        return EYES.get(entity.getAscencion());
    }

    static {
        EYES = ImmutableList.of(
                RenderLayer.getEyes(ParadiseLost.locate("textures/entity/corvid/rook_eye1.png")),
                RenderLayer.getEyes(ParadiseLost.locate("textures/entity/corvid/rook_eye2.png")),
                RenderLayer.getEyes(ParadiseLost.locate("textures/entity/corvid/rook_eye3.png")),
                RenderLayer.getEyes(ParadiseLost.locate("textures/entity/corvid/rook_eye4.png"))
        );
    }
}
