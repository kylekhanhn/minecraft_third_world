package thirdworld;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;

import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.*;

/*A new event handler for catching EntityJoinWorld Events*/
public class EntityJoinEventHandler 
{
	/*Method to deal with the event*/
	@SubscribeEvent
	public void eventEntityJoin(EntityJoinWorldEvent event)
	{
		/*Filters for Monster entities*/
		if(event.entity instanceof EntityBlaze
				|| event.entity instanceof EntityCaveSpider
				|| event.entity instanceof EntityCreeper
				|| event.entity instanceof EntityEnderman
				|| event.entity instanceof EntityGhast
				|| event.entity instanceof EntityGiantZombie
				|| event.entity instanceof EntityGolem
				|| event.entity instanceof EntityIronGolem
				|| event.entity instanceof EntityMagmaCube
				|| event.entity instanceof EntityPigZombie
				|| event.entity instanceof EntitySilverfish
				|| event.entity instanceof EntitySkeleton 
				|| event.entity instanceof EntitySlime
				|| event.entity instanceof EntitySnowman
				|| event.entity instanceof EntitySpider
				|| event.entity instanceof EntityWitch
				|| event.entity instanceof EntityZombie
				|| event.entity instanceof EntitySquid
				|| event.entity instanceof EntityMooshroom) 
		{
			//Cancels the event
	    	event.setCanceled(true);
	    }
	}
}
