package thirdworld.mod;

import thirdworld.blocks.BlockCotton;
import thirdworld.blocks.BlockPeanut;
import thirdworld.entities.EntityJoinEventHandler;
import thirdworld.entities.EntityMilitia;
import thirdworld.items.ItemCotton;
import thirdworld.items.ItemPeanut;
import thirdworld.items.ItemScythe;
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
import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.world.biome.*;
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

/**
 * This is the base mod class for the Third World Mod
 * @version 0.1
 */
@Mod(modid = ThirdWorldMod.MODID, name="Third World Country", version="0.0")
public class ThirdWorldMod 
{
	
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
    
    /*NEW CROPS*/
    //Peanuts
    public final static Block blockPeanut = new BlockPeanut();
    public final static Item itemPeanut = new ItemPeanut();
    public static ItemSeedFood seedPeanut;   
    
    //Cotton
    public final static Block blockCotton = new BlockCotton();
    public final static Item itemCotton = new ItemCotton();
    public static ItemSeedFood seedCotton; 
    
    
    
    /***************** Methods *******************/
    
    /** 
     * Pre-initialization method. Does things such as registering new objects into the game
	 */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
    	itemScythe = new ItemScythe();
    	GameRegistry.registerItem(itemScythe, "scythe");
    	
    	/*********************************************************************************************/
    	/***** The crops currently do not work correctly in-game, and thus will be commented out *****/
    	/*********************************************************************************************/
    	/*
    	GameRegistry.registerBlock(blockCotton, "cottons");
    	GameRegistry.registerItem(itemCotton, "cotton");
    	GameRegistry.registerItem(itemPeanut, "peanut");
    	GameRegistry.registerBlock(blockPeanut, "peanuts");
    	*/
    	/*********************************************************************************************/
    	
    	
    	//register the EntityMilitia
    	EntityRegistry.registerGlobalEntityID(EntityMilitia.class, "entityMilitia", EntityRegistry.findGlobalUniqueEntityId(), (255 << 16), (255 << 16)+ (200 << 8));
    	EntityRegistry.registerModEntity(EntityMilitia.class, "entityMilitia", 0, this, 80, 3, true);
    }
    
    
    /**
     * Load method. Does things such as adding spawns of new entities, new recipes, and registering event handlers.
     * Also call the renderer method from the client proxy
	 */
    @EventHandler
    public void load(FMLInitializationEvent event) 
    {
    	/* Register mob entities */
    	//This is for the militia to spawn during day time
    	EntityRegistry.addSpawn(EntityMilitia.class, 5, 1, 4, EnumCreatureType.creature, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.forest, BiomeGenBase.hell,
    			BiomeGenBase.jungle, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.plains,
    			BiomeGenBase.beach);
    	//This is for the militia to spawn during night time
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
    	
    	/* Call the client renderer method */
    	proxy.registerRenderers();
    }
    
    /**
     * Post-initialization method. Current is not implemented
	 */
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) 
    {
    	// Implement when needed
    }
    
    
}
