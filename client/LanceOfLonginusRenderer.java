package net.remew.LanceOfLonginusMod.client;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.remew.LanceOfLonginusMod.LanceOfLonginusMod;
import net.remew.atmod2.core.API.UVXYConverter;

public class LanceOfLonginusRenderer implements IItemRenderer
{
	private ModelLanceOfLonginus model;
	
	public LanceOfLonginusRenderer()
	{
		this.model = new ModelLanceOfLonginus();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch( type )
		{
		case ENTITY:
			return true;
		case EQUIPPED:
			return true;
		case EQUIPPED_FIRST_PERSON:
			return true;
			//return false;
		default:
			return false;
		}
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}
	
	/*
	 * ENTITY：data = Object[]{RenderBlocks, EntityItem}
	 * EQUIPPED：data = Object[]{RenderBlocks, EntityLiving}
	 * INVENTORY：data = Object[]{RenderBlocks}
	 * FIRST_PERSON_MAP：data = Object[]{EntityPlayer, RenderEngine, MapData}
	 */
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch( type )
		{
		case ENTITY:
			this.renderEntity(type, item, data);
			break;
		case EQUIPPED:
			this.renderEquipped(type, item, data);
			break;
		case EQUIPPED_FIRST_PERSON:
			//this.renderEquipped(type, item, data);
			this.renderEquippedFirstPerson(type, item, data);
			break;
		default:
			return;
		}
	}
	
	private void renderEntity(ItemRenderType type, ItemStack item, Object... data)
	{
		
	}
	private void renderEquipped(ItemRenderType type, ItemStack item, Object... data)
	{
		GL11.glPushMatrix();
		float scale = 2.5f;
		scale = 1.75f;
		GL11.glScalef(scale, scale, scale);
		
		//GL11.glRotatef(0.0f, -10.0f, 0.0f, 0.0f);
		//GL11.glRotatef(8.0f, 0.0f, -10.0f, 0.0f);
		GL11.glRotatef(200.0f, 0.0f, 0.0f, -10.0f);
		GL11.glTranslatef(-0.18f/*-0.3048f*/, 0.0f/*0.500f*/,  -0.09f);
		
		Minecraft.getMinecraft().renderEngine.bindTexture(LanceOfLonginusMod.LANCE_RESOURCE_LOCATION);
		this.model.render((Entity)data[1], 0, 0, 0, 0, 0, 0.0625f);
		
		GL11.glPopMatrix();
	}
	private void renderEquippedFirstPerson(ItemRenderType type, ItemStack item, Object... data)
	{
		GL11.glPushMatrix();
		float scale = 2.5f;
		scale = 1.0f;
		GL11.glScalef(scale, scale, scale);
		
		//GL11.glRotatef(0.0f, -10.0f, 0.0f, 0.0f);
		//GL11.glRotatef(8.0f, 0.0f, -10.0f, 0.0f);
		GL11.glRotatef(200.0f, 0.0f, 0.0f, -10.0f);
		GL11.glTranslatef(-0.3048f, -0.75f/*0.500f*/,  -0.09f);
		
		Minecraft.getMinecraft().renderEngine.bindTexture(LanceOfLonginusMod.LANCE_RESOURCE_LOCATION);
		this.model.render((Entity)data[1], 0, 0, 0, 0, 0, 0.0625f);
		
		GL11.glPopMatrix();
	}
	/*
	Tessellator tessellator = Tessellator.instance;
		
		if( this.hasOverrideBlockTexture() )
		{
			icon = this.overrideBlockTexture;
		}
		System.out.println( "width:" + icon.getIconWidth() + " height:" + icon.getIconHeight() );
		double minU = (double)icon.getInterpolatedU(block.getBlockBoundsMinZ() * 16.0D);
		double maxU = (double)icon.getInterpolatedU(block.getBlockBoundsMaxZ() * 16.0D);
		double maxV = (double)icon.getInterpolatedV(16.0D - block.getBlockBoundsMaxY() * 16.0D);
		double minV = (double)icon.getInterpolatedV(16.0D - block.getBlockBoundsMinY() * 16.0D);
		
		if( block.getBlockBoundsMinZ() < 0.0D || block.getBlockBoundsMaxZ() > 1.0D )
		{
			minU = (double)icon.getMinU();
			maxU = (double)icon.getMaxU();
		}
		
		if( block.getBlockBoundsMinY() < 0.0D || block.getBlockBoundsMaxY() > 1.0D )
		{
			maxV = (double)icon.getMinV();
			minV = (double)icon.getMaxV();
		}
		
		double minX = x + block.getBlockBoundsMinX();
		double maxX = x + block.getBlockBoundsMaxX();
		double minY = y + block.getBlockBoundsMinX();
		double maxY = y + block.getBlockBoundsMaxX();
		double minZ = z + block.getBlockBoundsMinX();
		double maxZ = z + block.getBlockBoundsMaxX();
		
		double PI = 3.1415926535897932384626433;
		
		int num = 8;
		double centerX = minX + (maxX - minX) / 2;
		double centerZ = minZ + (maxZ - minZ) / 2;
		
		double centerU = minU + (maxU - minU) / 8;
		double centerV = minV + (maxV - minV) / 8;
		double r = 1.5;
		double ur = (maxU - minU) / 8;
		double vr = (maxV - minV) / 8;
		
		double midY = minY + (maxY - minY) / 2;
		
		for( int i = 0; i < num; i++ )
		{
			double x1 = r * Math.sin(i * (360 / num) * PI / 180);
			double x2 = r * Math.sin((i + 1) * (360 / num) * PI / 180);
			
			double z1 = r * Math.cos(i * (360 / num) * PI / 180);
			double z2 = r * Math.cos((i + 1) * (360 / num) * PI / 180);
			
			double u1 = ur * Math.sin(i * (360 / num) * PI / 180);
			double u2 = ur * Math.sin((i + 1) * (360 / num) * PI / 180);
			
			double v1 = vr * Math.cos(i * (360 / num) * PI / 180);
			double v2 = vr * Math.cos((i + 1) * (360 / num) * PI / 180);
			
			double u01 = UVXYConverter.getU(minU, maxU, 128, 0);
			double u02 = UVXYConverter.getU(minU, maxU, 128, 16);
			double u03 = UVXYConverter.getU(minU, maxU, 128, 16);
			double u04 = UVXYConverter.getU(minU, maxU, 128, 0);
			
			double v01 = UVXYConverter.getV(minV, maxV, 128, 0);
			double v02 = UVXYConverter.getV(minV, maxV, 128, 0);
			double v03 = UVXYConverter.getV(minV, maxV, 128, 16);
			double v04 = UVXYConverter.getV(minV, maxV, 128, 16);
			/*double u01 = UVXYConverter.getU(minU, maxU, 128, 32);
			double u02 = UVXYConverter.getU(minU, maxU, 128, 48);
			double u03 = UVXYConverter.getU(minU, maxU, 128, 48);
			double u04 = UVXYConverter.getU(minU, maxU, 128, 32);
			
			double v01 = UVXYConverter.getV(minV, maxV, 128, 0);
			double v02 = UVXYConverter.getV(minV, maxV, 128, 0);
			double v03 = UVXYConverter.getV(minV, maxV, 128, 16);
			double v04 = UVXYConverter.getV(minV, maxV, 128, 16);///
			
			tessellator.addVertexWithUV(centerX,		minY + 0.001, centerZ,		u01, v01);
			tessellator.addVertexWithUV(centerX + x1,	minY + 0.001, centerZ + z1,	u02, v02);
			tessellator.addVertexWithUV(centerX + x2,	minY + 0.001, centerZ + z2,	u03, v03);
			tessellator.addVertexWithUV(centerX,		minY + 0.001, centerZ,		u04, v04);
			
			
			
			tessellator.addVertexWithUV(centerX,		minY + 0.2, centerZ,		u01, v01);
			tessellator.addVertexWithUV(centerX + x1,	minY + 0.2, centerZ + z1,	u02, v02);
			tessellator.addVertexWithUV(centerX + x2,	minY + 0.2, centerZ + z2,	u03, v03);
			tessellator.addVertexWithUV(centerX,		minY + 0.2, centerZ,		u04, v04);
			/*tessellator.addVertexWithUV(centerX,		minY + 0.001, centerZ,		centerU,		centerV		);
			tessellator.addVertexWithUV(centerX + x1,	minY + 0.001, centerZ + z1,	centerU + u1,	centerV + v1);
			tessellator.addVertexWithUV(centerX + x2,	minY + 0.001, centerZ + z2,	centerU + u2,	centerV + v2);
			tessellator.addVertexWithUV(centerX,		minY + 0.001, centerZ,		centerU,		centerV		);
			
			tessellator.addVertexWithUV(centerX,		minY + 0.2, centerZ,		centerU,		centerV		);
			tessellator.addVertexWithUV(centerX + x1,	minY + 0.2, centerZ + z1,	centerU + u1,	centerV + v1);
			tessellator.addVertexWithUV(centerX + x2,	minY + 0.2, centerZ + z2,	centerU + u2,	centerV + v2);
			tessellator.addVertexWithUV(centerX,		minY + 0.2, centerZ,		centerU,		centerV		);//
		}//
	*/
}
