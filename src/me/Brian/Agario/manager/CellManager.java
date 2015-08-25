package me.Brian.Agario.manager;

import java.util.HashMap;
import java.util.Map;

import me.Brian.Agario.cell.Cell;

import org.bukkit.entity.Item;

public class CellManager {
	private static Map<Item, Cell> cells = new HashMap<Item, Cell>();

	public static Cell getCell(Item indicator) {
		return cells.get(indicator);
	}

	public static void addCell(Cell cell) {
		cells.put(cell.getIndicator(), cell);
	}
}
