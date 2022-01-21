package com.ruserious99.cosmetics.commands;

import com.ruserious99.cosmetics.gui.CosmeticMainMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CosmeticsCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(sender instanceof Player){
            new CosmeticMainMenu((Player) sender);
        }

        return false;
    }
}
