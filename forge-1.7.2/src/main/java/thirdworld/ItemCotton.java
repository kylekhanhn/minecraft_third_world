package thirdworld;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemCotton extends Item implements IPlantable{

	public ItemCotton() 
	{
		//super(-1, 0.3F, ThirdWorldMod.blockCotton, Blocks.farmland);
		setUnlocalizedName("cotton");
		setTextureName("thirdworld:wheat");
		setCreativeTab(CreativeTabs.tabMaterials);
	}

	
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Crop;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		
		return ThirdWorldMod.blockCotton;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		
		return 0;
	}

}
