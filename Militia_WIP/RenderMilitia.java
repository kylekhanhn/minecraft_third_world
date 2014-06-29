package thirdworld;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.entity.*;

@SideOnly(Side.CLIENT)
public class RenderMilitia extends RenderBiped
{
    private static final ResourceLocation militiaTextures = new ResourceLocation("thirdworld:textures/entities/entitymilitia.png");
    //private static final ResourceLocation witherSkeletonTextures = new ResourceLocation("thirdworld:entityMilitia");
    //private static final String __OBFID = "CL_00001023";

    public RenderMilitia()
    {
        super(new ModelZombie(), 0.5F, 1.0F);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return militiaTextures;
    }
}