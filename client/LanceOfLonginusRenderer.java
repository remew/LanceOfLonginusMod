package net.remew.LanceOfLonginusMod.client;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class LanceOfLonginusRenderer implements IItemRenderer
{
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
		
	}
	private void renderEquippedFirstPerson(ItemRenderType type, ItemStack item, Object... data)
	{
		
	}
}
