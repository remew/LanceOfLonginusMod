package net.remew.LanceOfLonginusMod.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelLargeChest;
import net.remew.LanceOfLonginusMod.CommonProxy;
import net.remew.LanceOfLonginusMod.entity.EntityLanceOfLonginus;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityLanceOfLonginus.class, new RenderLanceOfLonginus(new ModelLanceOfLonginus()));
	}
}
