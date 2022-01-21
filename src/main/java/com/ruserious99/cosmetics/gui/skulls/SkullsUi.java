package com.ruserious99.cosmetics.gui.skulls;

import com.ruserious99.cosmetics.Cosmetics;
import com.ruserious99.cosmetics.mini_manager.Cosmetic;
import com.ruserious99.cosmetics.itemstack_utils.CreateItemStackSkulls;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import java.util.ArrayList;
import java.util.List;

public class SkullsUi {

   public static List<SkullType> active;


    public SkullsUi(Cosmetics cosmetics, Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.DARK_PURPLE + "Skulls Menu");

        active = new ArrayList<>();
        if(cosmetics.getActiveCosmetic().containsKey(player.getUniqueId())){
            for(Cosmetic cosmetic : cosmetics.getActiveCosmetic().get(player.getUniqueId())){
                if(cosmetic instanceof  Skull){
                    active.add(((Skull) cosmetic).getSkullType());
                    break;
                }
            }
        }

        for(SkullType skullType : SkullType.values()){
            inventory.addItem(CreateItemStackSkulls.makeItemstack(skullType));
        }
        player.openInventory(inventory);
    }
}
