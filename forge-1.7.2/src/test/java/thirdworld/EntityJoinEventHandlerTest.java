package thirdworld;

import static org.junit.Assert.*;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.Entity;

import org.junit.Test;

public class EntityJoinEventHandlerTest {

	@Test
	public void catchMonsterMobsTest() 
	{
		/*Creates an entity*/
		Entity entity = new EntityBat (null);
		/*Creates an EntityJoinWorldEvent using the previously created entity*/
		EntityJoinWorldEvent event = new EntityJoinWorldEvent(entity, null);
		/*Checks if the event has been canceled by the event handler being tested*/
		assertEquals(false, event.isCanceled());
		
		entity = new EntityWolf(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(false, event.isCanceled());
		
		entity = new EntityBlaze(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());		
		
		entity = new EntityCaveSpider(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());
		
		entity = new EntityCreeper(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());		
		
		entity = new EntityEnderman(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());
		
		entity = new EntityGhast(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());
		
		entity = new EntityGiantZombie(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());
		
		entity = new EntityIronGolem(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());		
		
		entity = new EntityMagmaCube(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());			
		
		entity = new EntityIronGolem(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());	
		
		entity = new EntityIronGolem(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());
		
		entity = new EntityPigZombie(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());
		
		entity = new EntitySilverfish(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());
		
		entity = new EntitySkeleton(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());
		
		entity = new EntitySlime(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());
		
		entity = new EntitySnowman(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());
		
		entity = new EntitySpider(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());
		
		entity = new EntityWitch(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());
		
		entity = new EntityZombie(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());
		
		entity = new EntitySquid(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());
		
		entity = new EntityMooshroom(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());
		
		entity = new EntityMooshroom(null);
		event = new EntityJoinWorldEvent(entity, null);
		assertEquals(true, event.isCanceled());		
	}

}
