package thirdworld;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.entity.monster.*;
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
    
    
    /*NEW CROPS*/
    //Peanuts
    public static Block blockPeanuts;
    public static Item itemPeanuts;
   
    
    //Cotton
    public static Block blockCotton;
    public static Item itemCotton;
    
    
    
    /***** Methods *****/
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
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
    	
    	/*Registers the new event handler with the Event Bus and Terrain Generation Bus*/
    	MinecraftForge.TERRAIN_GEN_BUS.register(new EntityJoinEventHandler()); 
    	MinecraftForge.EVENT_BUS.register(new EntityJoinEventHandler());
    	
    	/*new crop*/
    	blockPeanuts = new BlockPeanuts(1018).setBlockName("peanut");
    	itemPeanuts = new ItemSeedFood(3, 0.5F, blockPeanuts, Block.getBlockFromName("BlockDirt")).setUnlocalizedName("itemPeanuts").setTextureName(MODID + ":" + "peanuts");
    	blockCotton = new BlockCotton(1019).setBlockName("cotton");
    	itemCotton = new ItemSeedFood(3, 0.5F, blockCotton, Block.getBlockFromName("BlockDirt")).setUnlocalizedName("itemCotton").setTextureName(MODID + ":" + "cotton");
    	//new crops - Game Registry Blocks
    	GameRegistry.registerBlock(blockCotton, "Cotton");
    	GameRegistry.registerBlock(blockPeanuts, "Peanuts");
    	
    }
    
	 
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	// Implement when needed
    }
    
    
}
