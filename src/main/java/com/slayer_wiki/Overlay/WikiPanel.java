package com.slayer_wiki.Overlay;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.api.VarPlayer;
import net.runelite.client.util.QuantityFormatter;

import javax.inject.Inject;
import java.awt.*;

public class WikiPanel extends Overlay {
    private final PanelComponent panelComponent = new PanelComponent();

    int atkVar = VarPlayer.ATTACK_STYLE;
    @Override
    public Dimension render(Graphics2D graphics2D) {
        panelComponent.getChildren().clear();
        String overlayTitle = "Wiki info:";

        panelComponent.getChildren().add(TitleComponent.builder()
                .text(overlayTitle)
                .color(Color.BLUE)
                .build());

        panelComponent.getChildren().add(LineComponent.builder()
                .left("slayer task")
                .right(String.valueOf(atkVar))
                .build());

        panelComponent.setPreferredSize(new Dimension(100,100));


        return panelComponent.render(graphics2D);
    }
}
