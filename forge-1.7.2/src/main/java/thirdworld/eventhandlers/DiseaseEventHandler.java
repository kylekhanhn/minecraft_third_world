package thirdworld.eventhandlers;

import java.util.Random;

import thirdworld.ThirdWorldMod;
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
	
	/** Create a probability of getting blind each time the player interacts with a cow, sheep or pig */
	@SubscribeEvent
	public void eventInteract(EntityInteractEvent event)
	{
		if (event.target instanceof EntityCow ||
				event.target instanceof EntitySheep ||
				event.target instanceof EntityPig)
		{
			Random ranNum = new Random();
			int r = ranNum.nextInt(100);
			
			//2% chance of getting blinded by an animal
			if(r < 2)
			{
				EntityPlayer player = Minecraft.getMinecraft().thePlayer;
				PotionEffect newPotion = new PotionEffect(Potion.blindness.id, Integer.MAX_VALUE, 0);
				/* Cure for potion effect */
		    	newPotion.addCurativeItem(new ItemStack(new ItemBlindMedicine()));
				player.addPotionEffect(newPotion);
			}
		}
	}
	
	/** Create a probability of getting blind each time the player hits a cow, sheep or pig */
	@SubscribeEvent
	public void eventHit(AttackEntityEvent event)
	{
		if (event.target instanceof EntityCow ||
				event.target instanceof EntitySheep ||
				event.target instanceof EntityPig)
		{
			Random ranNum = new Random();
			int r = ranNum.nextInt(100);
			
			//2% chance of getting blinded by an animal
			if(r < 2)
			{
				EntityPlayer player = Minecraft.getMinecraft().thePlayer;
				PotionEffect newPotion = new PotionEffect(Potion.blindness.id, Integer.MAX_VALUE, 0);
				/* Cure for potion effect */
		    	newPotion.addCurativeItem(new ItemStack(new ItemBlindMedicine()));
				player.addPotionEffect(newPotion);
			}
			
		}
	}
	
	/** If the player has not been in contact with water for 5 minutes, they get drowsy */
	@SubscribeEvent
	public void eventGetThirsty(LivingUpdateEvent event) {
		
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if (player != null) {
			if (!player.isInWater()) {
				if (ThirdWorldMod.thirstTime < 5*60000/60)
					ThirdWorldMod.thirstTime++;
				else 
					player.addPotionEffect(new PotionEffect(Potion.confusion.id, Integer.MAX_VALUE, 0));
			} else {
				player.removePotionEffect(Potion.confusion.id);
				ThirdWorldMod.thirstTime = 0;
			}
			
		}
		
	}
	
}
