package net.noobonta.covilcore;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Utils {

    public static String traduzirMaterial(Material material) {
        switch (material) {
            case CARROTS:
                return "Cenoura";
            case POTATOES:
                return "Batata";
            case WHEAT:
                return "Trigo";
            case NETHER_WART:
                return "Nether Wart";
            case MELON:
                return "Melancia";
            case PUMPKIN:
                return "Abóbora";
            case COCOA_BEANS:
                return "Cacau";
            case SUGAR_CANE:
                return "Cana-de-açúcar";
            case CACTUS:
                return "Cacto";
            case RED_MUSHROOM:
                return "Cogumelo Vermelho";
            case BROWN_MUSHROOM:
                return "Cogumelo Marrom";
            default:
                return material.name();
        }
    }

    public static Player getRandomOnlinePlayer() {
        Collection<? extends Player> onlinePlayers = Bukkit.getServer().getOnlinePlayers();
        if (onlinePlayers.isEmpty())
            return null;
        int randomIndex = ThreadLocalRandom.current().nextInt(onlinePlayers.size());
        int currentIndex = 0;
        for (Player player : onlinePlayers) {
            if (currentIndex == randomIndex)
                return player;
            currentIndex++;
        }
        return null;
    }


    public static Material randomMaterial() {
        Material[] materials = { Material.CARROTS, Material.POTATOES, Material.WHEAT, Material.NETHER_WART, Material.MELON, Material.PUMPKIN, Material.COCOA_BEANS, Material.SUGAR_CANE, Material.CACTUS, Material.RED_MUSHROOM, Material.RED_MUSHROOM };
        Random random = new Random();
        int index = random.nextInt(materials.length);
        return materials[index];
    }

    public static void StartJacobContest() {
        Material jacobsMaterial = CovilCore.jacobsMaterial;
        String result = traduzirMaterial(jacobsMaterial);
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.sendMessage("");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&l   TORNEIO DA COLHEITA!"));
            player.sendMessage("");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f  Bastião decidiu começar um concurso!"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f  Participe a maior quantidade de, &6" + result));
            player.sendMessage("");
        }
    }

    public static void StopJacobContest() {
        String input = CovilCore.jacobsMaterial.name();
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.sendMessage("");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&l    TORNEIO DA COLHEITA!"));
            player.sendMessage("");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f  O Concurso do Bastião terminou!"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f  Os prêmios foram entregues =D"));
            player.sendMessage("");
        }
    }


}