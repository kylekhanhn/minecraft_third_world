package thirdworld.client;

import thirdworld.entities.*;
import thirdworld.mod.*;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.*;

public class ClientProxy extends CommonProxy 
{
	@Override
	public void registerRenderers() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityMilitia.class, new RenderMilitia());
	}
}
