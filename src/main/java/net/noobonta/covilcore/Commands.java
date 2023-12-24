package net.noobonta.covilcore;


import java.util.Iterator;

import com.sk89q.worldedit.command.ApplyBrushCommands;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.*;
import dev.jorel.commandapi.exceptions.WrapperCommandSyntaxException;
import dev.jorel.commandapi.executors.CommandArguments;
import dev.jorel.commandapi.executors.ExecutorType;
import net.noobonta.covilcore.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SoundCategory;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands {
    public static void onCommand() {
        new CommandAPICommand("jacobscontest")
                .withArguments(
                        new TextArgument("status").replaceSuggestions(ArgumentSuggestions.strings("start", "stop")),
                        new TextArgument("material")
                )
                .withPermission(CommandPermission.OP)
                .executes((sender, args) -> {
                    String status = (String)args.get(0);
                    String material = (String)args.get(1);
                    if (status.equals("stop")) {
                        CovilCore.jacobContestActive = false;
                        Iterator<Player> iterator = JacobsContest.playerList.iterator();
                        while (iterator.hasNext()) {
                            Player player = iterator.next();
                            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "tab reload");
                            JacobsContest.giveOutRewards(player);
                            iterator.remove();
                        }
                        JacobsContest.blocksBroken.clear();
                        Utils.StopJacobContest();
                    }
                    if (status.equals("start")) {
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "tab scoreboard show jacobboard " + Utils.getRandomOnlinePlayer().getDisplayName());
                        CovilCore.jacobContestActive = true;
                        if (material.equals("random")) {
                            CovilCore.jacobsMaterial = Utils.randomMaterial();
                            Utils.StartJacobContest();
                        } else {
                            CovilCore.jacobsMaterial = Material.matchMaterial(material);
                            Utils.StartJacobContest();
                        }
                    }
                })
                .register();

        new CommandAPICommand("fairysoulexchange")
                .withArguments(
                        new TextArgument("option").replaceSuggestions(ArgumentSuggestions.strings("0", "1", "2", "3", "4"))
                )
                .withOptionalArguments(
                        new PlayerArgument("player")
                )
                .withPermission(CommandPermission.OP)
                .executes((sender, args) -> {
                    String option = (String)args.get(0);
                    Player otherPlayer = (Player) args.get("player");
                    if (option.equals("0")) {
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "levels addexp " + otherPlayer.getDisplayName() + " 1");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecobits takesilent " + otherPlayer.getDisplayName() + " souls 5 ");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecoskills give " + otherPlayer.getDisplayName() + " health 3");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecoskills give " + otherPlayer.getDisplayName() + " defense 1");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecoskills give " + otherPlayer.getDisplayName() + " strength 1");
                        otherPlayer.sendMessage("");
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aTroca realizada com sucesso! Você recebeu:"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &b+1 Covil EXP"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &c+3 ❤ Vida"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &a+1 ❈ Defesa"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &c+1 ❁ Força"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &a+0 ✦ Velocidade"));
                        otherPlayer.sendMessage("");
                    }
                    if (option.equals("1")) {
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "levels addexp " + otherPlayer.getDisplayName() + " 1");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecobits takesilent " + otherPlayer.getDisplayName() + " souls 5 ");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecoskills give " + otherPlayer.getDisplayName() + " health 4");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecoskills give " + otherPlayer.getDisplayName() + " defense 1");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecoskills give " + otherPlayer.getDisplayName() + " strength 1");
                        otherPlayer.sendMessage("");
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aTroca realizada com sucesso! Você recebeu:"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &b+1 Covil EXP"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &c+4 ❤ Vida"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &a+1 ❈ Defesa"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &c+1 ❁ Força"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &a+0 ✦ Velocidade"));
                        otherPlayer.sendMessage("");
                    }
                    if (option.equals("2")) {
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "levels addexp " + otherPlayer.getDisplayName() + " 1");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecobits takesilent " + otherPlayer.getDisplayName() + " souls 5 ");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecoskills give " + otherPlayer.getDisplayName() + " health 5");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecoskills give " + otherPlayer.getDisplayName() + " defense 2");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecoskills give " + otherPlayer.getDisplayName() + " strength 2");
                        otherPlayer.sendMessage("");
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aTroca realizada com sucesso! Você recebeu:"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &b+1 Covil EXP"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &c+5 ❤ Vida"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &a+2 ❈ Defesa"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &c+2 ❁ Força"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &a+0 ✦ Velocidade"));
                        otherPlayer.sendMessage("");
                    }
                    if (option.equals("3")) {
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "levels addexp " + otherPlayer.getDisplayName() + " 3");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecobits takesilent " + otherPlayer.getDisplayName() + " souls 5 ");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecoskills give " + otherPlayer.getDisplayName() + " health 6");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecoskills give " + otherPlayer.getDisplayName() + " defense 1");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecoskills give " + otherPlayer.getDisplayName() + " strength 1");
                        otherPlayer.sendMessage("");
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aTroca realizada com sucesso! Você recebeu:"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &b+3 Covil EXP"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &c+6 ❤ Vida"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &a+2 ❈ Defesa"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &c+2 ❁ Força"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &a+0 ✦ Velocidade"));
                        otherPlayer.sendMessage("");
                    }
                    if (option.equals("4")) {
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "levels addexp " + otherPlayer.getDisplayName() + " 3");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecobits takesilent " + otherPlayer.getDisplayName() + " souls 5 ");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecoskills give " + otherPlayer.getDisplayName() + " health 7");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecoskills give " + otherPlayer.getDisplayName() + " defense 2");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecoskills give " + otherPlayer.getDisplayName() + " strength 2");
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ecoskills give " + otherPlayer.getDisplayName() + " speed 2");
                        otherPlayer.sendMessage("");
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aTroca realizada com sucesso! Você recebeu:"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &b+2 Covil EXP"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &c+5 ❤ Vida"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &a+2 ❈ Defesa"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &c+2 ❁ Força"));
                        otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', " &a+2 ✦ Velocidade"));
                        otherPlayer.sendMessage("");
                    }
                })
                .register();
        new CommandAPICommand("questCompletionSpawnT1Zombie")
                .executes((sender, args) -> {
                    if (sender instanceof Player)
                        if (!sender.isOp()) {
                            sender.setOp(true);
                            ((Player)sender).performCommand("mm test cast -s SpawnRevenantTier1");
                            sender.setOp(false);
                        } else {
                            ((Player)sender).performCommand("mm test cast -s SpawnRevenantTier1");
                        }
                }).register();
        
        new CommandAPICommand("questCompletionSpawnT2Zombie")
                .executes((sender, args) -> {
                    if (sender instanceof Player)
                        if (!sender.isOp()) {
                            sender.setOp(true);
                            ((Player)sender).performCommand("mm test cast -s SpawnRevenantTier2");
                            sender.setOp(false);
                        } else {
                            ((Player)sender).performCommand("mm test cast -s SpawnRevenantTier2");
                        }
                }).register();

        new CommandAPICommand("questCompletionSpawnT3Zombie")
                .executes((sender, args) -> {
                    if (sender instanceof Player)
                        if (!sender.isOp()) {
                            sender.setOp(true);
                            ((Player)sender).performCommand("mm test cast -s SpawnRevenantTier3");
                            sender.setOp(false);
                        } else {
                            ((Player)sender).performCommand("mm test cast -s SpawnRevenantTier3");
                        }
                }).register();

        new CommandAPICommand("questCompletionSpawnT4Zombie")
                .executes((sender, args) -> {
                    if (sender instanceof Player)
                        if (!sender.isOp()) {
                            sender.setOp(true);
                            ((Player)sender).performCommand("mm test cast -s SpawnRevenantTier4");
                            sender.setOp(false);
                        } else {
                            ((Player)sender).performCommand("mm test cast -s SpawnRevenantTier4");
                        }
                }).register();
        new CommandAPICommand("questCompletionSpawnT5Zombie")
                .executes((sender, args) -> {
                    if (sender instanceof Player)
                        if (!sender.isOp()) {
                            sender.setOp(true);
                            ((Player)sender).performCommand("mm test cast -s SpawnRevenantTier5");
                            sender.setOp(false);
                        } else {
                            ((Player)sender).performCommand("mm test cast -s SpawnRevenantTier5");
                        }
                }).register();

        new CommandAPICommand("questCompletionSpawnT1spider")
                .executes((sender, args) -> {
                    if (sender instanceof Player)
                        if (!sender.isOp()) {
                            sender.setOp(true);
                            ((Player)sender).performCommand("mm test cast -s SpawnSpiderTier1");
                            sender.setOp(false);
                        } else {
                            ((Player)sender).performCommand("mm test cast -s SpawnSpiderTier1");
                        }
                }).register();
        
        new CommandAPICommand("questCompletionSpawnT2spider")
                .executes((sender, args) -> {
                    if (sender instanceof Player)
                        if (!sender.isOp()) {
                            sender.setOp(true);
                            ((Player)sender).performCommand("mm test cast -s SpawnSpiderTier2");
                            sender.setOp(false);
                        } else {
                            ((Player)sender).performCommand("mm test cast -s SpawnSpiderTier2");
                        }
                }).register();

        new CommandAPICommand("questCompletionSpawnT3spider")
                .executes((sender, args) -> {
                    if (sender instanceof Player)
                        if (!sender.isOp()) {
                            sender.setOp(true);
                            ((Player)sender).performCommand("mm test cast -s SpawnSpiderTier3");
                            sender.setOp(false);
                        } else {
                            ((Player)sender).performCommand("mm test cast -s SpawnSpiderTier3");
                        }
                }).register();

        new CommandAPICommand("questCompletionSpawnT4spider")
                .executes((sender, args) -> {
                    if (sender instanceof Player)
                        if (!sender.isOp()) {
                            sender.setOp(true);
                            ((Player)sender).performCommand("mm test cast -s SpawnSpiderTier4");
                            sender.setOp(false);
                        } else {
                            ((Player)sender).performCommand("mm test cast -s SpawnSpiderTier4");
                        }
                }).register();

        new CommandAPICommand("questCompletionSpawnT1wolf")
                .executes((sender, args) -> {
                    if (sender instanceof Player)
                        if (!sender.isOp()) {
                            sender.setOp(true);
                            ((Player)sender).performCommand("mm test cast -s SpawnWolfTier1");
                            sender.setOp(false);
                        } else {
                            ((Player)sender).performCommand("mm test cast -s SpawnWolfTier1");
                        }
                }).register();

        new CommandAPICommand("questCompletionSpawnT2wolf")
                .executes((sender, args) -> {
                    if (sender instanceof Player)
                        if (!sender.isOp()) {
                            sender.setOp(true);
                            ((Player)sender).performCommand("mm test cast -s SpawnWolfTier2");
                            sender.setOp(false);
                        } else {
                            ((Player)sender).performCommand("mm test cast -s SpawnWolfTier2");
                        }
                }).register();

        new CommandAPICommand("questCompletionSpawnT3wolf")
                .executes((sender, args) -> {
                    if (sender instanceof Player)
                        if (!sender.isOp()) {
                            sender.setOp(true);
                            ((Player)sender).performCommand("mm test cast -s SpawnWolfTier3");
                            sender.setOp(false);
                        } else {
                            ((Player)sender).performCommand("mm test cast -s SpawnWolfTier3");
                        }
                }).register();

        new CommandAPICommand("questCompletionSpawnT4wolf")
                .executes((sender, args) -> {
                    if (sender instanceof Player)
                        if (!sender.isOp()) {
                            sender.setOp(true);
                            ((Player)sender).performCommand("mm test cast -s SpawnWolfTier4");
                            sender.setOp(false);
                        } else {
                            ((Player)sender).performCommand("mm test cast -s SpawnWolfTier4");
                        }
                }).register();

    }

}

