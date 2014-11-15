package net.remew.LanceOfLonginusMod;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid=LanceOfLonginusMod.MOD_ID)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class LanceOfLonginusMod
{
	public static final String MOD_ID = "LanceOfLonginusMod";
	
	@Mod.Instance(LanceOfLonginusMod.MOD_ID)
	public static LanceOfLonginusMod instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.save();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
