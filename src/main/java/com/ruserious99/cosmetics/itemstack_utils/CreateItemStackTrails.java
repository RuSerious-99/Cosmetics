package com.ruserious99.cosmetics.itemstack_utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.ruserious99.cosmetics.gui.skulls.SkullsUi;
import com.ruserious99.cosmetics.gui.trails.TrailsType;
import com.ruserious99.cosmetics.gui.trails.TrailsUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class CreateItemStackTrails {


    public static ItemStack makeItemstack(TrailsType trailsType) {
        ItemStack trail = new ItemStack(Material.PLAYER_HEAD);

        SkullMeta meta = (SkullMeta) trail.getItemMeta();

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", trailsType.getTextureString()));
        Field field;
        try {
            field = meta.getClass().getDeclaredField("profile");
            field.setAccessible(true);
            field.set(meta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException x) {
            x.printStackTrace();
        }
        meta.setDisplayName(trailsType.getDisplay() + " " + (TrailsUI.active.contains(trailsType) ? ChatColor.RED + "Click to Disable" : ChatColor.GREEN + "Click to Enable"));
        meta.setLore(trailsType.getDescription());
        meta.setLocalizedName(trailsType.name());
        trail.setItemMeta(meta);
        return trail;
    }
}