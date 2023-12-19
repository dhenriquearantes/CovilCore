package net.noobonta.covilcore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class JacobsContest implements Listener {
    public static HashMap<Player, Integer> blocksBroken = new HashMap<>();

    public static List<Player> playerList = new ArrayList<>();

    @EventHandler
    public void addPoints(BlockBreakEvent e) {
        if (CovilCore.jacobContestActive) {
            Material blockType = e.getBlock().getType();
            if (blockType.equals(CovilCore.jacobsMaterial)) {
                BlockData blockData = e.getBlock().getBlockData();
                if (blockData instanceof Ageable) {
                    Ageable ageable = (Ageable)blockData;
                    if (ageable.getAge() == ageable.getMaximumAge()) {
                        Player player = e.getPlayer();
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "tab scoreboard show jacobboard " + player.getDisplayName());
                        if (!playerList.contains(player))
                            playerList.add(player);
                        if (blocksBroken.containsKey(player)) {
                            int currentPoints = ((Integer)blocksBroken.get(player)).intValue();
                            blocksBroken.put(player, Integer.valueOf(currentPoints + 1));
                        } else {
                            blocksBroken.put(player, Integer.valueOf(1));
                        }
                    }
                } else {
                    Player player = e.getPlayer();
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "tab scoreboard show jacobboard " + player.getDisplayName());
                    if (!playerList.contains(player))
                        playerList.add(player);
                    if (blocksBroken.containsKey(player)) {
                        int currentPoints = ((Integer)blocksBroken.get(player)).intValue();
                        blocksBroken.put(player, Integer.valueOf(currentPoints + 1));
                    } else {
                        blocksBroken.put(player, Integer.valueOf(1));
                    }
                }
            }
        }
    }

    public static int getPlayerPosition(Player player) {
        List<Map.Entry<Player, Integer>> entries = new ArrayList<>(blocksBroken.entrySet());
        entries.sort((Comparator)Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<Player, Integer> entry = entries.get(i);
            if (((Player)entry.getKey()).equals(player))
                return i + 1;
        }
        return -1;
    }

    public static void giveOutRewards(Player player) {
        int position = getPlayerPosition(player);
        FileConfiguration config = CovilCore.plugin.getConfig();
        if (position == 1) {
            String command1 = config.getString("first-place.command1").replace("%player%", player.getName());
            String command2 = config.getString("first-place.command2").replace("%player%", player.getName());
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), command1);
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), command2);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aVocê ficou em 1º lugar! Bastião agradece a você por participar!"));
        } else if (position == 2) {
            String command1 = config.getString("second-place.command1").replace("%player%", player.getName());
            String command2 = config.getString("second-place.command2").replace("%player%", player.getName());
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), command1);
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), command2);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aVocê ficou em 2º lugar! Bastião agradece a você por participar!"));
        } else if (position == 3) {
            String command1 = config.getString("third-place.command1").replace("%player%", player.getName());
            String command2 = config.getString("third-place.command2").replace("%player%", player.getName());
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), command1);
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), command2);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aVocê ficou em 3º lugar! Bastião agradece a você por participar!"));
        } else {
            String command1 = config.getString("participation.command1").replace("%player%", player.getName());
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), command1);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aBastião agradece a você por participar! Tente novamente da próxima vez para uma medalha!"));
        }
    }
}
