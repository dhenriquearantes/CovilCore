package net.noobonta.covilcore;

import io.lumine.mythic.bukkit.utils.lib.jooq.Case;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class PlaceholderRegister extends PlaceholderExpansion {
    private CovilCore plugin;

    public PlaceholderRegister(CovilCore plugin) {
        this.plugin = plugin;
    }

    public boolean persist() {
        return true;
    }

    public boolean canRegister() {
        return true;
    }

    public String getAuthor() {
        return this.plugin.getDescription().getAuthors().toString();
    }

    public String getIdentifier() {
        return "covilcore";
    }

    public String getVersion() {
        return this.plugin.getDescription().getVersion();
    }
    public String traduzirMaterial(Material material) {
        switch (material) {
            case CARROTS:
                return "Cenoura";
            case POTATOES:
                return "Batata";
            case WHEAT:
                return "Trigo";
            case NETHER_WART:
                return "Fungo do Nether";
            case MELON:
                return "Melancia";
            case PUMPKIN:
                return "Abóbora";
            case COCOA_BEANS:
                return "Cacau";
            case SUGAR_CANE:
                return "Cana de Açucar";
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
    public String onPlaceholderRequest(Player player, String identifier) {
        if (player == null)
            return "";

        if (identifier.equals("material")) {
            Material jacobsMaterial = CovilCore.jacobsMaterial;
            String traducao = traduzirMaterial(jacobsMaterial);
            return traducao;
        }
        if (identifier.equals("count")) {
            int blocksBroken = JacobsContest.blocksBroken.getOrDefault(player, 0);
            if (blocksBroken > 0) {
                return String.valueOf(blocksBroken);
            } else {
                return "0";
            }
        }
        if (identifier.equals("position")) {
            int position = JacobsContest.getPlayerPosition(player);
            if (position == -1) {
                return "0";
            } else {
                return String.valueOf(position);
            }
        }

        return "No Value";
    }
}
