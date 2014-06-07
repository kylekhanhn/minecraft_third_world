package thirdworld;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class ItemScythe extends Item {
	//Constructor
	public ItemScythe() {
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("itemScythe");
	}
}
