package thirdworld.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class ItemBlindMedicine extends Item {
	/** Constructor for BlindMedicine
	 * @param void
	 * @return void
	 */
	public ItemBlindMedicine() {
		super();
		setMaxStackSize(1); //Set the max stack size to 1 item
		setCreativeTab(CreativeTabs.tabBrewing); //Put the medicine in Brewing tab
		setUnlocalizedName("itemBlindMedicine"); //Set name
		setTextureName("thirdworld:itemBlindMedicine"); //Set texture
	}
	
	/** onEaten method, copied from ItemBucketMilk **/
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        if (!par2World.isRemote)
        {
            par3EntityPlayer.curePotionEffects(par1ItemStack);
        }
        
        par3EntityPlayer.removePotionEffect(Potion.blindness.id);

        return par1ItemStack;
    }
	
	/**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 8;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
}
