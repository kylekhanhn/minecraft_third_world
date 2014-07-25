package thirdworld.items;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;



/**
 * The class for Scythe item
 */
public class ItemScythe extends ItemTool 
{	
	private static final Set afinityBlocks = Sets.newHashSet(new Block[] {Blocks.wheat, Blocks.cocoa, Blocks.leaves});
	
	/** Constructor for ItemScythe
	 * @param void
	 * @return void
	 * */
	
	public ItemScythe() 
	{
		super(3.0F, Item.ToolMaterial.STONE, afinityBlocks);
		setMaxStackSize(1); //Allow only 1 scythe per inventory slot
		setCreativeTab(CreativeTabs.tabTools); //Put the scythe in the tools tab
		setUnlocalizedName("itemScythe"); //Set name
		setTextureName("thirdworld:itemScythe"); //Set scythe texture
	} 
}
