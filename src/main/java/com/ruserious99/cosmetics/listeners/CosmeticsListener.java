package com.ruserious99.cosmetics.listeners;


import com.ruserious99.cosmetics.Cosmetics;
import com.ruserious99.cosmetics.gui.skulls.Skull;
import com.ruserious99.cosmetics.gui.skulls.SkullType;
import com.ruserious99.cosmetics.gui.skulls.SkullsUi;
import com.ruserious99.cosmetics.gui.trails.Trails;
import com.ruserious99.cosmetics.gui.trails.TrailsType;
import com.ruserious99.cosmetics.gui.trails.TrailsUI;
import com.ruserious99.cosmetics.mini_manager.Cosmetic;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CosmeticsListener implements Listener {

    private Cosmetics cosmetics;

    public CosmeticsListener(Cosmetics cosmetics) {
        this.cosmetics = cosmetics;
    }

    @EventHandler
    public void invClicked(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        event.getInventory();
        if (event.getCurrentItem() != null) {
            if (event.getView().getTitle().endsWith("Cosmetics Main Menu")) {
                int slot = event.getRawSlot();
                switch (slot) {
                    case 0 -> new SkullsUi(cosmetics, player);
                    case 1 -> new TrailsUI(cosmetics, player);
                }
            } else if (event.getView().getTitle().endsWith("Trails Menu")) {
                TrailsType trailsType = TrailsType.valueOf(event.getCurrentItem().getItemMeta().getLocalizedName());
                List<Cosmetic> active;

                if (cosmetics.getActiveCosmetic().containsKey(player.getUniqueId())) {
                    active = cosmetics.getActiveCosmetic().get(player.getUniqueId());
                    Iterator<Cosmetic> iterator = active.listIterator();
                    while (iterator.hasNext()) {
                        Cosmetic cosmetic = iterator.next();
                        if (cosmetic instanceof Trails) {
                            cosmetic.disable();
                            iterator.remove();

                            if (((Trails) cosmetic).getTrailsType() == trailsType) {
                                player.sendMessage(ChatColor.RED + "You Disabled " + trailsType.getDisplay() + "!");
                                player.closeInventory();
                                return;
                            }
                        }
                    }
                } else {
                    active = new ArrayList<>();
                }
                Trails trails = new Trails(cosmetics, player, trailsType);
                trails.enable();
                active.add(trails);
                cosmetics.getActiveCosmetic().put(player.getUniqueId(), active);
                player.sendMessage(ChatColor.GREEN + "You Enabled " + trailsType.getDisplay() + "!");

                player.closeInventory();
            } else if (event.getView().getTitle().endsWith("Skulls Menu")) {

                SkullType skullType = SkullType.valueOf(event.getCurrentItem().getItemMeta().getLocalizedName());

                List<Cosmetic> active;

                if (cosmetics.getActiveCosmetic().containsKey(player.getUniqueId())) {
                    active = cosmetics.getActiveCosmetic().get(player.getUniqueId());
                    Iterator<Cosmetic> iterator = active.listIterator();
                    while (iterator.hasNext()) {
                        Cosmetic cosmetic = iterator.next();
                        if (cosmetic instanceof Skull) {
                            cosmetic.disable();
                            iterator.remove();

                            if (((Skull) cosmetic).getSkullType() == skullType) {
                                player.sendMessage(ChatColor.RED + "You Disabled " + skullType.getDisplay() + "!");
                                player.closeInventory();
                                return;
                            }
                        }
                    }
                } else {
                    active = new ArrayList<>();

                }
                Skull skull = new Skull(cosmetics, player, skullType);
                skull.enable();
                active.add(skull);
                cosmetics.getActiveCosmetic().put(player.getUniqueId(), active);
                player.sendMessage(ChatColor.GREEN + "You Enabled " + skullType.getDisplay() + "!");

                player.closeInventory();
            }
        }
    }


    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (cosmetics.getActiveCosmetic().containsKey(player.getUniqueId())) {
            for (Cosmetic cosmetic : cosmetics.getActiveCosmetic().get(player.getUniqueId())) {
                cosmetic.disable();
            }
            cosmetics.getActiveCosmetic().remove(player.getUniqueId());
        }
    }
}
