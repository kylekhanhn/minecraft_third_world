package thirdworld.blocks;

import java.util.Random;

import thirdworld.mod.ThirdWorldMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class BlockPeanut extends BlockBush implements IGrowable{
	
	@SideOnly(Side.CLIENT)
	private IIcon[] field_149867_a;
	
	public BlockPeanut()
    {
        this.setBlockName("peanuts");
        this.setBlockTextureName("thirdworld:wheat_stage_0");
    }
	
	@Override
    public int getRenderType()
	{
       return 1;
	} 
   
	public void incrementGrowStage(World parWorld, int parX, int parY, int parZ)
    {
        int growStage = parWorld.getBlockMetadata(parX, parY, parZ) + MathHelper

              .getRandomIntegerInRange(parWorld.rand, 2, 5);

        if (growStage > 7)
        {
            growStage = 7;
        }

        parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
    }
	@Override
    // checks if finished growing
    public boolean func_149851_a(World parWorld, int parX, int parY, int parZ, 

          boolean p_149851_5_)
    {
        return parWorld.getBlockMetadata(parX, parY, parZ) != 7;
    }

    @Override
    public boolean func_149852_a(World p_149852_1_, Random parRand, int p_149852_3_, 

          int p_149852_4_, int p_149852_5_)
    {
        return true;
    }
	@Override
    public void func_149853_b(World parWorld, Random parRand, int parX, int parY, int parZ)
    {
        incrementGrowStage(parWorld, parX, parY, parZ);
    }
	
	
    // this is seed item for the crop
    protected Item func_149866_i()
    {
        return ThirdWorldMod.seedPeanut; 
    }


    // this is item harvested from crop
    protected Item func_149865_P()
    {
        return ThirdWorldMod.seedPeanut;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }
 
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconReg)
    {
          field_149867_a = new IIcon[8];
          // seems that crops like to have 8 growth icons, but okay to 

          // repeat actual texture if you want
          field_149867_a[0] = iconReg.registerIcon("thirdworld:wheat_stage_0");
          field_149867_a[1] = iconReg.registerIcon("thirdworld:wheat_stage_1");
          field_149867_a[2] = iconReg.registerIcon("thirdworld:wheat_stage_2");
          field_149867_a[3] = iconReg.registerIcon("thirdworld:wheat_stage_3");
          field_149867_a[4] = iconReg.registerIcon("thirdworld:wheat_stage_4");
          field_149867_a[5] = iconReg.registerIcon("thirdworld:wheat_stage_5");
          field_149867_a[6] = iconReg.registerIcon("thirdworld:wheat_stage_6");
          field_149867_a[7] = iconReg.registerIcon("thirdworld:wheat_stage_7");
    }
}