package thirdworld.client;

import thirdworld.CommonProxy;
import thirdworld.*;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.*;

/** The client proxy class
 */
public class ClientProxy extends CommonProxy {
	/**
	 * Register the custom rendering handlers
	 */
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityMilitia.class, new RenderMilitia());
	}
}
