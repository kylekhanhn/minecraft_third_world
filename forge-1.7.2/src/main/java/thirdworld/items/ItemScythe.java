package thirdworld.items;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

/**
 * The class for Scythe item
 */
public class ItemScythe extends Item 
{	
	/** Constructor for ItemScythe
	 * @param void
	 * @return void
	 */
	public ItemScythe() 
	{
		setMaxStackSize(1); //Allow only 1 scythe per inventory slot
		setCreativeTab(CreativeTabs.tabTools); //Put the scythe in the tools tab
		setUnlocalizedName("itemScythe"); //Set name
		setTextureName("thirdworld:itemScythe"); //Set scythe texture
	} 
}