package thecudster.sre.features.impls.sounds;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.S29PacketSoundEffect;
import net.minecraft.scoreboard.Score;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thecudster.sre.SkyblockReinvented;
import thecudster.sre.events.ReceivePacketEvent;
import thecudster.sre.features.impl.filter.FilterHandler;
import thecudster.sre.util.ItemUtil;

/*
 * Modified from Skytils under GNU Affero Public License.
 * https://github.com/Skytils/SkytilsMod/blob/main/LICENSE
 * @author My-Name-Is-Jeff
 * @author Sychic
 */
public class BlockCreeperSound {
	@SubscribeEvent(receiveCanceled=true)
	public void onReceivePacket(ReceivePacketEvent event) {
		if (event.packet instanceof S29PacketSoundEffect) {
		S29PacketSoundEffect packet = (S29PacketSoundEffect) event.packet;
		if (SkyblockReinvented.config.creeperSounds) {
			if (packet.getSoundName().equals("mob.creeper.say") && FilterHandler.witherCloak) {
				event.setCanceled(true);
			}
			if (packet.getSoundName().equals("mob.skeleton.hurt") && FilterHandler.witherCloak) {
				event.setCanceled(true);
			}
		}
		if (SkyblockReinvented.config.jerryChine) {
			if (Minecraft.getMinecraft().thePlayer.getHeldItem() != null) {
				if (ItemUtil.getSkyBlockItemID(Minecraft.getMinecraft().thePlayer.getHeldItem()) != null) {
					if (ItemUtil.getSkyBlockItemID(Minecraft.getMinecraft().thePlayer.getHeldItem()).equals("JERRY_STAFF")) {
						if (packet.getSoundName().equals("mob.villager.haggle")) {
							event.setCanceled(true);
							return;
						}
						if (packet.getSoundName().equals("mob.villager.yes")) {
							event.setCanceled(true);
							return;
						}
					}
				}
			}

		}
		}
	}
}
