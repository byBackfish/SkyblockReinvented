/*
 * SkyblockReinvented - Hypixel Skyblock Improvement Modification for Minecraft
 * Copyright (C) 2021 theCudster
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package thecudster.sre.features.impl.dungeons;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thecudster.sre.SkyblockReinvented;
import thecudster.sre.events.GuiContainerEvent;
import thecudster.sre.util.ItemUtil;
import thecudster.sre.util.Utils;
/*
 * Modified from Skytils under GNU Affero Public license.
 * https://github.com/Skytils/SkytilsMod/blob/main/LICENSE
 * @author My-Name-Is-Jeff
 * @author Sychic
 */
public class LockMort {
    public String supposedName;
	@SubscribeEvent(receiveCanceled = true)
    public void onSlotClick(GuiContainerEvent.SlotClickEvent event) {
        // if (!Utils.inSkyblock) return;
		
        if (event.container instanceof ContainerChest) {
            ContainerChest chest = (ContainerChest) event.container;

            IInventory inventory = chest.getLowerChestInventory();
            Slot slot = event.slot;
            if (slot == null) return;
            ItemStack item = slot.getStack();
            String inventoryName = inventory.getDisplayName().getUnformattedText();
            if (item != null) {
                if (item.hasDisplayName()) {
                    String itemName = item.getDisplayName();

                    NBTTagCompound extraAttributes = ItemUtil.getExtraAttributes(item);

                    if (inventoryName.equals("Catacombs Gate")) {
                        if (SkyblockReinvented.config.floorLock > 0) {
                            if (slot.inventory == Minecraft.getMinecraft().thePlayer.inventory || slot.slotNumber == 50 || slot.slotNumber == 49 || slot.slotNumber == 48 || slot.slotNumber == 47)
                                return;
                            switch (SkyblockReinvented.config.floorLock) {
                                case 1:
                                    supposedName = "§aThe Catacombs §8- §eFloor I";
                                    break;
                                case 2:
                                    supposedName = "§aThe Catacombs §8- §eFloor II";
                                    break;
                                case 3:
                                    supposedName = "§aThe Catacombs §8- §eFloor III";
                                    break;
                                case 4:
                                    supposedName = "§aThe Catacombs §8- §eFloor IV";
                                    break;
                                case 5:
                                    supposedName = "§aThe Catacombs §8- §eFloor V";
                                    break;
                                case 6:
                                    supposedName = "§aThe Catacombs §8- §eFloor VI";
                                    break;
                                case 7:
                                    supposedName = "§aThe Catacombs §8- §eFloor VII";
                                    break;
                                default:
                                    supposedName = "Floor Null";
                                    break;
                            }
                            if (item.getItem() != Items.skull || !(itemName.equals(supposedName))) {
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
