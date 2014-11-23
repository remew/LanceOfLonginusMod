package net.remew.LanceOfLonginusMod.client;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class ModelLanceOfLonginus extends ModelBase
{
	ModelRenderer StickUnder;
	ModelRenderer StickBottom;
	ModelRenderer LeftLance;
	ModelRenderer RightLance;
	ModelRenderer RightLanceBottom;
	ModelRenderer LeftLanceBottom;
	ModelRenderer TheBox0;
	ModelRenderer TheBox1;
	ModelRenderer TheBox2;
	ModelRenderer TheBox3;
	
	public ModelLanceOfLonginus()
	{
		textureWidth = 128;
		textureHeight = 128;
		
		StickUnder = new ModelRenderer(this, 0, 0);
		StickUnder.addBox(-1F, 8F, -1F, 2, 16, 2);
		StickUnder.setRotationPoint(0F, 0F, 0F);
		StickUnder.setTextureSize(128, 128);
		StickUnder.mirror = true;
		setRotation(StickUnder, 0F, 0F, 0F);
		StickBottom = new ModelRenderer(this, 0, 18);
		StickBottom.addBox(-1.5F, -8F, -1.5F, 3, 16, 3);
		StickBottom.setRotationPoint(0F, 0F, 0F);
		StickBottom.setTextureSize(128, 128);
		StickBottom.mirror = true;
		setRotation(StickBottom, 0F, 0F, 0F);
		LeftLance = new ModelRenderer(this, 0, 41);
		LeftLance.addBox(-3.5F, -24F, -0.5F, 1, 16, 1);
		LeftLance.setRotationPoint(0F, 0F, 0F);
		LeftLance.setTextureSize(128, 128);
		LeftLance.mirror = true;
		setRotation(LeftLance, 0F, 0F, 0.0523599F);
		RightLance = new ModelRenderer(this, 4, 41);
		RightLance.addBox(2.5F, -24F, -0.5F, 1, 16, 1);
		RightLance.setRotationPoint(0F, 0F, 0F);
		RightLance.setTextureSize(128, 128);
		RightLance.mirror = true;
		setRotation(RightLance, 0F, 0F, -0.0523599F);
		RightLanceBottom = new ModelRenderer(this, 8, 37);
		RightLanceBottom.addBox(1F, -9F, -1F, 2, 2, 2);
		RightLanceBottom.setRotationPoint(0F, 0F, 0F);
		RightLanceBottom.setTextureSize(128, 128);
		RightLanceBottom.mirror = true;
		setRotation(RightLanceBottom, 0F, 0F, -0.0523599F);
		LeftLanceBottom = new ModelRenderer(this, 0, 37);
		LeftLanceBottom.addBox(-3F, -9F, -1F, 2, 2, 2);
		LeftLanceBottom.setRotationPoint(0F, 0F, 0F);
		LeftLanceBottom.setTextureSize(128, 128);
		LeftLanceBottom.mirror = true;
		setRotation(LeftLanceBottom, 0F, 0F, 0.0523599F);
		TheBox0 = new ModelRenderer(this, 8, 0);
		TheBox0.addBox(-1F, -1F, -1F, 2, 2, 2);
		TheBox0.setRotationPoint(6F, 0F, 0F);
		TheBox0.setTextureSize(128, 128);
		TheBox0.mirror = true;
		setRotation(TheBox0, 0F, 0F, 0F);
		TheBox1 = new ModelRenderer(this, 8, 0);
		TheBox1.addBox(-1F, -1F, -1F, 2, 2, 2);
		TheBox1.setRotationPoint(0F, 0F, 6F);
		TheBox1.setTextureSize(128, 128);
		TheBox1.mirror = true;
		setRotation(TheBox1, 0F, 0F, 0F);
		TheBox2 = new ModelRenderer(this, 8, 0);
		TheBox2.addBox(-1F, -1F, -1F, 2, 2, 2);
		TheBox2.setRotationPoint(-6F, 0F, 0F);
		TheBox2.setTextureSize(128, 128);
		TheBox2.mirror = true;
		setRotation(TheBox2, 0F, 0F, 0F);
		TheBox3 = new ModelRenderer(this, 8, 0);
		TheBox3.addBox(-1F, -1F, -1F, 2, 2, 2);
		TheBox3.setRotationPoint(0F, 0F, -6F);
		TheBox3.setTextureSize(128, 128);
		TheBox3.mirror = true;
		setRotation(TheBox3, 0F, 0F, 0F);
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		StickUnder.render(f5);
		StickBottom.render(f5);
		LeftLance.render(f5);
		RightLance.render(f5);
		RightLanceBottom.render(f5);
		LeftLanceBottom.render(f5);
		TheBox0.render(f5);
		TheBox1.render(f5);
		TheBox2.render(f5);
		TheBox3.render(f5);
	}
	
	public void simpleRender(float scale)
	{
		Minecraft mc = Minecraft.getMinecraft();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glPushMatrix();
		//GL11.glBindTexture(GL11.GL_TEXTURE_2D, mc.renderEngine.getTexture(ModelLanceOfLonginus.LANCE_RESOURCE_LOCATION).getGlTextureId());
		GL11.glScalef(1f, 1f, 1f);
		GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f);
		StickUnder.render(scale);
		StickBottom.render(scale);
		LeftLance.render(scale);
		RightLance.render(scale);
		RightLanceBottom.render(scale);
		LeftLanceBottom.render(scale);
		TheBox0.render(scale);
		TheBox1.render(scale);
		TheBox2.render(scale);
		TheBox3.render(scale);
		GL11.glPopMatrix();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		int r = 8;
		int rate = 20;
		int tick = entity.ticksExisted;
		double radBase = Math.PI / 180.0;
		float rad0 = (float)(radBase * (tick * rate + 0));
		float rad1 = (float)(radBase * (tick * rate + 90));
		float rad2 = (float)(radBase * (tick * rate + 180));
		float rad3 = (float)(radBase * (tick * rate + 270));
		TheBox0.rotationPointX = MathHelper.cos(rad0) * r;
		TheBox0.rotationPointZ = MathHelper.sin(rad0) * r;
		TheBox1.rotationPointX = MathHelper.cos(rad1) * r;
		TheBox1.rotationPointZ = MathHelper.sin(rad1) * r;
		TheBox2.rotationPointX = MathHelper.cos(rad2) * r;
		TheBox2.rotationPointZ = MathHelper.sin(rad2) * r;
		TheBox3.rotationPointX = MathHelper.cos(rad3) * r;
		TheBox3.rotationPointZ = MathHelper.sin(rad3) * r;
	}

}
