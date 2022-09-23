package me.lmmodqwq.hodoffa.utils;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

public class Utils {

    public static String colorize(final String message) {
        return org.bukkit.ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void removeEffects(Player player) {
        for (PotionEffect e : player.getActivePotionEffects()) {
            player.removePotionEffect(e.getType());
        }
    }

    public static void getClock(Player player) {
        ItemStack clock = new ItemStack(Material.WATCH, 1);
        ItemMeta clock_meta = clock.getItemMeta();
        clock_meta.setDisplayName(ChatColor.YELLOW + "Quick respawn " + ChatColor.GRAY + "(Click)");
        clock.setItemMeta(clock_meta);
        player.getInventory().setItem(4, clock);
    }

}
