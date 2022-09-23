package me.lmmodqwq.hodoffa.commands;

import me.lmmodqwq.hodoffa.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ping implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        int ping = player.spigot().getPing();

        if (args.length == 1){
            String name = args[0];
            Player target;
            target = Bukkit.getPlayer(name);
            if (target == null) {
                sender.sendMessage(Utils.colorize("&aYour current ping to the server is&e " + ping + "ms&a."));
            }else {
                int ping2 = target.spigot().getPing();
                sender.sendMessage(Utils.colorize("&a"+ name + "&a's current ping to the server is&e " + ping2 + "ms&a."));
            }
        }else {
            sender.sendMessage(Utils.colorize("&aYour current ping to the server is&e " + ping + "ms&a."));
        }
        return false;
    }
}
