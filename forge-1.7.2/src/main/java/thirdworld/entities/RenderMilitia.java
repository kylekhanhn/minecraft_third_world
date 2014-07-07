package thirdworld.entities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.entity.*;

/**
 * The class used to render the Militia mob
 */
@SideOnly(Side.CLIENT)
public class RenderMilitia extends RenderBiped
{
	/** Determines where the texture file is located
	 */
    private static final ResourceLocation militiaTextures = new ResourceLocation("thirdworld:textures/entities/entitymilitia.png");

    /** Constructor for RenderMilitia
	 * @param void
	 * @return void
	 */
    public RenderMilitia()
    {
        super(new ModelZombie(), 0.5F, 1.0F);
    }
    
    /** Return the resource location of the militia texture
     * @param Entity entity
     * @return ResourceLocation of the militia texture
	 */
    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return militiaTextures;
    }
}