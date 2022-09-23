package me.lmmodqwq.hodoffa.commands;

import me.lmmodqwq.hodoffa.inventory.CustomHolder;
import me.lmmodqwq.hodoffa.inventory.Icon;
import me.lmmodqwq.hodoffa.utils.Spawns;
import me.lmmodqwq.hodoffa.utils.Utils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class Spawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length >= 1) {
            return false;
        }

        assert sender instanceof Player;
        Player player = (Player) sender;

        if (!player.hasPermission("ffa.spawn")) {
            player.sendMessage(Utils.colorize("&cThis feature requires at least &6&lBRONZE&r &crank to be used."));
            return false;
        }

        if (player.getLocation().getY() >= 125.0D) {
            sender.sendMessage(Utils.colorize("&cYou can only use this command in the combat area."));
            return false;
        }

        CustomHolder customHolder = new CustomHolder(9, Utils.colorize("&e&lSpawn selector"));

        ItemStack Center = new ItemStack(Material.YELLOW_GLAZED_TERRACOTTA,1);
        ItemStack Cave = new ItemStack(Material.TNT,1);
        ItemStack Village = new ItemStack(Material.STONE,1,(byte)6);
        ItemStack Border = new ItemStack(Material.BARRIER,1);
        ItemStack Dragon = new ItemStack(Material.SKULL_ITEM,1,(short)5);

        setItemDisplayName(Center,"&6Center");
        setItemDisplayName(Cave,"&6Cave");
        setItemDisplayName(Village,"&6Village");
        setItemDisplayName(Border,"&6Border");
        setItemDisplayName(Dragon,"&6Dragon");

        Icon Center_icon = new Icon(Center).addClickAction(player1 -> {
            player1.closeInventory();
            Spawns.teleport(player1,"Center");
        });
        Icon Cave_icon = new Icon(Cave).addClickAction(player1 -> {
            player1.closeInventory();
            Spawns.teleport(player1,"Cave");
        });
        Icon Village_icon = new Icon(Village).addClickAction(player1 -> {
            player1.closeInventory();
            Spawns.teleport(player1,"Village");
        });
        Icon Border_icon = new Icon(Border).addClickAction(player1 -> {
            player1.closeInventory();
            Spawns.teleport(player1,"Border");
        });
        Icon Dragon_icon = new Icon(Dragon).addClickAction(player1 -> {
            player1.closeInventory();
            Spawns.teleport(player1,"Dragon");
        });

        customHolder.setIcon(0,Center_icon);
        customHolder.setIcon(1,Cave_icon);
        customHolder.setIcon(2,Village_icon);
        customHolder.setIcon(3,Border_icon);
        customHolder.setIcon(4,Dragon_icon);

        Inventory inventory = customHolder.getInventory();
        inventory.setItem(0,Center);
        inventory.setItem(1,Cave);
        inventory.setItem(2,Village);
        inventory.setItem(3,Border);
        inventory.setItem(4,Dragon);
        player.openInventory(inventory);

        return false;
    }

    private void setItemDisplayName(ItemStack itemStack,String string) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(Utils.colorize(string));
        itemStack.setItemMeta(itemMeta);
    }

    private void setItemBasePotionData(ItemStack itemStack,PotionType potionType) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        PotionMeta potionMeta = (PotionMeta) itemMeta;
        PotionData potionData = new PotionData(potionType);
        potionMeta.setBasePotionData(potionData);
        itemStack.setItemMeta(itemMeta);
    }
}
