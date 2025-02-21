package thecudster.sre.features.impl.rendering;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thecudster.sre.SkyblockReinvented;

public class RemoveVillagers {
    @SubscribeEvent(receiveCanceled = true, priority = EventPriority.HIGHEST)
    public void onCheckRender(RenderLivingEvent.Pre event) {
        if (event.entity.getCustomNameTag() != null) {
            if (event.entity.getCustomNameTag().contains("Jerry")) {
                event.setCanceled(true);
            }
            if (event.entity.getCustomNameTag().contains("NEW UPDATE")) {
                event.setCanceled(true);
            }
            if (event.entity.getCustomNameTag().contains("CLICK")) {
                for (Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
                    if (entity instanceof EntityVillager) {
                        if (entity.getDistanceToEntity(event.entity) <= 2) {
                            event.setCanceled(true);
                        }
                    }

                }
            }
        }

        if (!(event.entity instanceof EntityVillager)) { return; }
        EntityVillager villagerEntity = (EntityVillager) event.entity;
        for (Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
            if (entity instanceof EntityArmorStand) {
                if (entity.getCustomNameTag().contains("Jerry")) {
                    if (entity.getDistanceToEntity(villagerEntity) <= 2) {
                        event.setCanceled(true);
                    }
                }
            }

        }
    }
}
