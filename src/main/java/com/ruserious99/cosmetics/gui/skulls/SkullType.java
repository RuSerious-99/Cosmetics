package com.ruserious99.cosmetics.gui.skulls;

import org.bukkit.ChatColor;
import java.util.Arrays;
import java.util.List;

public enum SkullType {

    DEMON_SKULL(ChatColor.DARK_RED + "DEMON",
            Arrays.asList(ChatColor.WHITE + "We all Go Down!"),
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTRkNjYxZTE0YTQ4NjM2NWQ3OWZiMGNiZTdiYWQ1MjAzZDQ5YzBlY2RlZjBhMGFmMmM5MDFhOGVlMzI5In19fQ==");

    private String display, textureString;
    private List<String> description;

    SkullType(String display, List<String> description, String textureString ) {
        this.display = display;
        this.textureString = textureString;
        this.description = description;
    }

    public String getDisplay() {
        return display;
    }

    public String getTextureString() {
        return textureString;
    }

    public List<String> getDescription() {
        return description;
    }
}
