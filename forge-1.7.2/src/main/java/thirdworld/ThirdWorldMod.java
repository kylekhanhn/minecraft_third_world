package thirdworld;

import thirdworld.blocks.*;
import thirdworld.entities.*;
import thirdworld.items.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityVillager;
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
    
    /***************** Crops *******************/
    
    //Peanuts
    public static Block blockPeanutPlant;
    public static Item itemPeanutSeeds;
    public static Item itemPeanut; 
    
    //Corn
    public static Block blockCornPlant;
    public static Item itemCornSeeds;
    public static Item itemCorn;
    
    //Okra
    public static Block blockOkraPlant;
    public static Item itemOkraSeeds;
    public static Item itemOkra; 
    
    //Cotton
    public static Block blockCottonPlant;
    public static Item itemCottonSeeds;
    public static Item itemCotton;
    
    //Avocado
    public static Block blockAvocadoPlant;
    public static Item itemAvocadoSeeds;
    public static Item itemAvocado;
    
    
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
    	/***** Crops *****/
    	/*********************************************************************************************/
    	blockPeanutPlant = new CropPeanut().setBlockName("PeanutPlant");
    	itemPeanutSeeds = new ItemSeeds(blockPeanutPlant, Blocks.farmland).setUnlocalizedName("PeanutSeeds").setTextureName("thirdworld:peanutSeed");
    	itemPeanut = new ItemFood(4, 0.5F, false).setUnlocalizedName("Peanut").setTextureName("thirdworld:peanut");
    	
    	blockCornPlant = new CropCorn().setBlockName("CornPlant");
    	itemCornSeeds = new ItemSeeds(blockCornPlant, Blocks.farmland).setUnlocalizedName("CornSeeds").setTextureName("thirdworld:cornSeed");
    	itemCorn = new ItemFood(4, 0.5F, false).setUnlocalizedName("Corn").setTextureName("thirdworld:corn");
    	
    	blockOkraPlant = new CropOkra().setBlockName("OkraPlant");
    	itemOkraSeeds = new ItemSeeds(blockOkraPlant, Blocks.farmland).setUnlocalizedName("OkraSeeds").setTextureName("thirdworld:okraSeed");
    	itemOkra = new ItemFood(4, 0.5F, false).setUnlocalizedName("Okra").setTextureName("thirdworld:okra");
    	
    	blockCottonPlant = new CropCotton().setBlockName("CottonPlant");
    	itemCottonSeeds = new ItemSeeds(blockCottonPlant, Blocks.farmland).setUnlocalizedName("CottonSeeds").setTextureName("thirdworld:cottonSeed");
    	itemCotton = new ItemFood(4, 0.5F, false).setUnlocalizedName("Cotton").setTextureName("thirdworld:cotton");
    	
    	blockAvocadoPlant = new CropAvocado().setBlockName("AvocadoPlant");
    	itemAvocadoSeeds = new ItemSeeds(blockAvocadoPlant, Blocks.farmland).setUnlocalizedName("AvocadoSeeds").setTextureName("thirdworld:avocadoSeed");
    	itemAvocado = new ItemFood(4, 0.5F, false).setUnlocalizedName("Avocado").setTextureName("thirdworld:avocado");
    	
    	GameRegistry.registerBlock(blockPeanutPlant, "PeanutPlant");
    	GameRegistry.registerItem(itemPeanutSeeds, "PeanutSeeds");
    	GameRegistry.registerItem(itemPeanut, "Peanut");
    	
    	GameRegistry.registerBlock(blockCornPlant, "CornPlant");
    	GameRegistry.registerItem(itemCornSeeds, "CornSeeds");
    	GameRegistry.registerItem(itemCorn, "Corn");
    	
    	GameRegistry.registerBlock(blockOkraPlant, "OkraPlant");
    	GameRegistry.registerItem(itemOkraSeeds, "OkraSeeds");
    	GameRegistry.registerItem(itemOkra, "Okra");
    	
    	GameRegistry.registerBlock(blockCottonPlant, "CottonPlant");
    	GameRegistry.registerItem(itemCottonSeeds, "CottonSeeds");
    	GameRegistry.registerItem(itemCotton, "Cotton");
    	
    	GameRegistry.registerBlock(blockAvocadoPlant, "AvocadoPlant");
    	GameRegistry.registerItem(itemAvocadoSeeds, "AvocadoSeeds");
    	GameRegistry.registerItem(itemAvocado, "Avocado");
    	
    	MinecraftForge.addGrassSeed(new ItemStack(itemPeanutSeeds), 10);
    	MinecraftForge.addGrassSeed(new ItemStack(itemCornSeeds), 10);
    	MinecraftForge.addGrassSeed(new ItemStack(itemOkraSeeds), 10);
    	MinecraftForge.addGrassSeed(new ItemStack(itemCottonSeeds), 10);
    	MinecraftForge.addGrassSeed(new ItemStack(itemAvocadoSeeds), 10);
    	
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
    	MinecraftForge.EVENT_BUS.register(new DiseaseEventHandler());
    	
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
