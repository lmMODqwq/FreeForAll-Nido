package me.lmmodqwq.hodoffa.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class StatsManager {

    private final SQLite sqLite;

    public StatsManager(SQLite sqLite) {
        this.sqLite = sqLite;
    }


    public void addPlayer(String name,String uuid) throws SQLException {
        if (!isCreated(uuid)) {
            sqLite.update("INSERT INTO `statistics`(`player_name`, `player_uuid`) VALUES ('" + name + "','" + uuid + "');");
        }
    }

    public boolean isCreated(String uuid) throws SQLException {
        ResultSet resultSet = sqLite.getResult("SELECT `player_uuid` FROM `statistics` WHERE `player_uuid` = '" + uuid + "';");
        return resultSet.next();
    }

    public String getUUIDByName(String name) throws SQLException {
        ResultSet resultSet = sqLite.getResult("SELECT `player_uuid` FROM `statistics` WHERE `player_name` = '" + name + "';");
        if (resultSet.next()) {
            return resultSet.getString("player_uuid");
        } else {
            return null;
        }
    }

    public PlayerStats getStatsByUUID(String uuid) throws SQLException, ExecutionException, InterruptedException {
        ResultSet resultSet = sqLite.getResult("SELECT * FROM `statistics` WHERE `player_uuid` = '" + uuid + "';");
        PlayerStats playerStats;
        if(resultSet.next()){
            playerStats = new PlayerStats(resultSet.getString("player_name"), resultSet.getString("player_uuid"),
                    resultSet.getInt("kills"), resultSet.getInt("deaths"),
                    resultSet.getInt("streaks"), resultSet.getInt("streaks_highest"));
            return playerStats;
        }
        return null;
    }

    public void createPlayerStats(PlayerStats playerStats) throws SQLException {
        sqLite.update("INSERT INTO `statistics` (`player_name`, `player_uuid`, `kills`, `deaths`, `streaks`, `streaks_highest`) " +
                " VALUES ('" + playerStats.getName() + "', '" + playerStats.getUuid() + "', '" + playerStats.getKills() + "', '" + playerStats.getDeaths() + "', '" + playerStats.getStreaks() + "', '" + playerStats.getStreaks_highest() + "');");
    }

    public void updatePlayerStats(PlayerStats playerStats) throws SQLException {
        sqLite.update("UPDATE `statistics` SET `kills` = '" + playerStats.getKills() + "', `deaths` = '" + playerStats.getDeaths() + "', `streaks` = '" + playerStats.getStreaks() + "', `streaks_highest` = '" + playerStats.getStreaks_highest() + "' WHERE `player_uuid` = '" + playerStats.getUuid() + "';");
    }


}
