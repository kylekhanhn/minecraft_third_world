package thirdworld;

import java.util.Random;
import thirdworld.items.*;

import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
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
import net.minecraft.entity.passive.*;
import net.minecraft.item.ItemStack;

public class DiseaseEventHandler {
	/*Method to deal with the event*/
	@SubscribeEvent
	public void eventInteract(EntityInteractEvent event)
	{
		if (event.target instanceof EntityCow ||
				event.target instanceof EntitySheep ||
				event.target instanceof EntityPig)
		{
			Random ranNum = new Random();
			int r = ranNum.nextInt(100);
			
			//10% chance of getting blinded by an animal
			if(r <= 2)
			{
				EntityPlayer player = Minecraft.getMinecraft().thePlayer;
				PotionEffect newPotion = new PotionEffect(Potion.blindness.id, Integer.MAX_VALUE, 0);
				/* Cure for potion effect */
		    	newPotion.addCurativeItem(new ItemStack(new ItemBlindMedicine()));
				player.addPotionEffect(newPotion);
			}
		}
	}
	
	@SubscribeEvent
	public void eventHit(AttackEntityEvent event)
	{
		if (event.target instanceof EntityCow ||
				event.target instanceof EntitySheep ||
				event.target instanceof EntityPig)
		{
			Random ranNum = new Random();
			int r = ranNum.nextInt(100);
			
			//10% chance of getting blinded by an animal
			if(r <= 2)
			{
				EntityPlayer player = Minecraft.getMinecraft().thePlayer;
				PotionEffect newPotion = new PotionEffect(Potion.blindness.id, Integer.MAX_VALUE, 0);
				/* Cure for potion effect */
		    	newPotion.addCurativeItem(new ItemStack(new ItemBlindMedicine()));
				player.addPotionEffect(newPotion);
			}
			
		}
	}
	
//	@SubscribeEvent
//	public void eventTryingThings(LivingUpdateEvent event) {
//		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
//		if (player != null && player.getActivePotionEffect(Potion.blindness) != null
//				&& player.isInWater()) {
//			player.removePotionEffect(Potion.blindness.id);
//		}
//	}
}
