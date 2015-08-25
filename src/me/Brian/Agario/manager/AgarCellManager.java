package me.Brian.Agario.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import me.Brian.Agario.cell.AgarCell;

import org.bukkit.entity.Player;

public class AgarCellManager {
	private static Map<Player, List<AgarCell>> agarcells = new HashMap<Player, List<AgarCell>>();

	public static Set<Entry<Player, List<AgarCell>>> getEntry() {
		return agarcells.entrySet();
	}

	public static List<AgarCell> getCells(Player player) {
		return agarcells.get(player);
	}

	public static void addCell(AgarCell cell) {
		Player player = cell.getPlayer();
		if (agarcells.containsKey(player)) {
			List<AgarCell> cells = agarcells.get(player);
			cells.add(cell);
			agarcells.put(player, cells);
		} else {
			List<AgarCell> cells = new ArrayList<AgarCell>();
			cells.add(cell);
			agarcells.put(player, cells);
		}
	}

	public static void addCells(List<AgarCell> cells) {
		Player player = cells.get(0).getPlayer();
		if (agarcells.containsKey(player)) {
			cells.addAll(agarcells.get(player));
			agarcells.put(player, cells);
		} else {
			agarcells.put(player, cells);
		}
	}
}
