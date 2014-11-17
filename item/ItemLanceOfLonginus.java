package net.remew.LanceOfLonginusMod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.remew.LanceOfLonginusMod.LanceOfLonginusMod;
import net.remew.LanceOfLonginusMod.entity.EntityLanceOfLonginus;

public class ItemLanceOfLonginus extends Item
{

	public ItemLanceOfLonginus(int par1)
	{
		super(par1);
		this.setMaxStackSize(1);
		this.setCreativeTab(LanceOfLonginusMod.creativeTab);
		this.setUnlocalizedName("LanceOfLonginus");
		this.setTextureName("llmod:Icon_LanceOfLonginus");
	}
	
	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		//double d5 = this.targetedEntity.posX - this.posX;
        //double d6 = this.targetedEntity.boundingBox.minY + (double)(this.targetedEntity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
        //double d7 = this.targetedEntity.posZ - this.posZ;
		
		if (!entityPlayer.capabilities.isCreativeMode)
		{
			itemStack.stackSize--;
		}//*/
		if( !world.isRemote )
		{
			//world.spawnEntityInWorld(new EntityLanceOfLonginus(world, entityPlayer, 0.0, 0.0, 0.0));
			world.spawnEntityInWorld(new EntityLanceOfLonginus(world, entityPlayer));
		}
		
		return itemStack;
	}
}
