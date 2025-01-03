package net.velalii.overworld_reforged.entity.client;// Made with Blockbench 4.11.2

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.velalii.overworld_reforged.entity.animations.ModAnimationDefinitions;
import net.velalii.overworld_reforged.entity.custom.DeerEntity;

public class DeerModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart deer;
	private final ModelPart body;
	private final ModelPart torso;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart right_ear;
	private final ModelPart left_ear;
	private final ModelPart tail;
	private final ModelPart right_front_leg;
	private final ModelPart lower_right_front_leg;
	private final ModelPart right_front_hoof;
	private final ModelPart right_front_joint;
	private final ModelPart left_front_leg;
	private final ModelPart lower_left_front_leg;
	private final ModelPart left_front_hoof;
	private final ModelPart left_front_joint;
	private final ModelPart right_hind_leg;
	private final ModelPart lower_right_hind_leg;
	private final ModelPart right_hind_hoof;
	private final ModelPart right_hind_joint;
	private final ModelPart left_hind_leg;
	private final ModelPart lower_left_hind_leg;
	private final ModelPart left_hind_hoof;
	private final ModelPart left_hind_joint;


	public DeerModel(ModelPart root) {
		this.deer = root.getChild("deer");
		this.body = this.deer.getChild("body");
		this.torso = this.body.getChild("torso");
		this.neck = this.torso.getChild("neck");
		this.head = this.neck.getChild("head");
		this.right_ear = this.head.getChild("right_ear");
		this.left_ear = this.head.getChild("left_ear");
		this.tail = this.torso.getChild("tail");
		this.right_front_leg = this.body.getChild("right_front_leg");
		this.lower_right_front_leg = this.right_front_leg.getChild("lower_right_front_leg");
		this.right_front_hoof = this.lower_right_front_leg.getChild("right_front_hoof");
		this.right_front_joint = this.right_front_leg.getChild("right_front_joint");
		this.left_front_leg = this.body.getChild("left_front_leg");
		this.lower_left_front_leg = this.left_front_leg.getChild("lower_left_front_leg");
		this.left_front_hoof = this.lower_left_front_leg.getChild("left_front_hoof");
		this.left_front_joint = this.left_front_leg.getChild("left_front_joint");
		this.right_hind_leg = this.body.getChild("right_hind_leg");
		this.lower_right_hind_leg = this.right_hind_leg.getChild("lower_right_hind_leg");
		this.right_hind_hoof = this.lower_right_hind_leg.getChild("right_hind_hoof");
		this.right_hind_joint = this.right_hind_leg.getChild("right_hind_joint");
		this.left_hind_leg = this.body.getChild("left_hind_leg");
		this.lower_left_hind_leg = this.left_hind_leg.getChild("lower_left_hind_leg");
		this.left_hind_hoof = this.lower_left_hind_leg.getChild("left_hind_hoof");
		this.left_hind_joint = this.left_hind_leg.getChild("left_hind_joint");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition deer = partdefinition.addOrReplaceChild("deer", CubeListBuilder.create(), PartPose.offset(-1.0F, 24.0F, -2.0F));

		PartDefinition body = deer.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -5.7783F, -0.8316F, 6.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, -4.0F));

		PartDefinition neck = torso.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.5F, -0.7783F, -0.8316F));

		PartDefinition lower_neck_r1 = neck.addOrReplaceChild("lower_neck_r1", CubeListBuilder.create().texOffs(10, 34).addBox(-1.5F, -3.0F, -3.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.1781F, 0.0F, 0.0F));

		PartDefinition upper_neck_r1 = neck.addOrReplaceChild("upper_neck_r1", CubeListBuilder.create().texOffs(18, 27).addBox(-1.5F, -3.0F, -4.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.7717F, -1.148F, -1.3963F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 21).addBox(-2.0F, -4.0F, -5.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(40, 31).addBox(-1.5F, -2.0F, -7.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(7, 47).addBox(-0.75F, -2.25F, -7.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(7, 47).addBox(-0.25F, -2.25F, -7.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -6.4818F, 1.1118F));

		PartDefinition muzzle_bridge_r1 = head.addOrReplaceChild("muzzle_bridge_r1", CubeListBuilder.create().texOffs(27, 36).addBox(0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -2.0001F, -7.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition right_ear = head.addOrReplaceChild("right_ear", CubeListBuilder.create(), PartPose.offset(-1.75F, -4.0F, -2.0F));

		PartDefinition right_ear_r1 = right_ear.addOrReplaceChild("right_ear_r1", CubeListBuilder.create().texOffs(41, 9).addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, -0.3927F, 0.0F));

		PartDefinition left_ear = head.addOrReplaceChild("left_ear", CubeListBuilder.create(), PartPose.offset(1.75F, -4.0F, -2.0F));

		PartDefinition left_ear_r1 = left_ear.addOrReplaceChild("left_ear_r1", CubeListBuilder.create().texOffs(35, 44).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.3927F, 0.0F));

		PartDefinition tail = torso.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(1.0F, -5.75F, 13.0F));

		PartDefinition tail_r1 = tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(18, 21).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0283F, 0.1684F, -1.2217F, 0.0F, 0.0F));

		PartDefinition right_front_leg = body.addOrReplaceChild("right_front_leg", CubeListBuilder.create(), PartPose.offset(-2.0F, -9.7783F, -4.8316F));

		PartDefinition upper_leg_r1 = right_front_leg.addOrReplaceChild("upper_leg_r1", CubeListBuilder.create().texOffs(38, 36).addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition lower_right_front_leg = right_front_leg.addOrReplaceChild("lower_right_front_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 3.9392F, 0.6946F));

		PartDefinition lower_leg_r1 = lower_right_front_leg.addOrReplaceChild("lower_leg_r1", CubeListBuilder.create().texOffs(10, 39).addBox(0.0F, -1.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition right_front_hoof = lower_right_front_leg.addOrReplaceChild("right_front_hoof", CubeListBuilder.create().texOffs(46, 21).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 4.8391F, -1.0718F));

		PartDefinition right_front_joint = right_front_leg.addOrReplaceChild("right_front_joint", CubeListBuilder.create(), PartPose.offset(1.0F, 3.4183F, 3.649F));

		PartDefinition joint_r1 = right_front_joint.addOrReplaceChild("joint_r1", CubeListBuilder.create().texOffs(42, 43).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition left_front_leg = body.addOrReplaceChild("left_front_leg", CubeListBuilder.create(), PartPose.offset(2.0F, -9.7783F, -4.8316F));

		PartDefinition upper_leg_r2 = left_front_leg.addOrReplaceChild("upper_leg_r2", CubeListBuilder.create().texOffs(0, 39).addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition lower_left_front_leg = left_front_leg.addOrReplaceChild("lower_left_front_leg", CubeListBuilder.create(), PartPose.offset(1.0F, 3.9392F, 0.6946F));

		PartDefinition lower_leg_r2 = lower_left_front_leg.addOrReplaceChild("lower_leg_r2", CubeListBuilder.create().texOffs(18, 39).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition left_front_hoof = lower_left_front_leg.addOrReplaceChild("left_front_hoof", CubeListBuilder.create().texOffs(46, 24).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.8391F, -1.0718F));

		PartDefinition left_front_joint = left_front_leg.addOrReplaceChild("left_front_joint", CubeListBuilder.create(), PartPose.offset(1.0F, 3.4183F, 3.649F));

		PartDefinition joint_r2 = left_front_joint.addOrReplaceChild("joint_r2", CubeListBuilder.create().texOffs(0, 46).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition right_hind_leg = body.addOrReplaceChild("right_hind_leg", CubeListBuilder.create(), PartPose.offset(-2.0F, -10.478F, 5.6314F));

		PartDefinition upper_leg_r3 = right_hind_leg.addOrReplaceChild("upper_leg_r3", CubeListBuilder.create().texOffs(0, 30).addBox(0.0F, 0.0F, 0.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition lower_right_hind_leg = right_hind_leg.addOrReplaceChild("lower_right_hind_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 5.1203F, 2.1298F));

		PartDefinition lower_leg_r3 = lower_right_hind_leg.addOrReplaceChild("lower_leg_r3", CubeListBuilder.create().texOffs(26, 39).addBox(0.0F, -1.25F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition right_hind_hoof = lower_right_hind_leg.addOrReplaceChild("right_hind_hoof", CubeListBuilder.create().texOffs(10, 30).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 4.3884F, -1.8178F));

		PartDefinition right_hind_joint = right_hind_leg.addOrReplaceChild("right_hind_joint", CubeListBuilder.create(), PartPose.offset(1.0F, 4.3952F, 5.0678F));

		PartDefinition joint_r3 = right_hind_joint.addOrReplaceChild("joint_r3", CubeListBuilder.create().texOffs(40, 15).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition left_hind_leg = body.addOrReplaceChild("left_hind_leg", CubeListBuilder.create(), PartPose.offset(2.0F, -10.478F, 5.6314F));

		PartDefinition upper_leg_r4 = left_hind_leg.addOrReplaceChild("upper_leg_r4", CubeListBuilder.create().texOffs(36, 21).addBox(0.0F, 0.0F, 0.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition lower_left_hind_leg = left_hind_leg.addOrReplaceChild("lower_left_hind_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 5.1203F, 2.1298F));

		PartDefinition lower_leg_r4 = lower_left_hind_leg.addOrReplaceChild("lower_leg_r4", CubeListBuilder.create().texOffs(40, 0).addBox(0.0F, -1.25F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition left_hind_hoof = lower_left_hind_leg.addOrReplaceChild("left_hind_hoof", CubeListBuilder.create().texOffs(46, 27).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 4.3884F, -1.8178F));

		PartDefinition left_hind_joint = left_hind_leg.addOrReplaceChild("left_hind_joint", CubeListBuilder.create(), PartPose.offset(1.0F, 4.3952F, 5.0678F));

		PartDefinition joint_r4 = left_hind_joint.addOrReplaceChild("joint_r4", CubeListBuilder.create().texOffs(46, 15).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6545F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
		boolean running = ((DeerEntity) entity).isRunning();
		if(running){
			this.animateWalk(ModAnimationDefinitions.run, limbSwing, limbSwingAmount, 2f, 2.5f);
		}else {
			this.animateWalk(ModAnimationDefinitions.walk, limbSwing, limbSwingAmount, 2f, 2.5f);
		}
		this.animate(((DeerEntity) entity).idleAnimationState, ModAnimationDefinitions.idle, ageInTicks, 1f);
		this.animate(((DeerEntity) entity).eatAnimationState, ModAnimationDefinitions.eat, ageInTicks, 1f);
		this.animate(((DeerEntity) entity).bowAnimationState, ModAnimationDefinitions.bow, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		deer.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public ModelPart root() {
		return deer;
	}
}