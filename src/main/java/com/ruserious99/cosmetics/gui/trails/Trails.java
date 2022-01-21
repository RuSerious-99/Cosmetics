package com.ruserious99.cosmetics.gui.trails;

import com.ruserious99.cosmetics.Cosmetics;
import com.ruserious99.cosmetics.mini_manager.Cosmetic;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class Trails  extends Cosmetic {

    private TrailsType trailsType;
    private BukkitTask task;

    public Trails(Cosmetics cosmetics, Player player, TrailsType trailsType) {
        super(cosmetics, player);
        this.trailsType = trailsType;
    }

    @Override
    public void enable() {
       task =  Bukkit.getScheduler().runTaskTimer(cosmetics, new Runnable() {

            Location location = player.getLocation();

            @Override
            public void run() {
                Location currentLocation = player.getLocation();
                if(currentLocation.getX() != location.getX() || currentLocation.getY() != location.getY()){
                    player.spawnParticle(trailsType.getParticle(), player.getLocation(), 6);
                    location = player.getLocation();
                }


        }

        }, 0, 1);
    }

    @Override
    public void disable() {

        task.cancel();

    }

    public TrailsType getTrailsType() {
        return trailsType;
    }

    public BukkitTask getTask() {
        return task;
    }
}
