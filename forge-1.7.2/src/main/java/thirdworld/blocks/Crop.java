package thirdworld.blocks;

import java.util.Random;

import thirdworld.ThirdWorldMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class Crop extends BlockCrops
{
	@SideOnly(Side.CLIENT)
	protected IIcon[] iconTextures;	
	private String cropType;
	
	public Crop(String type)
	{
		this.cropType = type;
	}
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister textureRegistry)
    {
    	this.iconTextures = new IIcon[7];

    	for (int i = 0; i < iconTextures.length; i++)
        {
            this.iconTextures[i] = textureRegistry.registerIcon("thirdworld:"+cropType.toLowerCase()+ (i+1));
        }
    }		
	
	public IIcon getIcon(int side, int metadata)
	{		
		if(metadata < 0 || metadata > 6)
		{
			metadata = 6;
		}
		return this.iconTextures[metadata];
	}
	
	public int quantityDropped(Random random)
    {
        return 3;
    }
	
	protected Item func_149866_i()
    {		
		if(cropType.equalsIgnoreCase("Avocado"))
			return ThirdWorldMod.itemAvocadoSeeds;
		else if(cropType.equalsIgnoreCase("Corn"))
			return ThirdWorldMod.itemCornSeeds;
		else if(cropType.equalsIgnoreCase("Cotton"))
			return ThirdWorldMod.itemCottonSeeds;
		else if(cropType.equalsIgnoreCase("Okra"))
			return ThirdWorldMod.itemOkraSeeds;
		else if(cropType.equalsIgnoreCase("Peanut"))
			return ThirdWorldMod.itemPeanutSeeds;
		//if(cropType.equalsIgnoreCase("Mango"))
			//return ThirdWorldMod.itemMangoSeeds;
		else
			return ThirdWorldMod.itemAvocadoSeeds;
    }
	
	protected Item func_149865_P()
	{
		if(cropType.equalsIgnoreCase("Avocado"))
			return ThirdWorldMod.itemAvocado;
		else if(cropType.equalsIgnoreCase("Corn"))
			return ThirdWorldMod.itemCorn;
		else if(cropType.equalsIgnoreCase("Cotton"))
			return ThirdWorldMod.itemCotton;
		else if(cropType.equalsIgnoreCase("Okra"))
			return ThirdWorldMod.itemOkra;
		else if(cropType.equalsIgnoreCase("Peanut"))
			return ThirdWorldMod.itemPeanut;
		//if(cropType.equalsIgnoreCase("Mango"))
			//return ThirdWorldMod.itemMango;
		else
			return ThirdWorldMod.itemAvocado;
	}

}
