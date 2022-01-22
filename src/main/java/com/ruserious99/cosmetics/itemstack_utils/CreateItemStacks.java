package com.ruserious99.cosmetics.itemstack_utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class CreateItemStacks {

    private static HashMap<ItemStack, Boolean> type_skulls;
    public static ItemStack Skull_Cosmetics;
    public static ItemStack Trails_Cosmetics;


    public static void init() {

        type_skulls = new HashMap<>();
        createCosmeticSkullItem();
        createCosmeticTrailItem();

    }

    private static void createCosmeticSkullItem() {

        ItemStack cosmeticSkull = new ItemStack(Material.PLAYER_HEAD);

        SkullMeta meta = (SkullMeta) cosmeticSkull.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.DARK_PURPLE + "COSMETIC SKULLS");

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE +" ");
        lore.add("Put them on to Enjoy the look");
        lore.add("To give you a visual override");
        lore.add(" ");
        meta.setLore(lore);

        cosmeticSkull.setItemMeta(meta);

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGFkMDQ3NmU4NjcxNjk2YWYzYTg5NDlhZmEyYTgxNGI5YmRkZTY1ZWNjZDFhOGI1OTNhZWVmZjVhMDMxOGQifX19"));
        Field field;
        try {
            field = meta.getClass().getDeclaredField("profile");
            field.setAccessible(true);
            field.set(meta, profile);
        }catch(NoSuchFieldException | IllegalArgumentException | IllegalAccessException x){
            x.printStackTrace();
        }
        Skull_Cosmetics = cosmeticSkull;
        type_skulls.put(Skull_Cosmetics, false);

    }

    private static void createCosmeticTrailItem() {
        ItemStack cosmeticTrail = new ItemStack(Material.PLAYER_HEAD);

        SkullMeta meta = (SkullMeta) cosmeticTrail.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.DARK_PURPLE + "COSMETIC TRAILS");

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE +" ");
        lore.add("Put them on to Enjoy the look");
        lore.add("To give you a visual override");
        lore.add(" ");
        meta.setLore(lore);

        cosmeticTrail.setItemMeta(meta);

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODkzNzVkODA1MjkxYmFjN2QwNDVjNWMwNDQ4YWI3ZjU1OTlmYTZkOWE4Y2FlYWU0YmQyNTFkNTg2ZTJjOCJ9fX0="));
        Field field;
        try {
            field = meta.getClass().getDeclaredField("profile");
            field.setAccessible(true);
            field.set(meta, profile);
        }catch(NoSuchFieldException | IllegalArgumentException | IllegalAccessException x){
            x.printStackTrace();
        }
        Trails_Cosmetics = cosmeticTrail;
        type_skulls.put(Trails_Cosmetics, false);

    }

    public static HashMap<ItemStack, Boolean> getType_skulls() {
        return type_skulls;
    }

    public static ItemStack getSkull_Cosmetics() {
        return Skull_Cosmetics;
    }

    public static ItemStack getTrails_Cosmetics() {
        return Trails_Cosmetics;
    }
}


