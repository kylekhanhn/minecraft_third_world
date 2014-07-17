package thirdworld;

import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.*;

public class DiseaseEventHandler {
	/*Method to deal with the event*/
	@SubscribeEvent
	public void eventInteract(PlayerInteractEvent event)
	{
		if (event.action == Action.RIGHT_CLICK_BLOCK) {
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
	    	((EntityLivingBase)player).addPotionEffect((new PotionEffect(Potion.poison.getId(), 2000)));
//	    	player.setHealth(player.getHealth() - 1);
	    	player.attackEntityFrom(DamageSource.magic, 1.0F);
		}
	}
	
	@SubscribeEvent
	public void eventTest(PlayerTickEvent event) {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		player.setHealth(player.getHealth() - 1);
	}
}
