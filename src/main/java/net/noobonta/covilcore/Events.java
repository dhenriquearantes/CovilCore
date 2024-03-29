package net.noobonta.covilcore;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.EulerAngle;

import java.util.UUID;

public class Events implements Listener {

    @EventHandler
    public void stopItemFrameRotation(PlayerInteractEvent event) {
        if (event.getAction() == Action.LEFT_CLICK_BLOCK &&
                event.getClickedBlock().getType() == Material.ITEM_FRAME && event.getPlayer().getWorld().getName().equals("Vila"))
            event.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity().getType() == EntityType.ITEM_FRAME && event
                .getEntity().getWorld().getName().equals("Vila") && event
                .getDamager().getType() == EntityType.PLAYER && (
                (Player)event.getDamager()).getGameMode() != GameMode.CREATIVE)
            event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (event.getRightClicked().getType() == EntityType.ITEM_FRAME && event.getPlayer().getWorld().getName().equals("Vila") &&
                event.getPlayer().getGameMode() != GameMode.CREATIVE)
            event.setCancelled(true);
    }

    @EventHandler
    public void onPortalEntrance(PlayerPortalEvent e) {
        if (e.getPlayer().getLocation().getWorld().getName().equals("Vila"))
            e.setCancelled(true);
    }

    @EventHandler
    public void onPlaceArmorStand(EntitySpawnEvent e) {
        Entity ent = e.getEntity();
        if (ent instanceof ArmorStand) {
            FileConfiguration config = CovilCore.plugin.getConfig();
            if (config.getBoolean("experience-ores") == true) {
                ArmorStand armorStand = (ArmorStand)ent;
                Location loc = armorStand.getLocation();
                loc.setYaw(armorStand.getLocation().getYaw() + 180.0F);
                armorStand.teleport(loc);
                armorStand.setBasePlate(false);
                armorStand.setArms(true);
                armorStand.setBodyPose(new EulerAngle(Math.toRadians(4.0D), Math.toRadians(178.0D), Math.toRadians(360.0D)));
                armorStand.setHeadPose(new EulerAngle(Math.toRadians(40.0D), Math.toRadians(180.0D), Math.toRadians(0.0D)));
                armorStand.setLeftLegPose(new EulerAngle(Math.toRadians(0.0D), Math.toRadians(0.0D), Math.toRadians(360.0D)));
                armorStand.setRightLegPose(new EulerAngle(Math.toRadians(0.0D), Math.toRadians(0.0D), Math.toRadians(360.0D)));
                armorStand.setLeftArmPose(new EulerAngle(Math.toRadians(51.0D), Math.toRadians(328.0D), Math.toRadians(360.0D)));
                armorStand.setRightArmPose(new EulerAngle(Math.toRadians(48.0D), Math.toRadians(34.0D), Math.toRadians(0.0D)));
            }
        }
    }


    @EventHandler
    public void onBlockFade(BlockFadeEvent event) {
        Block block = event.getBlock();
        World world = block.getWorld();

        if (world.getName().equalsIgnoreCase("Vila") && block.getType() == Material.FARMLAND) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player &&
                e.getCause() == EntityDamageEvent.DamageCause.VOID) {
            e.setCancelled(true);
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "cmi spawn " + ((Player)e.getEntity()).getPlayer().getDisplayName() + " -s");
        }
    }


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.PHYSICAL) {
            if (event.getClickedBlock() != null && event.getClickedBlock().getType() == Material.FARMLAND) {
                World world = event.getPlayer().getWorld();
                if (world.getName().equalsIgnoreCase("Vila")) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
