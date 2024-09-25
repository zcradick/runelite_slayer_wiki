package com.slayer_wiki;

import com.google.inject.Provides;
import javax.inject.Inject;

import com.slayer_wiki.Overlay.WikiPanel;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Slayer Wiki Helper"
)
public class SlayerWikiHelperPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private SlayerWikiHelperConfig config;

	@Inject
	private WikiPanel overlay;

	@Inject
	private OverlayManager overlayManager;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		//log.info("Example started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		//log.info("Example stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + config.greeting(), null);
		}
	}

	@Provides
	SlayerWikiHelperConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SlayerWikiHelperConfig.class);
	}
}
