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

public class CropCotton extends BlockCrops
{
	@SideOnly(Side.CLIENT)
	protected IIcon[] iconTextures;	
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister textureRegistry)
    {
    	this.iconTextures = new IIcon[7];

    	for (int i = 0; i < iconTextures.length; i++)
        {
            this.iconTextures[i] = textureRegistry.registerIcon("thirdworld:cotton" + (i+1));
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
        return 2;
    }
	
	protected Item func_149866_i()
    {
		return ThirdWorldMod.itemCottonSeeds;
    }
	
	protected Item func_149865_P()
	{
		return ThirdWorldMod.itemCotton;
	}

}
