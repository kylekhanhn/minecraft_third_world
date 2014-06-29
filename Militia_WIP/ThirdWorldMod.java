package thirdworld;

import thirdworld.client.*;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.entity.*;
import net.minecraft.world.biome.*;

import net.minecraft.entity.monster.*;
import net.minecraft.client.model.*;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.*;

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

    // The instance of our mod that Forge uses.
    @Instance(value = ThirdWorldMod.MODID)
    public static ThirdWorldMod instance;
    
    // Says where the client and server proxy code is loaded.
    @SidedProxy(clientSide="thirdworld.client.ClientProxy", serverSide="thirdworld.CommonProxy")
    public static CommonProxy proxy;
    
    //Including the custom items
    public static ItemScythe itemScythe;
    
    //Including the custom entities
    public static EntityMilitia entityMilitia;
    
    
    /***** Methods *****/
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	itemScythe = new ItemScythe();
    	GameRegistry.registerItem(itemScythe, "scythe");
    	EntityRegistry.registerGlobalEntityID(EntityMilitia.class, "entityMilitia", EntityRegistry.findGlobalUniqueEntityId(), (255 << 16), (255 << 16)+ (200 << 8));
    	EntityRegistry.registerModEntity(EntityMilitia.class, "entityMilitia", 0, this, 80, 3, true);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	//Nothing here yet
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
    	/* Register mob entities */
    	EntityRegistry.addSpawn(EntityMilitia.class, 3, 1, 3, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.forest, BiomeGenBase.hell,
    			BiomeGenBase.jungle, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.plains,
    			BiomeGenBase.beach);
    	
    	/* Add recipes for crafting */
    	ItemStack stickStack = new ItemStack(Items.stick);
    	ItemStack cobbleStack = new ItemStack(Blocks.cobblestone);
    	
    	GameRegistry.addRecipe(new ItemStack(itemScythe), "xxx", "  y", " y ",
    			'x', cobbleStack, 'y', stickStack);
    	
    	/*Registers the new event handler with the Event Bus and Terrain Generation Bus*/
    	MinecraftForge.TERRAIN_GEN_BUS.register(new EntityJoinEventHandler()); 
    	MinecraftForge.EVENT_BUS.register(new EntityJoinEventHandler());
    	
    	proxy.registerRenderers();
    }
    
	 
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	// Implement when needed
    }
    
}
