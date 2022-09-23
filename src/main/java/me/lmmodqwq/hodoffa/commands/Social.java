package me.lmmodqwq.hodoffa.commands;

import me.lmmodqwq.hodoffa.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Social implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(Utils.colorize("&c&lYouTube&r: &nhttps://www.youtube.com/c/NidocraftNetwork\n" +
                "&9&lDiscord&r: &nhttps://discord.gg/M7FmKFE\n" +
                "&a&lWebsite&r: &cCurrently offline\n" +
                "&b&lStore&r: &nhttps://store.nidocraft.net"));
        return false;
    }

}
