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
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.remew.LanceOfLonginusMod.entity.EntityLanceOfLonginus;

public class RenderLanceOfLonginus extends Render
{
	private ModelBase model;
	public static final ResourceLocation LANCE_RESOURCE_LOCATION = new ResourceLocation("llmod:textures/lance_of_longinus_texture.png");
	
	public RenderLanceOfLonginus(ModelBase model)
	{
		this.model = model;
	}
	
	public void doRenderLanceOfLonginus(EntityLanceOfLonginus entityLance, double x, double y, double z, float f0, float f1)
	{
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);
		//this.model.onGround = this.renderSwingProgress(entityLance, f1);

		/*if (this.renderPassModel != null)
		{
			this.renderPassModel.onGround = this.model.onGround;
		}*/

		//this.model.isRiding = entityLance.isRiding();

		/*if (this.renderPassModel != null)
		{
			this.renderPassModel.isRiding = this.model.isRiding;
		}*/

		//this.model.isChild = entityLance.isChild();

		/*if (this.renderPassModel != null)
		{
			this.renderPassModel.isChild = this.model.isChild;
		}*/

		try
		{
			//float f2 = this.interpolateRotation(entityLance.prevRenderYawOffset, entityLance.renderYawOffset, f1);
			//float f3 = this.interpolateRotation(entityLance.prevRotationYawHead, entityLance.rotationYawHead, f1);
			float f2;//Yaw
			float f3;//Head
			float f4;
			f2 = this.interpolateRotation(entityLance.prevRotationYaw, entityLance.rotationYaw, f1);
			f3 = this.interpolateRotation(entityLance.prevRotationYaw, entityLance.rotationYaw, f1);
			f4 = 0.0f;
			/*if (entityLance.isRiding() && entityLance.ridingEntity instanceof EntityLivingBase)
			{
				EntityLivingBase entitylivingbase1 = (EntityLivingBase)entityLance.ridingEntity;
				f2 = this.interpolateRotation(entitylivingbase1.prevRenderYawOffset, entitylivingbase1.renderYawOffset, f1);
				f4 = MathHelper.wrapAngleTo180_float(f3 - f2);
				
				if (f4 < -85.0F)
				{
					f4 = -85.0F;
				}
				
				if (f4 >= 85.0F)
				{
					f4 = 85.0F;
				}
				
				f2 = f3 - f4;
				
				if (f4 * f4 > 2500.0F)
				{
					f2 += f4 * 0.2F;
				}
			}*/
			
			float f5 = entityLance.prevRotationPitch + (entityLance.rotationPitch - entityLance.prevRotationPitch) * f1;
			this.renderLivingAt(entityLance, x, y, z);
			//f4 = this.handleRotationFloat(entityLance, f1);
			//this.rotateCorpse(entityLance, f4, f2, f1);
			float f6 = 0.0625F;
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glScalef(-1.0F, -1.0F, 1.0F);
			//this.preRenderCallback(entityLance, f1);
			GL11.glTranslatef(0.0F, -24.0F * f6 - 0.0078125F, 0.0F);
			float f7;
			float f8;
			f7 = 0.0f;
			f8 = 0.0f;
			//float f7 = entityLance.prevLimbSwingAmount + (entityLance.limbSwingAmount - entityLance.prevLimbSwingAmount) * f1;
			//float f8 = entityLance.limbSwing - entityLance.limbSwingAmount * (1.0F - f1);
			
			/*if (entityLance.isChild())
			{
				f8 *= 3.0F;
			}*/
			
			if (f7 > 1.0F)
			{
				f7 = 1.0F;
			}
			
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			//this.model.setLivingAnimations(entityLance, f8, f7, f1);
			this.renderModel(entityLance, f8, f7, f4, f3 - f2, f5, f6);
			float f9;
			int i;
			float f10;
			float f11;
			
			/*for (int j = 0; j < 4; ++j)
			{
				i = this.shouldRenderPass(entityLance, j, f1);
				
				if (i > 0)
				{
					//this.renderPassModel.setLivingAnimations(entityLance, f8, f7, f1);
					//this.renderPassModel.render(entityLance, f8, f7, f4, f3 - f2, f5, f6);
					
					if ((i & 240) == 16)
					{
						this.func_82408_c(entityLance, j, f1);
						//this.renderPassModel.render(entityLance, f8, f7, f4, f3 - f2, f5, f6);
					}
					
					if ((i & 15) == 15)
					{
						f9 = (float)entityLance.ticksExisted + f1;
						this.bindTexture(this.resourceLocation);
						GL11.glEnable(GL11.GL_BLEND);
						f10 = 0.5F;
						GL11.glColor4f(f10, f10, f10, 1.0F);
						GL11.glDepthFunc(GL11.GL_EQUAL);
						GL11.glDepthMask(false);
						
						for (int k = 0; k < 2; ++k)
						{
							GL11.glDisable(GL11.GL_LIGHTING);
							f11 = 0.76F;
							GL11.glColor4f(0.5F * f11, 0.25F * f11, 0.8F * f11, 1.0F);
							GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
							GL11.glMatrixMode(GL11.GL_TEXTURE);
							GL11.glLoadIdentity();
							float f12 = f9 * (0.001F + (float)k * 0.003F) * 20.0F;
							float f13 = 0.33333334F;
							GL11.glScalef(f13, f13, f13);
							GL11.glRotatef(30.0F - (float)k * 60.0F, 0.0F, 0.0F, 1.0F);
							GL11.glTranslatef(0.0F, f12, 0.0F);
							GL11.glMatrixMode(GL11.GL_MODELVIEW);
							//this.renderPassModel.render(entityLance, f8, f7, f4, f3 - f2, f5, f6);
						}
						
						GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
						GL11.glMatrixMode(GL11.GL_TEXTURE);
						GL11.glDepthMask(true);
						GL11.glLoadIdentity();
						GL11.glMatrixMode(GL11.GL_MODELVIEW);
						GL11.glEnable(GL11.GL_LIGHTING);
						GL11.glDisable(GL11.GL_BLEND);
						GL11.glDepthFunc(GL11.GL_LEQUAL);
					}
					
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
				}
			}*/
			
			GL11.glDepthMask(true);
			//this.renderEquippedItems(entityLance, f1);
			float f14 = entityLance.getBrightness(f1);
			//i = this.getColorMultiplier(entityLance, f14, f1);
			OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
			
			/*if ((i >> 24 & 255) > 0 || entityLance.hurtTime > 0 || entityLance.deathTime > 0)
			{
				GL11.glDisable(GL11.GL_TEXTURE_2D);
				GL11.glDisable(GL11.GL_ALPHA_TEST);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				GL11.glDepthFunc(GL11.GL_EQUAL);

				if (entityLance.hurtTime > 0 || entityLance.deathTime > 0)
				{
					GL11.glColor4f(f14, 0.0F, 0.0F, 0.4F);
					this.model.render(entityLance, f8, f7, f4, f3 - f2, f5, f6);

					for (int l = 0; l < 4; ++l)
					{
						if (this.inheritRenderPass(entityLance, l, f1) >= 0)
						{
							GL11.glColor4f(f14, 0.0F, 0.0F, 0.4F);
							//this.renderPassModel.render(entityLance, f8, f7, f4, f3 - f2, f5, f6);
						}
					}
				}

				if ((i >> 24 & 255) > 0)
				{
					f9 = (float)(i >> 16 & 255) / 255.0F;
					f10 = (float)(i >> 8 & 255) / 255.0F;
					float f15 = (float)(i & 255) / 255.0F;
					f11 = (float)(i >> 24 & 255) / 255.0F;
					GL11.glColor4f(f9, f10, f15, f11);
					this.model.render(entityLance, f8, f7, f4, f3 - f2, f5, f6);

					for (int i1 = 0; i1 < 4; ++i1)
					{
						if (this.inheritRenderPass(entityLance, i1, f1) >= 0)
						{
							GL11.glColor4f(f9, f10, f15, f11);
							this.renderPassModel.render(entityLance, f8, f7, f4, f3 - f2, f5, f6);
						}
					}
				}

				GL11.glDepthFunc(GL11.GL_LEQUAL);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glEnable(GL11.GL_TEXTURE_2D);
			}*/
			
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		
		OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
		//this.passSpecialRender(entityLance, x, y, z);
		//MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Post(entityLance, this));
	}
	
