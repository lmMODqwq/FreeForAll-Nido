package me.lmmodqwq.hodoffa.commands;

import me.lmmodqwq.hodoffa.inventory.CustomHolder;
import me.lmmodqwq.hodoffa.inventory.Icon;
import me.lmmodqwq.hodoffa.utils.Kits;
import me.lmmodqwq.hodoffa.utils.Spawns;
import me.lmmodqwq.hodoffa.utils.Utils;
import me.lmmodqwq.hodoffa.utils.Variable;
import org.bukkit.ChatColor;
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

import java.util.Arrays;
import java.util.List;

public class Kit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        assert sender instanceof Player;
        Player player = (Player) sender;

        List<String> kits = Arrays.asList("Axeman", "Warrior", "Beast", "Runner");

        if (args.length >= 3) {
            return false;
        }

        if (args.length == 2 && "pre".equals(args[1])) {
            if (kits.contains(args[0])) {
                setPreviousLocation(player, args[0]);
            }
            return false;
        }

        if (args.length == 1) {
            if (player.getLocation().getY() <= 125.0D) {
                sender.sendMessage(ChatColor.RED + "You can not use this command in the combat area.");
                return false;
            }

            if (kits.contains(args[0])) {
                setLocation(player, args[0]);
            }
            return false;
        }

        if (!player.hasPermission("ffa.kit")) {
            player.sendMessage(Utils.colorize("&cThis feature requires at least &6&lBRONZE&r &crank to be used."));
            return false;
        }

        if (player.getLocation().getY() >= 125.0D) {
            sender.sendMessage(Utils.colorize("&cYou can only use this command in the combat area."));
            return false;
        }

        CustomHolder customHolder = new CustomHolder(9, Utils.colorize("&e&lKit selector"));

        ItemStack Axeman = new ItemStack(Material.DIAMOND_AXE,1);
        ItemStack Warrior = new ItemStack(Material.DIAMOND_SWORD,1);
        ItemStack Beast = new ItemStack(Material.DIAMOND_CHESTPLATE,1);
        ItemStack Runner = new ItemStack(Material.POTION,1);

        setItemDisplayName(Axeman,"&6Axeman");
        setItemDisplayName(Warrior,"&6Warrior");
        setItemDisplayName(Beast,"&6Beast");
        setItemDisplayName(Runner,"&6Runner");

        setItemBasePotionData(Runner,PotionType.SPEED);

        Icon Axeman_icon = new Icon(Axeman).addClickAction(player1 -> {
            player1.closeInventory();
            player1.getInventory().clear();
            Utils.removeEffects(player1);
            Kits.getKit(player1,"Axeman");
        });
        Icon Warrior_icon = new Icon(Warrior).addClickAction(player1 -> {
            player1.closeInventory();
            player1.getInventory().clear();
            Utils.removeEffects(player1);
            Kits.getKit(player1,"Warrior");
        });
        Icon Beast_icon = new Icon(Beast).addClickAction(player1 -> {
            player1.closeInventory();
            player1.getInventory().clear();
            Utils.removeEffects(player1);
            Kits.getKit(player1,"Beast");
        });
        Icon Runner_icon = new Icon(Runner).addClickAction(player1 -> {
            player1.closeInventory();
            player1.getInventory().clear();
            Utils.removeEffects(player1);
            Kits.getKit(player1,"Runner");
        });

        customHolder.setIcon(0,Axeman_icon);
        customHolder.setIcon(1,Warrior_icon);
        customHolder.setIcon(2,Beast_icon);
        customHolder.setIcon(3,Runner_icon);

        Inventory kit = customHolder.getInventory();
        kit.setItem(0,Axeman);
        kit.setItem(1,Warrior);
        kit.setItem(2,Beast);
        kit.setItem(3,Runner);
        player.openInventory(kit);

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

    private void setLocation(Player player,String kit) {

        CustomHolder customHolder = new CustomHolder(9, ChatColor.translateAlternateColorCodes('&',"&e&lSpawn selector"));

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
            Kits.getKit(player1,kit);
            Spawns.teleport(player1,"Center");
        });
        Icon Cave_icon = new Icon(Cave).addClickAction(player1 -> {
            player1.closeInventory();
            Kits.getKit(player1,kit);
            Spawns.teleport(player1,"Cave");
        });
        Icon Village_icon = new Icon(Village).addClickAction(player1 -> {
            player1.closeInventory();
            Kits.getKit(player1,kit);
            Spawns.teleport(player1,"Village");
        });
        Icon Border_icon = new Icon(Border).addClickAction(player1 -> {
            player1.closeInventory();
            Kits.getKit(player1,kit);
            Spawns.teleport(player1,"Border");
        });
        Icon Dragon_icon = new Icon(Dragon).addClickAction(player1 -> {
            player1.closeInventory();
            Kits.getKit(player1,kit);
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

    }

    private void setPreviousLocation(Player player,String kit) {
        switch(Variable.spawn.get(player)) {
            case 0:
                player.sendMessage(ChatColor.RED + "You need to click a kit selector at least once before doing that.");
                break;
            case 1:
                Kits.getKit(player,kit);
                Spawns.teleport(player,"Center");
                break;
            case 2:
                Kits.getKit(player,kit);
                Spawns.teleport(player,"Cave");
                break;
            case 3:
                Kits.getKit(player,kit);
                Spawns.teleport(player,"Village");
                break;
            case 4:
                Kits.getKit(player,kit);
                Spawns.teleport(player,"Border");
                break;
            case 5:
                Kits.getKit(player,kit);
                Spawns.teleport(player,"Dragon");
                break;
        }
    }
}
