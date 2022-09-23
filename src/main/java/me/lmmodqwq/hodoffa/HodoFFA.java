package me.lmmodqwq.hodoffa;

import me.lmmodqwq.hodoffa.commands.*;
import me.lmmodqwq.hodoffa.inventory.InventoryListener;
import me.lmmodqwq.hodoffa.player.CombatEvent;
import me.lmmodqwq.hodoffa.player.PlayerEvent;
import me.lmmodqwq.hodoffa.stats.PlaceHolder;
import me.lmmodqwq.hodoffa.utils.SQLite;
import me.lmmodqwq.hodoffa.utils.StatsManager;
import me.lmmodqwq.hodoffa.world.WorldEvent;
import me.lmmodqwq.hodoffa.world.WorldSpawn;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public final class HodoFFA extends JavaPlugin {

    private SQLite sqLite;
    private File sqliteDatabase;
    public static Chat vault;

    public static HodoFFA main;

    public FileConfiguration config = getConfig();
    @Override
    public void onEnable() {

        setupVault();

        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        File file = new File(getDataFolder(),"config.yml");
        if (!file.exists()) {
            saveDefaultConfig();
        }

        //sqlite
        createFileDatabase();
        sqLite = new SQLite(sqliteDatabase);
        StatsManager statsManager = new StatsManager(sqLite);
        try {
            sqLite.connect();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        try {
            if(sqLite.isConnected()) {
                sqLite.createTables();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }


        //register event
        this.getServer().getPluginManager().registerEvents(new CombatEvent(statsManager),this);
        this.getServer().getPluginManager().registerEvents(new PlayerEvent(), this);
        this.getServer().getPluginManager().registerEvents(new WorldEvent(), this);
        this.getServer().getPluginManager().registerEvents(new WorldSpawn(),this);
        this.getServer().getPluginManager().registerEvents(new InventoryListener(),this);

        //register command
        getCommand("social").setExecutor(new Social());
        getCommand("ping").setExecutor(new Ping());
        getCommand("kill").setExecutor(new Kill());
        getCommand("kit").setExecutor(new Kit());
        getCommand("spawn").setExecutor(new Spawn());

        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PlaceHolder(statsManager).register();
        }

    }

    @Override
    public void onDisable() {
        try {
            if (sqLite.isConnected())
                sqLite.disconnect();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private void setupVault() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        if (rsp != null) {
            vault = rsp.getProvider();
        }
    }

    private void createFileDatabase() {
        try {
            sqliteDatabase = new File(this.getDataFolder(), "database.db");

            if (!sqliteDatabase.exists()) {
                sqliteDatabase.createNewFile();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public HodoFFA() {
        main = this;
    }
}
