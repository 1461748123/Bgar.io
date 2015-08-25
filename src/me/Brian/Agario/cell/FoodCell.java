package me.Brian.Agario.cell;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import me.libraryaddict.disguise.disguisetypes.watchers.ArmorStandWatcher;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class FoodCell extends Cell{
	
	public FoodCell(Location location){
		
		super(1, location);
		setType("foodcell");
		
		location = new Location(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ(), 180f, 0f);
		
		MobDisguise asdisguise = new MobDisguise(DisguiseType.ARMOR_STAND);
		ArmorStandWatcher amwatcher = (ArmorStandWatcher) asdisguise.getWatcher();
		amwatcher.setItemInHand(new ItemStack(Material.SLIME_BLOCK));
		
		DisguiseAPI.disguiseToAll(getIndicator(), asdisguise);
		getIndicator().teleport(location);
	}
	
	public Location getLocation(){
		Location location = getIndicator().getLocation();
		location.setX(location.getX() -0.5);
		location.setZ(location.getZ() +0.5);
		return location;
	}

}
