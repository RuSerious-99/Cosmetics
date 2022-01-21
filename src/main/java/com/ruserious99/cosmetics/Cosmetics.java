package com.ruserious99.cosmetics;

import com.ruserious99.cosmetics.commands.CosmeticsCommands;
import com.ruserious99.cosmetics.listeners.CosmeticsListener;
import com.ruserious99.cosmetics.mini_manager.Cosmetic;
import com.ruserious99.cosmetics.itemstack_utils.CreateItemStacks;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public final class Cosmetics extends JavaPlugin {

    private HashMap<UUID, List<Cosmetic>> activeCosmetic = new HashMap<>();

    @Override
    public void onEnable() {
        CreateItemStacks.init();
        getCommand("cosmetics").setExecutor(new CosmeticsCommands());
        Bukkit.getPluginManager().registerEvents(new CosmeticsListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public HashMap<UUID, List<Cosmetic>> getActiveCosmetic() {
        return activeCosmetic;
    }
}
