package thecudster.sre.features.impl.rendering;

import java.awt.TextComponent;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thecudster.sre.SkyblockReinvented;
import thecudster.sre.settings.Config;
import thecudster.sre.util.ScoreboardUtil;

public class WitherCloakHider {
	/**
     * Modified from Skytils under GNU Affero General Public license.
     * https://github.com/Skytils/SkytilsMod/blob/main/LICENSE
     */
	@SubscribeEvent(receiveCanceled = true, priority = EventPriority.HIGHEST)
	public void onCheckRender(RenderLivingEvent.Pre<EntityCreeper> event) {
		
		if (!(event.entity instanceof EntityCreeper)) { return; }
		EntityCreeper creeperEntity = (EntityCreeper) event.entity;
		EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
		List<String> scoreboard = ScoreboardUtil.getSidebarLines();
		for (String s : scoreboard) {
			ScoreboardUtil.cleanSB(s);
			if (s.contains("Dwarven Mines") || s.contains("The Mist")) {
				return;
			}
		}
		if (event.entity.getDistance(player.posX, player.posY, player.posZ) <= 5) { return; }
		
			if (creeperEntity instanceof EntityCreeper && SkyblockReinvented.config.renderCreepers && creeperEntity.getPowered()) {
				event.setCanceled(true);
			}
		
		
	}
}
