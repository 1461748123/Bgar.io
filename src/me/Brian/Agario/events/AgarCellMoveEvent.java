package me.Brian.Agario.events;

import java.util.List;
import java.util.Map;

import me.Brian.Agario.cell.AgarCell;
import me.Brian.Agario.manager.AgarCellManager;
import me.Brian.Agario.util.SlimeUtil;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AgarCellMoveEvent extends Event implements Cancellable {
	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled;

	public AgarCellMoveEvent() {
		for (Map.Entry<Player, List<AgarCell>> entry : AgarCellManager.getEntry()) {
			Player player = entry.getKey();
			List<AgarCell> agarcells = entry.getValue();
			for (AgarCell agarcell : agarcells) {
				agarcell.getBase().setVelocity(player.getLocation().getDirection().multiply(1).setY(0.0D));
			}
		}
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancel) {
		cancelled = cancel;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
