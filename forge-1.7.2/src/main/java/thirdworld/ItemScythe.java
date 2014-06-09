package thirdworld;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class ItemScythe extends Item {
	
	//Constructor
	public ItemScythe() {
		setMaxStackSize(1); //Allow only 1 scythe per inventory slot
		setCreativeTab(CreativeTabs.tabTools); //Put the scythe in the tools tab
		setUnlocalizedName("itemScythe");
		setTextureName("thirdworld:itemScythe"); //Set the texture
	}
	
}
