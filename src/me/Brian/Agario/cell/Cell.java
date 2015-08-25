package me.Brian.Agario.cell;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.json.JSONObject;

public class Cell {

	private static Item indicator;

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
		Cell.indicator = indicator;
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
	
	public Location getLocation(){
		return getIndicator().getLocation();
	}

}
