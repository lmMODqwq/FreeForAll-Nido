package me.lmmodqwq.hodoffa.world;

import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class WorldEvent implements Listener {

    //Prevent Item Drop
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (!(player.hasPermission("ffa.admin") || player.getGameMode().equals(GameMode.CREATIVE))) {
            event.setCancelled(true);
        }
    }

    //Prevent PickupItem
    @EventHandler
    public void onItemPickup(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (!(player.hasPermission("ffa.admin") || player.getGameMode().equals(GameMode.CREATIVE))) {
                event.setCancelled(true);
            }
        }
    }

    //Prevent Place Blocks
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (!(player.hasPermission("ffa.admin") || player.getGameMode().equals(GameMode.CREATIVE))) {
            event.setCancelled(true);
        }
    }

    //Prevent Break Blocks
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (!(player.hasPermission("ffa.admin") || player.getGameMode().equals(GameMode.CREATIVE))) {
            event.setCancelled(true);
        }
    }

    // Prevent Hunger
    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            event.setCancelled(true);
            if (player.getFoodLevel() <= 19.0D) {
                player.setFoodLevel(20);
            }
        }
    }

    // No Fall Damage
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            if(event.getCause() == EntityDamageEvent.DamageCause.FALL){
                event.setCancelled(true);
            }
        }
    }

    // Spawn Protect
    @EventHandler
    public void OnEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntityType() == EntityType.PLAYER && event.getEntityType() == EntityType.PLAYER && event.getEntity().getLocation().getY() >= 125.0D) {
            event.setCancelled(true);
        }

    }
}
