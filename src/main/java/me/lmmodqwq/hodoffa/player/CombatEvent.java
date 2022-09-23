package me.lmmodqwq.hodoffa.player;

import me.lmmodqwq.hodoffa.utils.PlayerStats;
import me.lmmodqwq.hodoffa.utils.StatsManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

import static me.lmmodqwq.hodoffa.HodoFFA.vault;

public class CombatEvent implements Listener {

    private final StatsManager statsManager;

    public CombatEvent(StatsManager statsManager) {
        this.statsManager = statsManager;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {

        Player player = event.getEntity();

        if (player.getKiller() == null) {
            try {
                PlayerStats playerStats = getPlayerStatsFromDatabase(player);
                playerStats.setDeaths(playerStats.getDeaths() + 1);
                playerStats.setStreaks(0);
            } catch (SQLException | ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            return;
        }

        Player killer = player.getKiller();
        String playerPrefix = vault.getPlayerPrefix(player);
        String killerPrefix = vault.getPlayerPrefix(killer);

        assert killer != null;

        if (killer.getHealth() == 20) {
            String health = "10.0";
            Bukkit.broadcastMessage(playerPrefix.replaceAll("&", "\u00a7") + player.getDisplayName() + ChatColor.YELLOW + " was slain by " + killerPrefix.replaceAll("&", "\u00a7") + killer.getDisplayName() + " " + ChatColor.RED + health + " " + ChatColor.RED + "❤");
        } else {
            String health = String.format("%.2f", killer.getHealth() / 2);
            Bukkit.broadcastMessage(playerPrefix.replaceAll("&", "\u00a7") + player.getDisplayName() + ChatColor.YELLOW + " was slain by " + killerPrefix.replaceAll("&", "\u00a7") + killer.getDisplayName() + " " + ChatColor.RED + health + " " + ChatColor.RED + "❤");
        }

        killer.setHealth(20.0D);

        try{
            PlayerStats killerStats = getPlayerStatsFromDatabase(killer);
            PlayerStats playerStats = getPlayerStatsFromDatabase(player);

            killerStats.setKills(killerStats.getKills() + 1);
            if (killerStats.getStreaks() < killerStats.getStreaks_highest()) {
                killerStats.setStreaks(killerStats.getStreaks() + 1);
            } else {
                killerStats.setStreaks(killerStats.getStreaks() + 1);
                killerStats.setStreaks_highest(killerStats.getStreaks_highest() + 1);
            }


            playerStats.setDeaths(playerStats.getDeaths() + 1);
            playerStats.setStreaks(0);

            statsManager.updatePlayerStats(killerStats);
            statsManager.updatePlayerStats(playerStats);

        }catch (SQLException | ExecutionException | InterruptedException exception){
            exception.printStackTrace();
        }

    }

    public PlayerStats getPlayerStatsFromDatabase(Player player) throws SQLException, InterruptedException, ExecutionException {
        PlayerStats playerStats = statsManager.getStatsByUUID(player.getUniqueId().toString());
        if (playerStats == null) {
            playerStats = new PlayerStats(player.getName(), player.getUniqueId().toString(), 0, 0, 0, 0);
            statsManager.createPlayerStats(playerStats);
        }
        return playerStats;
    }
}
