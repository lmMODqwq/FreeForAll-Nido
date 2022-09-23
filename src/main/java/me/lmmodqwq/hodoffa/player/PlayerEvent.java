package me.lmmodqwq.hodoffa.player;

import me.lmmodqwq.hodoffa.HodoFFA;
import me.lmmodqwq.hodoffa.utils.Spawns;
import me.lmmodqwq.hodoffa.utils.Utils;
import me.lmmodqwq.hodoffa.utils.Variable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.TabCompleteEvent;

import java.util.Arrays;
import java.util.List;

public class PlayerEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Variable.kit.put(player,0);
        Variable.spawn.put(player,0);
        event.setJoinMessage(null);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        Player player = event.getEntity();
        player.setHealth(20.0D);
        Spawns.teleport(player,"Spawn");
        player.getInventory().clear();
        Utils.removeEffects(player);
        Utils.getClock(player);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Variable.kit.remove(player);
        Variable.spawn.remove(player);
        player.getInventory().clear();
        Utils.removeEffects(player);
        event.setQuitMessage(null);
    }


    //prevent using <plugin>:<command>
    @EventHandler
    public void onChat(PlayerCommandPreprocessEvent event) {
        if(event.getMessage().contains(":")) {
            event.setCancelled(true);
        }
    }

    //hide <plugin>:<command>
    @EventHandler
    public void onTabComplete(TabCompleteEvent event) {

        if (event.getSender().hasPermission("ffa.admin")) {
            return;
        }

        if (!event.getBuffer().contains(" ")) {
            //Doesn't contain space -> we are completing a command, not an argument
            event.getCompletions().removeIf((string) -> string.contains(":"));
        }

        List<String> hided_command = HodoFFA.main.getConfig().getStringList("hided_command");
        event.getCompletions().removeAll(hided_command);
        }

    @EventHandler
    public void onCommandPreprocess(PlayerCommandPreprocessEvent event) {

        List<String> disabled_command = HodoFFA.main.getConfig().getStringList("disabled_command");
        List<String> help = Arrays.asList("?","help");

        if (!event.getPlayer().hasPermission("ffa.admin")){
            help.forEach(all -> {
                String[] arrCommand = event.getMessage().toLowerCase().split(" ", 2);
                if (arrCommand[0].equalsIgnoreCase("/" + all.toLowerCase())) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(Utils.colorize("&cJust fight for now :)"));
                }
            });
        }

        if (!event.getPlayer().hasPermission("ffa.admin")){
        disabled_command.forEach(all -> {
            String[] arrCommand = event.getMessage().toLowerCase().split(" ", 2);
            if (arrCommand[0].equalsIgnoreCase("/" + all.toLowerCase())) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(Utils.colorize("&fUnknown command. Type \"/help\" for help."));
            }
        });
        }
    }
}
