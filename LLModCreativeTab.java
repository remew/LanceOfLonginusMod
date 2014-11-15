package net.remew.LanceOfLonginusMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LLModCreativeTab extends CreativeTabs
{
	public LLModCreativeTab(String label)
	{
		super(label);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return LanceOfLonginusMod.lanceOfLonginus;
	}
}
