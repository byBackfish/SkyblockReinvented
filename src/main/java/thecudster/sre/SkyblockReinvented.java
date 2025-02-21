package thecudster.sre;


import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import thecudster.sre.commands.*;
import thecudster.sre.commands.dungfloors.Floor1;
import thecudster.sre.commands.dungfloors.Floor2;
import thecudster.sre.commands.dungfloors.Floor3;
import thecudster.sre.commands.dungfloors.Floor4;
import thecudster.sre.commands.dungfloors.Floor5;
import thecudster.sre.commands.dungfloors.Floor6;
import thecudster.sre.commands.dungfloors.Floor7;
import thecudster.sre.features.impl.dungeons.LockMort;
import thecudster.sre.features.impl.filter.FilterHandler;
import thecudster.sre.events.Keybindings;
import thecudster.sre.features.impl.qol.GhostLoot;
import thecudster.sre.features.impl.qol.HighlightFarming;
import thecudster.sre.features.impl.qol.ItemDropStop;
import thecudster.sre.features.impl.qol.MiscFarming;
import thecudster.sre.features.impl.rendering.*;
import thecudster.sre.features.impls.sounds.BlockCreeperSound;
import thecudster.sre.settings.Config;
import thecudster.sre.util.GuiManager;
import thecudster.sre.util.LootTracker;

@Mod(modid = SkyblockReinvented.MODID, name = SkyblockReinvented.MOD_NAME, version = SkyblockReinvented.VERSION, acceptedMinecraftVersions = "[1.8.9]", clientSideOnly = true)
public class SkyblockReinvented {
	public static Config config = new Config();
	public static final String MODID = "sre";
	public static final String MOD_NAME = "SkyblockReinvented";
	public static final String VERSION = "0.0.5";
	public static KeyBinding[] keyBindings = new KeyBinding[3];
	public static boolean creeperActivated;
	public static File modDir;
	public static boolean foundSB;
	public static GuiManager GUIMANAGER;
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		modDir = new File(event.getModConfigurationDirectory(), "sre");
		// GetSkyBlockAuctionsExample.printAuctions(0);
        if (!modDir.exists()) modDir.mkdirs();
        GUIMANAGER = new GuiManager();
		
	}
	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("initialized");
		
		ModCoreInstaller.initializeModCore(Minecraft.getMinecraft().mcDataDir);

        config.preload();
		ClientCommandHandler.instance.registerCommand(new SRECommand());
		ClientCommandHandler.instance.registerCommand(new SBCommand());
		ClientCommandHandler.instance.registerCommand(new Floor1());
		ClientCommandHandler.instance.registerCommand(new Floor2());
		ClientCommandHandler.instance.registerCommand(new Floor3());
		ClientCommandHandler.instance.registerCommand(new Floor4());
		ClientCommandHandler.instance.registerCommand(new Floor5());
		ClientCommandHandler.instance.registerCommand(new Floor6());
		ClientCommandHandler.instance.registerCommand(new Floor7());
		ClientCommandHandler.instance.registerCommand(new SBToggle());
		ClientCommandHandler.instance.registerCommand(new AddItem());
		ClientCommandHandler.instance.registerCommand(new Rendering());
		ClientCommandHandler.instance.registerCommand(new JoinDung());
		ClientCommandHandler.instance.registerCommand(new FragRun());

		MinecraftForge.EVENT_BUS.register(new RemoveRaffleTitles());
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new FilterHandler());
		MinecraftForge.EVENT_BUS.register(new PlayerHider());
		MinecraftForge.EVENT_BUS.register(new ItemDropStop());
		MinecraftForge.EVENT_BUS.register(new MiscWaypoints());
		MinecraftForge.EVENT_BUS.register(new BlockPowerOrb());
		MinecraftForge.EVENT_BUS.register(new WitherCloakHider());
		MinecraftForge.EVENT_BUS.register(new RemoveVillagers());
		MinecraftForge.EVENT_BUS.register(new DeleteOwnSpiritBats());
		MinecraftForge.EVENT_BUS.register(new HyperionOverlay());
		MinecraftForge.EVENT_BUS.register(new MiscFarming());
		MinecraftForge.EVENT_BUS.register(new BlockCreeperSound());
		MinecraftForge.EVENT_BUS.register(new Keybindings());
		MinecraftForge.EVENT_BUS.register(new LockMort());
		MinecraftForge.EVENT_BUS.register(new SlayerOverlays());
		MinecraftForge.EVENT_BUS.register(new HighlightFarming());
		MinecraftForge.EVENT_BUS.register(new SkeletonMasterReminder());
		MinecraftForge.EVENT_BUS.register(new GhostLoot());
		MinecraftForge.EVENT_BUS.register(new LootTracker());
		MinecraftForge.EVENT_BUS.register(GUIMANAGER);
		keyBindings[0] = new KeyBinding("Open Bazaar", Keyboard.KEY_B, "SkyblockReinvented");
		keyBindings[1] = new KeyBinding("Open AH", Keyboard.KEY_H, "SkyblockReinvented");
		keyBindings[2] = new KeyBinding("Open PRTL", Keyboard.KEY_P, "SkyblockReinvented");
		for (KeyBinding keyBinding : keyBindings) {
			ClientRegistry.registerKeyBinding(keyBinding);
		}
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
	@EventHandler
	public void serverInit(FMLServerStartingEvent event) {
		
	}
	@EventHandler
	public void serverClose(FMLServerStoppingEvent event) {
		
	}

	
}
