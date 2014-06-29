package thirdworld;

import static org.junit.Assert.*;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.Entity;

import org.junit.Test;

public class EntityMilitiaTest {

	@Test
	public void catchMilitiaTest() {
		/* Event handler to test */
		EntityJoinEventHandler eventHandler = new EntityJoinEventHandler();
		Entity entity = new EntityMilitia(null);
		/* Creates an EntityJoinWorldEvent using the previously created entity */
		EntityJoinWorldEvent event = new EntityJoinWorldEvent(entity, null);
		//Test if militia spawned successfully
		assertEquals(false, event.isCanceled());
	}
	
}
