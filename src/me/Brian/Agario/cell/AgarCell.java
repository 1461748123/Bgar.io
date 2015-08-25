package me.Brian.Agario.cell;

import java.util.ArrayList;
import java.util.List;

import me.Brian.Agario.util.SlimeUtil;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MiscDisguise;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import me.libraryaddict.disguise.disguisetypes.watchers.DroppedItemWatcher;
import me.libraryaddict.disguise.disguisetypes.watchers.SlimeWatcher;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.json.JSONObject;

public class AgarCell extends Cell {

	private ArmorStand base;
	private List<ArmorStand> supports = new ArrayList<ArmorStand>();

	public AgarCell(Player player, int mass, Location location) {

		super(mass, location);
		setType("agarcell");

		ArmorStand base = (ArmorStand) location.getWorld().spawn(location, ArmorStand.class);
		base.setVisible(false);

		base.setPassenger(getIndicator());

		for (int i = 0; i < 7; i++) {
			ArmorStand support = (ArmorStand) location.getWorld().spawn(location, ArmorStand.class);
			support.setVisible(false);

			supports.add(support);

			if (i == 0) {
				getIndicator().setPassenger(support);
			} else {
				supports.get(i - 1).setPassenger(support);
			}
		}

		supports.get(0).setCustomName("§l" + mass);
		supports.get(0).setCustomNameVisible(true);
		MiscDisguise basedisguise = new MiscDisguise(DisguiseType.DROPPED_ITEM);
		DroppedItemWatcher basewatcher = (DroppedItemWatcher) basedisguise.getWatcher();
		basewatcher.setItemStack(new ItemStack(Material.SLIME_BALL));
		DisguiseAPI.disguiseToAll(base, basedisguise);

		MobDisguise playdisguise = new MobDisguise(DisguiseType.SLIME);
		SlimeWatcher playwatcher = (SlimeWatcher) playdisguise.getWatcher();
		playwatcher.setSize(SlimeUtil.getSize(mass));
		DisguiseAPI.disguiseToAll(getIndicator(), playdisguise);

		setPlayer(player);
		setBase(base);
		setSupports(supports);

		supports.get(supports.size() - 1).setPassenger(player);
	}

	public AgarCell(Cell cell, Location location) {
		super(cell.getMass(), location);
		JSONObject jsonobj = new JSONObject(cell.getIndicator().getCustomName());
		new AgarCell(Bukkit.getPlayerExact(jsonobj.getString("player")), jsonobj.getInt("mass"), location);
	}

	public Player getPlayer() {
		JSONObject jsonobj = new JSONObject(getIndicator().getCustomName());
		return Bukkit.getPlayerExact(jsonobj.getString("player"));
	}

	public void setPlayer(Player player) {
		getIndicator().setCustomName(new JSONObject(getIndicator().getCustomName()).put("player", player.getName()).toString());
	}

	public ArmorStand getBase() {
		return base;
	}

	public void setBase(ArmorStand base) {
		this.base = base;
	}

	public List<ArmorStand> getSupports() {
		return supports;
	}

	public void setSupports(List<ArmorStand> supports) {
		this.supports = supports;
	}

}
