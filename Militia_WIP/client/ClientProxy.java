package thirdworld.client;

import thirdworld.CommonProxy;
import thirdworld.*;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.*;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityMilitia.class, new RenderMilitia());
	}
}
