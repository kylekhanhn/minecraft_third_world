package thirdworld;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.*;

/******** This is the base mod class for our mod ********/
@Mod(modid = ThirdWorldMod.MODID, name="Third World Country", version="0.0")
public class ThirdWorldMod {
	
	/****** Attributes *****/
	//Declare the ID for the base mod class
	public static final String MODID = "ThirdWorldMod";

    // The instance of your mod that Forge uses.
    @Instance(value = ThirdWorldMod.MODID)
    public static ThirdWorldMod instance;
    
    // Says where the client and server proxy code is loaded.
    @SidedProxy(clientSide="thirdworld.client.ClientProxy", serverSide="thirdworld.CommonProxy")
    public static CommonProxy proxy;
    
    //Including the custom items
    public static ItemScythe itemScythe;
    
    
    /***** Methods *****/
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Stub Method
    	itemScythe = new ItemScythe();
    	GameRegistry.registerItem(itemScythe, "scythe");
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
    	proxy.registerRenderers();
    	
    	/* Add recipes for crafting */
    	ItemStack stickStack = new ItemStack(Items.stick);
    	ItemStack cobbleStack = new ItemStack(Blocks.cobblestone);
    	
    	GameRegistry.addRecipe(new ItemStack(itemScythe), "xxx", "  y", " y ",
    			'x', cobbleStack, 'y', stickStack);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	// Stub Method
    }
}
