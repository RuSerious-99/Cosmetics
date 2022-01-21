package com.ruserious99.cosmetics.gui.trails;

import com.ruserious99.cosmetics.Cosmetics;
import com.ruserious99.cosmetics.mini_manager.Cosmetic;
import com.ruserious99.cosmetics.itemstack_utils.CreateItemStackTrails;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class TrailsUI {

    public static List<TrailsType> active;


    public TrailsUI(Cosmetics cosmetics, Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.AQUA + "Trails Menu");

        active = new ArrayList<>();
        if(cosmetics.getActiveCosmetic().containsKey(player.getUniqueId())){
            for(Cosmetic cosmetic : cosmetics.getActiveCosmetic().get(player.getUniqueId())){
                if(cosmetic instanceof Trails){
                    active.add(((Trails) cosmetic).getTrailsType());
                    break;
                }
            }
        }

        for(TrailsType trailsType : TrailsType.values()){
            inventory.addItem(CreateItemStackTrails.makeItemstack(trailsType));
        }
        player.openInventory(inventory);
    }
}


