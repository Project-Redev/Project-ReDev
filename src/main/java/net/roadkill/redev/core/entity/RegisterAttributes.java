package net.roadkill.redev.core.entity;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.roadkill.redev.common.entity.LithicanEntity;
import net.roadkill.redev.common.entity.RevenantEntity;
import net.roadkill.redev.core.init.EntityInit;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class RegisterAttributes
{
    @SubscribeEvent
    public static void onRegisterAttributes(EntityAttributeCreationEvent event)
    {   event.put(EntityInit.LITHICAN.get(), LithicanEntity.createAttributes().build());
        event.put(EntityInit.REVENANT.get(), RevenantEntity.createAttributes().build());
    }
}
