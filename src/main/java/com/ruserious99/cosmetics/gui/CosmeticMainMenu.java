package com.ruserious99.cosmetics.gui;

import com.ruserious99.cosmetics.itemstack_utils.CreateItemStacks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CosmeticMainMenu {


    public CosmeticMainMenu(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.DARK_PURPLE + "Cosmetics Main Menu");

        inventory.setItem(0, CreateItemStacks.Skull_Cosmetics);
        inventory.setItem(1, CreateItemStacks.Trails_Cosmetics);

        player.openInventory(inventory);
    }



}
