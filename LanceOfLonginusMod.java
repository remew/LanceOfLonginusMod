package net.remew.LanceOfLonginusMod;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.Configuration;
import net.remew.LanceOfLonginusMod.item.ItemLanceOfLonginus;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid=LanceOfLonginusMod.MOD_ID)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class LanceOfLonginusMod
{
	public static final String MOD_ID = "LanceOfLonginusMod";
	
	@Mod.Instance(LanceOfLonginusMod.MOD_ID)
	public static LanceOfLonginusMod instance;
	
	public static final LLModCreativeTab creativeTab = new LLModCreativeTab("lanceoflonginusmod");
	
	public static Item lanceOfLonginus;
	public static int ID_LanceOfLonginus;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		LanceOfLonginusMod.ID_LanceOfLonginus = config.getItem("IdLanceOfLonginus", 14502).getInt();
		config.save();
		
		this.lanceOfLonginus = new ItemLanceOfLonginus(this.ID_LanceOfLonginus - 256);
		GameRegistry.registerItem(this.lanceOfLonginus, "LanceOfLonginus");
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		if( FMLCommonHandler.instance().getSide() == Side.CLIENT )
		{
			MinecraftForgeClient.registerItemRenderer(this.lanceOfLonginus.itemID, null);
		}
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
