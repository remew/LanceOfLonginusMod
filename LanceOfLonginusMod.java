package net.remew.LanceOfLonginusMod;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.Configuration;
import net.remew.LanceOfLonginusMod.client.LanceOfLonginusRenderer;
import net.remew.LanceOfLonginusMod.entity.EntityLanceOfLonginus;
import net.remew.LanceOfLonginusMod.item.ItemLanceOfLonginus;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
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
	
	@SidedProxy(clientSide = "net.remew.LanceOfLonginusMod.client.ClientProxy",
				serverSide = "net.remew.LanceOfLonginusMod.server.ServerProxy")
	public static CommonProxy proxy;
	
	public static Item lanceOfLonginus;
	public static int ID_itemLanceOfLonginus;
	public static int ID_entityLanceOfLonginus;
	
	public static final ResourceLocation LANCE_RESOURCE_LOCATION = new ResourceLocation("llmod:textures/lance_of_longinus_texture.png");
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		this.ID_itemLanceOfLonginus = config.getItem("LanceOfLonginus", 14502).getInt();
		this.ID_entityLanceOfLonginus = config.get("Entity", "LanceOfLonginus", 252).getInt();
		config.save();
		
		this.lanceOfLonginus = new ItemLanceOfLonginus(this.ID_itemLanceOfLonginus - 256);
		GameRegistry.registerItem(this.lanceOfLonginus, "LanceOfLonginus");
		
		EntityRegistry.registerModEntity(EntityLanceOfLonginus.class, "LanceOfLonginus", this.ID_entityLanceOfLonginus, this, 250, 5, true);
		EntityRegistry.registerGlobalEntityID(EntityLanceOfLonginus.class, "LanceOfLonginus", this.ID_entityLanceOfLonginus);
		this.proxy.registerRenderers();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		if( FMLCommonHandler.instance().getSide() == Side.CLIENT )
		{
			MinecraftForgeClient.registerItemRenderer(this.lanceOfLonginus.itemID, new LanceOfLonginusRenderer());
		}
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
