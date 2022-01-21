package com.ruserious99.cosmetics.gui.skulls;

import com.ruserious99.cosmetics.Cosmetics;
import com.ruserious99.cosmetics.mini_manager.Cosmetic;
import com.ruserious99.cosmetics.itemstack_utils.CreateItemStackSkulls;
import org.bukkit.entity.Player;

public class Skull extends Cosmetic {

    private SkullType skullType;

    public Skull(Cosmetics cosmetics, Player player, SkullType skullType) {
        super(cosmetics, player);
        this.skullType = skullType;
    }

    @Override
    public void enable() {
        player.getInventory().setHelmet(CreateItemStackSkulls.makeItemstack(skullType));
    }

    @Override
    public void disable() {
        player.getInventory().setHelmet(null);

    }

    public SkullType getSkullType() {
        return skullType;
    }
}
