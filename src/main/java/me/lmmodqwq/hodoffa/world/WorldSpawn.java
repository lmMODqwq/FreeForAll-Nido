package me.lmmodqwq.hodoffa.world;

import me.lmmodqwq.hodoffa.utils.Kits;
import me.lmmodqwq.hodoffa.utils.Spawns;
import me.lmmodqwq.hodoffa.utils.Utils;
import me.lmmodqwq.hodoffa.utils.Variable;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class WorldSpawn implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.getInventory().clear();
        Spawns.teleport(player,"Spawn");
        Utils.getClock(player);
    }

    @EventHandler
    public void onJumpDownSpawn(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.getLocation().getBlockY() >= 130 && player.getLocation().getBlockY() <= 140 && !player.getGameMode().equals(GameMode.CREATIVE)) {
            switch (Variable.kit.get(player)) {
                case 0:
                    Spawns.teleport(player,"Spawn");
                    player.sendMessage(Utils.colorize("&cYou need to click a kit selector at least once before doing that."));
                    break;
                case 1:
                    Kits.getKit(player,"Axeman");
                    break;
                case 2:
                    Kits.getKit(player,"Warrior");
                    break;
                case 3:
                    Kits.getKit(player,"Beast");
                    break;
                case 4:
                    Kits.getKit(player,"Runner");
                    break;
            }
        }
    }

    @EventHandler
    public void onLobbyItemClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getItemInHand().getType() == Material.WATCH && player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Quick respawn " + ChatColor.GRAY + "(Click)")) {
            switch (Variable.spawn.get(player)) {
                case 0:
                    player.sendMessage(Utils.colorize("&cYou need to click a kit selector at least once before doing that."));
                    break;
                case 1:
                    Spawns.teleport(player,"Center");
                    break;
                case 2:
                    Spawns.teleport(player,"Cave");
                    break;
                case 3:
                    Spawns.teleport(player,"Village");
                    break;
                case 4:
                    Spawns.teleport(player,"Border");
                    break;
                case 5:
                    Spawns.teleport(player,"Dragon");
                    break;
            }
            switch (Variable.kit.get(player)) {
                case 0:
                    break;
                case 1:
                    Kits.getKit(player,"Axeman");
                    break;
                case 2:
                    Kits.getKit(player,"Warrior");
                    break;
                case 3:
                    Kits.getKit(player,"Beast");
                    break;
                case 4:
                    Kits.getKit(player,"Runner");
                    break;
            }

        }
    }
}
