package net.blay09.mods.farmingforblockheads.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import net.blay09.mods.farmingforblockheads.block.entity.FeedingTroughBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemStack;

public class FeedingTroughRenderer implements BlockEntityRenderer<FeedingTroughBlockEntity> {

    private final float[] CONTENT_POSITIONS = new float[]{
            0.15f, 0.01f, 0,
            -0.2f, 0, 0,
            0, -0.01f, -0.2f,
            0, -0.02f, 0.15f,
    };

    public FeedingTroughRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(FeedingTroughBlockEntity tileEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffers, int combinedLight, int combinedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        float x = 0;
        float y = 0;
        float z = 0;
        ItemStack content = tileEntity.getContentStack();
        if (!content.isEmpty()) {
            for (int i = 0; i < Math.max(1, Math.min(CONTENT_POSITIONS.length / 3, content.getCount() / 12)); i++) {
                poseStack.pushPose();
                poseStack.translate(x + 0.5f + CONTENT_POSITIONS[i * 3], y + 0.5f + CONTENT_POSITIONS[i * 3 + 1], z + 0.4f + CONTENT_POSITIONS[i * 3 + 2]);
                poseStack.mulPose(new Quaternion(90f, 0, 0, true));
                itemRenderer.renderStatic(content, ItemTransforms.TransformType.GROUND, combinedLight, OverlayTexture.NO_OVERLAY, poseStack, buffers, 0);
                poseStack.popPose();
            }
        }
    }
}
