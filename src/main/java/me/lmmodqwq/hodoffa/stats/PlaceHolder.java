package me.lmmodqwq.hodoffa.stats;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.lmmodqwq.hodoffa.utils.PlayerStats;
import me.lmmodqwq.hodoffa.utils.StatsManager;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class PlaceHolder extends PlaceholderExpansion {

    private final StatsManager statsManager;

    public PlaceHolder(StatsManager statsManager) {
        this.statsManager = statsManager;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "stats";
    }

    @Override
    public @NotNull String getAuthor() {
        return "lmMODqwq";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {

        int kills;
        int deaths;
        int streaks;
        int streaks_highest;

        try {
            PlayerStats playerStats = getPlayerStatsFromDatabase((Player) player);
            kills = playerStats.getKills();
            deaths = playerStats.getDeaths();
            streaks = playerStats.getStreaks();
            streaks_highest = playerStats.getStreaks_highest();
        } catch (SQLException | InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        if (params.equalsIgnoreCase("kills")) {
            return String.valueOf(kills);
        }

        if (params.equalsIgnoreCase("deaths")) {
            return String.valueOf(deaths);
        }

        if (params.equalsIgnoreCase("kdr")){
            if (deaths == 0.0D){
                String kdr = String.format("%.2f", (double) kills );
                return String.valueOf(kdr);
            } else if (deaths >= 1.0D) {
                String kdr = String.format("%.2f", (double) kills / (double) deaths);
                return String.valueOf(kdr);
            }
        }

        if (params.equalsIgnoreCase("streaks")) {
            return String.valueOf(streaks);
        }

        if (params.equalsIgnoreCase("streaks_highest")) {
            return String.valueOf(streaks_highest);
        }

        return null;

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
