package com.ruserious99.cosmetics.gui.trails;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import java.util.Arrays;
import java.util.List;

public enum TrailsType {

    HEART_TRAIL(ChatColor.DARK_RED + "HEART TRAIL",
                Arrays.asList(ChatColor.WHITE + "I Love Everyone!"),
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDg2NWEzODNhNGRjYTA4YzVkYWFiNmFjZTQxMTc3MjA5NWVlNjMyN2MxMjI3MDNhMjIyNDQyZjIxNDFjMmMzZCJ9fX0=",
    Particle.HEART),

    FLAME_TRAIL(ChatColor.GOLD + "FLAME TRAIL",
                Arrays.asList(ChatColor.WHITE + "Hot Stuff"),
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmI1OGI4M2YwNzYxOGVhNzlhMWExMjAyYjVhNzdiMTRkZjFjOGUzNWI2ZTFkZWI4YTI2ZDg5NzZmODUzNjBjMyJ9fX0=",
    Particle.FLAME),

    CAMPFIRE_TRAIL(ChatColor.GRAY + "CAMPFIRE TRAIL",
                Arrays.asList(ChatColor.WHITE + "Break out the MarshMellows"),
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmQ5NTk2NWQ3OWRkZjYxM2Y1OTRmZDIwZDUxZTc2NWMwOWEyYTVmZjhkMGUwOWNmZjE5YThlYTQzMDIzNThhZCJ9fX0=",
    Particle.CAMPFIRE_SIGNAL_SMOKE);



    private String display, textureString;
    private List<String> description;
    private Particle particle;

    TrailsType(String display, List<String> description, String textureString, Particle particle ) {
        this.display = display;
        this.textureString = textureString;
        this.description = description;
        this.particle = particle;
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

    public Particle getParticle() {
        return particle;
    }
}
