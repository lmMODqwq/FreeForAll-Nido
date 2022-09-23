package me.lmmodqwq.hodoffa.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Spawns {

    public static void teleport(Player player, String location) {
        switch (location) {
            case "Spawn":
                Location Spawn = new Location(player.getWorld(), 68.5, 162.0, -18.5, 90.0F, 0.0F);
                player.teleport(Spawn);
                break;
            case "Center":
                Location Center = new Location(player.getWorld(),0.5,65.0,0.5,-135.0F,0.0F);
                player.teleport(Center);
                Variable.spawn.replace(player,1);
                break;
            case "Cave":
                Location Cave = new Location(player.getWorld(),3.5,63.0,70.5,-40.0F,0.0F);
                player.teleport(Cave);
                Variable.spawn.replace(player,2);
                break;
            case "Village":
                Location Village = new Location(player.getWorld(),115.5,64.0,23.5,90.0F,0.0F);
                player.teleport(Village);
                Variable.spawn.replace(player,3);
                break;
            case "Border":
                Location Border = new Location(player.getWorld(),-79.5,66.0,105.5,-135.0F,0.0F);
                player.teleport(Border);
                Variable.spawn.replace(player,4);
                break;
            case "Dragon":
                Location Dragon = new Location(player.getWorld(),-40.5,65.0,-92.5,-50.0F,0.0F);
                player.teleport(Dragon);
                Variable.spawn.replace(player,5);
                break;
        }
    }
}
