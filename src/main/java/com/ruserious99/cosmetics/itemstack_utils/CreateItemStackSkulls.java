package com.ruserious99.cosmetics.itemstack_utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.ruserious99.cosmetics.gui.skulls.SkullType;
import com.ruserious99.cosmetics.gui.skulls.SkullsUi;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import java.lang.reflect.Field;
import java.util.UUID;

public class CreateItemStackSkulls {

    public static ItemStack makeItemstack(SkullType skullType) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);

        SkullMeta meta = (SkullMeta) skull.getItemMeta();

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", skullType.getTextureString()));
        Field field;
        try {
            field = meta.getClass().getDeclaredField("profile");
            field.setAccessible(true);
            field.set(meta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException x) {
            x.printStackTrace();
        }
        meta.setDisplayName(skullType.getDisplay() + " " + (SkullsUi.active.contains(skullType) ? ChatColor.RED + "Click to Disable" : ChatColor.GREEN + "Click to Enable"));
        meta.setLore(skullType.getDescription());
        meta.setLocalizedName(skullType.name());
        skull.setItemMeta(meta);
        return skull;
    }
}
