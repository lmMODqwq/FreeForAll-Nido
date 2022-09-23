package me.lmmodqwq.hodoffa.utils;

public class PlayerStats {

    private String name;
    private String uuid;
    private int kills;
    private int deaths;
    private int streaks;
    private int streaks_highest;

    public PlayerStats(String name, String uuid, int kills, int deaths, int streaks, int streaks_highest) {
        this.name = name;
        this.uuid = uuid;
        this.kills = kills;
        this.deaths = deaths;
        this.streaks = streaks;
        this.streaks_highest = streaks_highest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() { return uuid; }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getStreaks() {
        return streaks;
    }

    public void setStreaks(int streaks) {
        this.streaks = streaks;
    }

    public int getStreaks_highest() {
        return streaks_highest;
    }

    public void setStreaks_highest(int streaks_highest) {
        this.streaks_highest = streaks_highest;
    }
}