	/**
	 * Renders the model in RenderLiving
	 */
	protected void renderModel(EntityLanceOfLonginus entityLance, float par2, float par3, float par4, float par5, float par6, float par7)
	{
		this.bindEntityTexture(entityLance);
		
		if (!entityLance.isInvisible())
		{
			this.model.render(entityLance, par2, par3, par4, par5, par6, par7);
		}
		else if (!entityLance.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer))
		{
			GL11.glPushMatrix();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.15F);
			GL11.glDepthMask(false);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);
			this.model.render(entityLance, par2, par3, par4, par5, par6, par7);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
			GL11.glPopMatrix();
			GL11.glDepthMask(true);
		}
		else
		{
			this.model.setRotationAngles(par2, par3, par4, par5, par6, par7, entityLance);
		}
	}
	
	/**
	 * Returns a rotation angle that is inbetween two other rotation angles. par1 and par2 are the angles between which
	 * to interpolate, par3 is probably a float between 0.0 and 1.0 that tells us where "between" the two angles we are.
	 * Example: par1 = 30, par2 = 50, par3 = 0.5, then return = 40
	 */
	private float interpolateRotation(float par1, float par2, float par3)
	{
		float f3;
		
		for (f3 = par2 - par1; f3 < -180.0F; f3 += 360.0F)
		{
			;
		}
		
		while (f3 >= 180.0F)
		{
			f3 -= 360.0F;
		}
		
		return par1 + par3 * f3;
	}
	
	/**
	 * Sets a simple glTranslate on a LivingEntity.
	 */
	protected void renderLivingAt(Entity par1Entity, double par2, double par4, double par6)
	{
		GL11.glTranslatef((float)par2, (float)par4, (float)par6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.LANCE_RESOURCE_LOCATION;
	}
	
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1)
	{
		this.doRenderLanceOfLonginus((EntityLanceOfLonginus)entity, d0, d1, d2, f, f1);
	}
}
