package me.lmmodqwq.hodoffa.commands;

import me.lmmodqwq.hodoffa.utils.Spawns;
import me.lmmodqwq.hodoffa.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kill implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length >= 1) {
            return false;
        }

        Player player = (Player) sender;

        if (player.getHealth() == 20) {
            player.getInventory().clear();
            Spawns.teleport(player,"Spawn");
            Utils.getClock(player);
            Utils.removeEffects(player);
        } else {
            player.setHealth(0);
        }

        return false;
    }

}
