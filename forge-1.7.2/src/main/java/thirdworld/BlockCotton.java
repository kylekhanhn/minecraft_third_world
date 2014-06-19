package thirdworld;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class BlockCotton extends BlockCrops{
	
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	//Constructor
	public BlockCotton(int p) 
	{
		super();
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIIcon(int side, int metadata) 
	{
		if(metadata >  7)
		{
			if(metadata == 6){
				metadata =5;
			}
			return iconArray[metadata >> 1];
			
		}
		return iconArray[3];
	}
	
	/* Error
	public int getSeedItem()
	{
		return ThirdWorldMod.itemCotton.itemID;
	}
	
	
	public int getCropItem()
	{
		return ThirdWorldMod.itemCotton.itemID;
	}
	*/
	
	@SideOnly(Side.CLIENT)
	public void registerIIcons(IIconRegister iiconRegister)
	{
		this.iconArray = new IIcon[4];
		
		for(int i = 0; i < this.iconArray.length; i++)
		{
			this.iconArray[i] = iiconRegister.registerIcon(ThirdWorldMod.MODID + ":" + "cotton_" + (i+1));
		}
	}
}