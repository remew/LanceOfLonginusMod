package net.remew.LanceOfLonginusMod.client;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.remew.LanceOfLonginusMod.LanceOfLonginusMod;
import net.remew.LanceOfLonginusMod.entity.EntityLanceOfLonginus;

public class RenderLanceOfLonginus extends Render
{
	private ModelBase model;
	
	public RenderLanceOfLonginus(ModelBase model)
	{
		this.model = model;
	}
	
	/**
	 * Renders the Ender Crystal.
	 */
	public void doRenderLanceOfLonginus(EntityLanceOfLonginus entityLance, double par2, double par4, double par6, float par8, float par9)
	{
		//float f2 = (float)entityLance.innerRotation + par9;
		GL11.glPushMatrix();
		GL11.glTranslatef((float)par2, (float)par4, (float)par6);
		this.bindTexture(LanceOfLonginusMod.LANCE_RESOURCE_LOCATION);
		float pitch = entityLance.rotationPitch;
		float yaw = entityLance.rotationYaw;
		GL11.glRotatef(pitch, 0.0f, 1.0f, 0.0f);
		GL11.glRotatef(yaw, 0.0f, 0.0f, 1.0f);
		//float f3 = MathHelper.sin(f2 * 0.2F) / 2.0F + 0.5F;
		//f3 += f3 * f3;
		//this.model.render(entityLance, 0.0F, f2 * 3.0F, f3 * 0.2F, 0.0F, 0.0F, 0.0625F);
		this.model.render(entityLance, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
		GL11.glPopMatrix();
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return LanceOfLonginusMod.LANCE_RESOURCE_LOCATION;
	}
	
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1)
	{
		this.doRenderLanceOfLonginus((EntityLanceOfLonginus)entity, d0, d1, d2, f, f1);
	}
}
