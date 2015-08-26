package me.Brian.Agario;

import me.Brian.Agario.cell.AgarCell;
import me.Brian.Agario.cell.Cell;
import me.Brian.Agario.cell.PelletCell;
import me.Brian.Agario.listeners.ItemMergeListener;
import me.Brian.Agario.manager.AgarCellManager;
import me.Brian.Agario.manager.CellManager;
import me.Brian.Agario.util.MainScheduler;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Agario extends JavaPlugin implements Listener {

	private static Plugin plugin;
	public static Thread thread;
	Location defaultl;
	public static Location location;
	
	public static Item indicator;

	Slime slimeleft;
	Slime slimeright = null;

	// Item am = null;

	public void onEnable() {
		plugin = this;
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new ItemMergeListener(), this);
		final long timeInterval = 100;
		MainScheduler.startScheduler();

		Runnable runnable = new Runnable() {
			public void run() {
				while (true) {
					// ------- code for task to run

					// if (am != null)
					// am.setVelocity(Bukkit.getPlayer("030").getLocation().getDirection().multiply(1).setY(0.0D));
					// for (AgarCell cell : agarcells) {
					// cell.getBasecell().setVelocity(cell.getPlayer().getLocation().getDirection().multiply(1).setY(0.0D));
					// // // ((Entity) entity).setVelocity(((Player) map.get(entity)).getLocation().getDirection().multiply(1).setY(0.0D));
					//
					// }
					// if (slimeright != null) {
					// Bukkit.getWorld("world").playEffect(SlimeSizeUtil.getSlimeConer(slimeright), Effect.COLOURED_DUST, 5);
					// Bukkit.getWorld("world").playEffect(SlimeSizeUtil.getSlimeConer(slimeright), Effect.COLOURED_DUST, 5);
					// Bukkit.getWorld("world").playEffect(SlimeSizeUtil.getSlimeConer(slimeright), Effect.COLOURED_DUST, 5);
					// Bukkit.getWorld("world").playEffect(SlimeSizeUtil.getSlimeConer(slimeright), Effect.COLOURED_DUST, 5);
					// Bukkit.getWorld("world").playEffect(SlimeSizeUtil.getSlimeConer(slimeright), Effect.COLOURED_DUST, 5);
					// Bukkit.getWorld("world").playEffect(SlimeSizeUtil.getSlimeConer(slimeright), Effect.COLOURED_DUST, 5);
					// }
					// System.out.print("wtf");

					// ------- ends here
					try {
						Thread.sleep(timeInterval);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread = new Thread(runnable);
		thread.start();
	}

	// @EventHandler
	// public void onPlayerDamageEntity(EntityDamageByEntityEvent event) {
	// if (event.getDamager().getType() == EntityType.PLAYER && event.getEntity().getType() == EntityType.SLIME)e
	// slimeleft = (Slime) event.getEntity();
	// event.setCancelled(true);
	// }

	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractAtEntityEvent event) {
		if (event.getRightClicked().getType() == EntityType.ARMOR_STAND)
			defaultl = event.getRightClicked().getLocation();
			location = event.getRightClicked().getLocation();

	}

	public static Plugin getInstance() {
		return plugin;
	}

	// @EventHandler
	// public void onItemMerge(ItemMergeEvent event) {
	// event.setCancelled(true);
	// }

	@EventHandler
	public void onEntitySpawn() {

	}

	@SuppressWarnings("deprecation")
	public void onDisable() {
		thread.stop();
	}

	public boolean onCommand(CommandSender s, Command cmd, String Label, String[] args) {
		if (s instanceof Player) {
			Player player = (Player) s;

			if (cmd.getName().equalsIgnoreCase("clean")) {
				for (Entity entity : player.getLocation().getWorld().getEntities()) {
					if (!(entity instanceof Player)) {
						entity.remove();
					}
				}
				return true;
			} else if (cmd.getName().equalsIgnoreCase("debug")) {
				if (args[0].equalsIgnoreCase("spawn")) {
					PelletCell fc = new PelletCell(player.getLocation());
					CellManager.addCell(fc);
					indicator = fc.getIndicator();
//					CellManager.addCell(new AgarCell(player, Integer.parseInt(args[1]), player.getLocation()));
				} else if (args[0].equalsIgnoreCase("add")) {
					if (args.length == 1) {
						location = player.getLocation();
						location.setPitch(0f);
						location.setYaw(0f);
						ArmorStand am = (ArmorStand) player.getLocation().getWorld().spawn(location, ArmorStand.class);
						am.setItemInHand(new ItemStack(Material.SLIME_BLOCK));
						am.setArms(true);
						location = am.getLocation();
						location.setX(location.getX() -0.5);
						location.setZ(location.getZ() +0.5);

					} else {
						switch (args[1]) {
						case "x":
							location.setX(location.getX() + Double.parseDouble(args[2]));
							break;
						case "y":
							location.setY(location.getY() + Double.parseDouble(args[2]));
							break;
						case "z":
							location.setZ(location.getZ() + Double.parseDouble(args[2]));
							break;
						default:
							player.sendMessage("X: " + (location.getX() - defaultl.getX()));
							player.sendMessage("Y: " + (location.getY() - defaultl.getY()));
							player.sendMessage("Z: " + (location.getZ() - defaultl.getZ()));
							break;
						}
					}
				}
				return true;

			}
			if (args.length == 0) {
				// AgarCell ac = new AgarCell(player, 3001, player.getLocation());
				// CellManager.addCell(ac);

				new PelletCell(player.getLocation());

				// DisguiseAPI.disguiseToAll(item, mobDisguise);
				// this.am = item;
				// player.sendMessage("" + player.getLocation().getX());
				// player.sendMessage("" + player.getLocation().getY());
				// player.sendMessage("" + player.getLocation().getZ());
				//
				// player.teleport(new Location(player.getWorld(), player.getLocation().getBlockX() + 0.5, player.getLocation().getY(), player.getLocation().getBlockZ() + 0.5));
				// SlimeSizeUtil.getSlimeLeftUpConer(slimeright).getBlock().setType(Material.GLASS);
				// player.sendMessage("用左键单击的史莱姆作为点: "
				// + isCollsion(slimeleft.getLocation().getX(), slimeleft.getLocation().getZ(), SlimeSizeUtil.getSlimeConer(slimeright).getX(), SlimeSizeUtil.getSlimeConer(slimeright).getZ(),
				// slimeright.getSize() * 0.5, slimeright.getSize() * 0.5));
				//
				// player.sendMessage("用右边键单击的史莱姆作为点: "
				// + isCollsion(slimeright.getLocation().getX(), slimeright.getLocation().getZ(), SlimeSizeUtil.getSlimeConer(slimeleft).getX(), SlimeSizeUtil.getSlimeConer(slimeleft).getZ(),
				// slimeleft.getSize() * 0.5, slimeleft.getSize() * 0.5));

				// player.sendMessage("用左键单击的史莱姆作为点: " + isCollsion(slimeleft.getLocation(), SlimeSizeUtil.getSlimeLeftUpConer(slimeright), SlimeSizeUtil.getSlimeRightDownConer(slimeright)));
				// player.sendMessage("用右键单击的史莱姆作为点: " + isCollsion(slimeright.getLocation(), SlimeSizeUtil.getSlimeLeftUpConer(slimeleft), SlimeSizeUtil.getSlimeRightDownConer(slimeleft)));
				// agarcells.add(new AgarCell(player, player.getLocation(), 1, 7));
			} else if (args.length == 1) {
				AgarCell ac = new AgarCell(player, Integer.parseInt(args[0]), player.getLocation());
				AgarCellManager.addCell(ac);
				CellManager.addCell(ac);
				player.sendMessage((ac instanceof Cell) + "");
				player.sendMessage(ac.getIndicator().getCustomName());
				player.sendMessage(ac.getPlayer().getName());
				player.sendMessage(ac.getMass() + "");

				// Location location = new Location(player.getWorld(), player.getLocation().getBlockX(), player.getLocation().getBlockY() - 2, player.getLocation().getBlockZ());
				// Item item = player.getWorld().dropItem(location, new ItemStack(Material.SLIME_BALL));
				// item.setVelocity(player.getLocation().getDirection().multiply(1).setY(0.0D));
			} else {
				
				// player.teleport(ces.getBukkitEntity().getLocation());
				// ces.getBukkitEntity().teleport(new Location(player.getWorld(), player.getLocation().getBlockX() + 0.5, player.getLocation().getY()-2, player.getLocation().getBlockZ() + 0.5));
			}

		}
		return true;
	}

	public static boolean isCollsion(Location point, Location rec1, Location rec2) {
		double maxX = Math.max(rec1.getX(), rec2.getX());
		double minX = Math.min(rec1.getX(), rec2.getX());

		double maxZ = Math.max(rec1.getZ(), rec2.getZ());
		double minZ = Math.min(rec1.getZ(), rec2.getZ());

		double x = point.getX();
		double z = point.getZ();

		return (x > minX && x < maxX && z > minZ && z < maxZ);

	}

}
