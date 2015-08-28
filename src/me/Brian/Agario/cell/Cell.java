package me.Brian.Agario.cell;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.json.JSONObject;

public abstract class Cell {

	private Item indicator;

	public abstract boolean isCollision(Cell otherCell);

	//
	// public abstract void eat(Cell otherCell);

	public Cell(int mass, Location location) {
		location.setPitch(0f);
		location.setYaw(0f);
		Item indicator = location.getWorld().dropItem(location, new ItemStack(Material.SLIME_BALL));
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("type", "cell");
		jsonobj.put("mass", mass);
		indicator.setCustomName(jsonobj.toString());
		setIndicator(indicator);
	}

	public Item getIndicator() {
		return indicator;
	}

	public void setIndicator(Item indicator) {
		this.indicator = indicator;
	}

	public String getType() {
		return new JSONObject(getIndicator().getCustomName()).getString("type");
	}

	public void setType(String type) {
		getIndicator().setCustomName(new JSONObject(getIndicator().getCustomName()).put("type", type).toString());
	}

	public int getMass() {
		return new JSONObject(getIndicator().getCustomName()).getInt("mass");
	}

	public void setMass(int mass) {
		getIndicator().setCustomName(new JSONObject(getIndicator().getCustomName()).put("mass", mass).toString());
	}

	public Location getLocation() {
		return getIndicator().getLocation();
	}

	public static Cell getMax(Cell cell1, Cell cell2) {
		return (cell1.getMass() >= cell2.getMass()) ? cell1 : cell2;
	}

	public static Cell getMin(Cell cell1, Cell cell2) {
		return (cell1.getMass() <= cell2.getMass()) ? cell1 : cell2;
	}
}
