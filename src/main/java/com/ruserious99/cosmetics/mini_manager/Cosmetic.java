package com.ruserious99.cosmetics.mini_manager;

import com.ruserious99.cosmetics.Cosmetics;
import org.bukkit.entity.Player;

public abstract class Cosmetic {

    protected Cosmetics cosmetics;
    protected Player player;

    public Cosmetic(Cosmetics cosmetics, Player player) {
        this.cosmetics = cosmetics;
        this.player = player;
    }

    public abstract void enable();
    public abstract void disable();


}
