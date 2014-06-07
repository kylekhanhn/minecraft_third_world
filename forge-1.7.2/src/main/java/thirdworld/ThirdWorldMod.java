package thirdworld;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ThirdWorldMod.MODID, name="Third World Country", version="0.0")
public class ThirdWorldMod {
	
	public static final String MODID = "ThirdWorldMod";

    // The instance of your mod that Forge uses.
    @Instance(value = ThirdWorldMod.MODID)
    public static ThirdWorldMod instance;
    
    // Says where the client and server proxy code is loaded.
    @SidedProxy(clientSide="thirdworld.client.ClientProxy", serverSide="thirdworld.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler // used in 1.6.2
    public void preInit(FMLPreInitializationEvent event) {
            // Stub Method
    }
    
    @EventHandler // used in 1.6.2
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderers();
    }
    
    @EventHandler // used in 1.6.2
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }
}
