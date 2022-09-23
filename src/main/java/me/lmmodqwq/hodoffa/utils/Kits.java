package me.lmmodqwq.hodoffa.utils;

import me.lmmodqwq.hodoffa.player.PlayerEvent;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

public class Kits {

    private static ItemStack getItem(String name) {
        switch (name) {
            case "DIAMOND_AXE":
                ItemStack DIAMOND_AXE = new ItemStack(Material.DIAMOND_AXE);
                ItemMeta DIAMOND_AXE_META = DIAMOND_AXE.getItemMeta();
                DIAMOND_AXE_META.setUnbreakable(true);
                DIAMOND_AXE.setItemMeta(DIAMOND_AXE_META);
                return DIAMOND_AXE;
            case "DIAMOND_SWORD":
                ItemStack DIAMOND_SWORD = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta sword_meta = DIAMOND_SWORD.getItemMeta();
                sword_meta.setUnbreakable(true);
                DIAMOND_SWORD.setItemMeta(sword_meta);
                return DIAMOND_SWORD;
            case "DIAMOND_SWORD_S3":
                ItemStack DIAMOND_SWORD_S3 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta DIAMOND_SWORD_S3_META = DIAMOND_SWORD_S3.getItemMeta();
                DIAMOND_SWORD_S3_META.setUnbreakable(true);
                DIAMOND_SWORD_S3.setItemMeta(DIAMOND_SWORD_S3_META);
                DIAMOND_SWORD_S3.addEnchantment(Enchantment.DAMAGE_ALL,3);
                return DIAMOND_SWORD_S3;
            case "CHAINMAIL_HELMET_P1":
                ItemStack CHAINMAIL_HELMET_P1 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta CHAINMAIL_HELMET_P1_META = CHAINMAIL_HELMET_P1.getItemMeta();
                CHAINMAIL_HELMET_P1_META.setUnbreakable(true);
                CHAINMAIL_HELMET_P1.setItemMeta(CHAINMAIL_HELMET_P1_META);
                CHAINMAIL_HELMET_P1.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
                return CHAINMAIL_HELMET_P1;
            case "IRON_HELMET_P1":
                ItemStack IRON_HELMET_P1 = new ItemStack(Material.IRON_HELMET);
                ItemMeta IRON_HELMET_P1_META = IRON_HELMET_P1.getItemMeta();
                IRON_HELMET_P1_META.setUnbreakable(true);
                IRON_HELMET_P1.setItemMeta(IRON_HELMET_P1_META);
                IRON_HELMET_P1.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
                return IRON_HELMET_P1;
            case "DIAMOND_HELMET":
                ItemStack DIAMOND_HELMET = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta DIAMOND_HELMET_META = DIAMOND_HELMET.getItemMeta();
                DIAMOND_HELMET_META.setUnbreakable(true);
                DIAMOND_HELMET.setItemMeta(DIAMOND_HELMET_META);
                return DIAMOND_HELMET;
            case "DIAMOND_HELMET_P1":
                ItemStack DIAMOND_HELMET_P1 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta DIAMOND_HELMET_P1_META = DIAMOND_HELMET_P1.getItemMeta();
                DIAMOND_HELMET_P1_META.setUnbreakable(true);
                DIAMOND_HELMET_P1.setItemMeta(DIAMOND_HELMET_P1_META);
                DIAMOND_HELMET_P1.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
                return DIAMOND_HELMET_P1;
            case "DIAMOND_CHESTPLATE":
                ItemStack DIAMOND_CHESTPLATE = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta DIAMOND_CHESTPLATE_META = DIAMOND_CHESTPLATE.getItemMeta();
                DIAMOND_CHESTPLATE_META.setUnbreakable(true);
                DIAMOND_CHESTPLATE.setItemMeta(DIAMOND_CHESTPLATE_META);
                return DIAMOND_CHESTPLATE;
            case "DIAMOND_CHESTPLATE_P2":
                ItemStack DIAMOND_CHESTPLATE_P2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta DIAMOND_CHESTPLATE_P2_META = DIAMOND_CHESTPLATE_P2.getItemMeta();
                DIAMOND_CHESTPLATE_P2_META.setUnbreakable(true);
                DIAMOND_CHESTPLATE_P2.setItemMeta(DIAMOND_CHESTPLATE_P2_META);
                DIAMOND_CHESTPLATE_P2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,2);
                return DIAMOND_CHESTPLATE_P2;
            case "DIAMOND_CHESTPLATE_P3":
                ItemStack DIAMOND_CHESTPLATE_P3 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta DIAMOND_CHESTPLATE_P3_META = DIAMOND_CHESTPLATE_P3.getItemMeta();
                DIAMOND_CHESTPLATE_P3_META.setUnbreakable(true);
                DIAMOND_CHESTPLATE_P3.setItemMeta(DIAMOND_CHESTPLATE_P3_META);
                DIAMOND_CHESTPLATE_P3.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3);
                return DIAMOND_CHESTPLATE_P3;
            case "CHAINMAIL_LEGGINGS_P2":
                ItemStack CHAINMAIL_LEGGINGS_P2 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta CHAINMAIL_LEGGINGS_P2_META = CHAINMAIL_LEGGINGS_P2.getItemMeta();
                CHAINMAIL_LEGGINGS_P2_META.setUnbreakable(true);
                CHAINMAIL_LEGGINGS_P2.setItemMeta(CHAINMAIL_LEGGINGS_P2_META);
                CHAINMAIL_LEGGINGS_P2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,2);
                return CHAINMAIL_LEGGINGS_P2;
            case "DIAMOND_LEGGINGS":
                ItemStack DIAMOND_LEGGINGS = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta DIAMOND_LEGGINGS_META = DIAMOND_LEGGINGS.getItemMeta();
                DIAMOND_LEGGINGS_META.setUnbreakable(true);
                DIAMOND_LEGGINGS.setItemMeta(DIAMOND_LEGGINGS_META);
                return DIAMOND_LEGGINGS;
            case "DIAMOND_LEGGINGS_P1":
                ItemStack DIAMOND_LEGGINGS_P1 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta DIAMOND_LEGGINGS_P1_META = DIAMOND_LEGGINGS_P1.getItemMeta();
                DIAMOND_LEGGINGS_P1_META.setUnbreakable(true);
                DIAMOND_LEGGINGS_P1.setItemMeta(DIAMOND_LEGGINGS_P1_META);
                DIAMOND_LEGGINGS_P1.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
                return DIAMOND_LEGGINGS_P1;
            case "DIAMOND_LEGGINGS_P2":
                ItemStack DIAMOND_LEGGINGS_P2 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta DIAMOND_LEGGINGS_P2_META = DIAMOND_LEGGINGS_P2.getItemMeta();
                DIAMOND_LEGGINGS_P2_META.setUnbreakable(true);
                DIAMOND_LEGGINGS_P2.setItemMeta(DIAMOND_LEGGINGS_P2_META);
                DIAMOND_LEGGINGS_P2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,2);
                return DIAMOND_LEGGINGS_P2;
            case "IRON_BOOTS_P1":
                ItemStack IRON_BOOTS_P1 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta IRON_BOOTS_P1_META = IRON_BOOTS_P1.getItemMeta();
                IRON_BOOTS_P1_META.setUnbreakable(true);
                IRON_BOOTS_P1.setItemMeta(IRON_BOOTS_P1_META);
                IRON_BOOTS_P1.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
                return IRON_BOOTS_P1;
            case "DIAMOND_BOOTS":
                ItemStack DIAMOND_BOOTS = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta DIAMOND_BOOTS_META = DIAMOND_BOOTS.getItemMeta();
                DIAMOND_BOOTS_META.setUnbreakable(true);
                DIAMOND_BOOTS.setItemMeta(DIAMOND_BOOTS_META);
                return DIAMOND_BOOTS;
            case "DIAMOND_BOOTS_P2":
                ItemStack DIAMOND_BOOTS_P2 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta DIAMOND_BOOTS_P2_META = DIAMOND_BOOTS_P2.getItemMeta();
                DIAMOND_BOOTS_P2_META.setUnbreakable(true);
                DIAMOND_BOOTS_P2.setItemMeta(DIAMOND_BOOTS_P2_META);
                DIAMOND_BOOTS_P2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,2);
                return DIAMOND_BOOTS_P2;
        }
        return null;
    }

    public static void getKit(Player player,String kit) {
        switch (kit) {
            case "Axeman":
                player.getInventory().clear();
                Utils.removeEffects(player);
                player.getInventory().setItem(0, getItem("DIAMOND_AXE"));
                player.getInventory().setHelmet(getItem("IRON_HELMET_P1"));
                player.getInventory().setChestplate(getItem("DIAMOND_CHESTPLATE_P2"));
                player.getInventory().setLeggings(getItem("DIAMOND_LEGGINGS_P1"));
                player.getInventory().setBoots(getItem("IRON_BOOTS_P1"));
                player.addPotionEffect(PotionEffectType.NIGHT_VISION.createEffect(20000000,1));
                Variable.kit.replace(player,1);
                break;
            case "Warrior":
                player.getInventory().clear();
                Utils.removeEffects(player);
                player.getInventory().setItem(0, getItem("DIAMOND_SWORD_S3"));
                player.getInventory().setHelmet(getItem("DIAMOND_HELMET"));
                player.getInventory().setChestplate(getItem("DIAMOND_CHESTPLATE"));
                player.getInventory().setLeggings(getItem("DIAMOND_LEGGINGS"));
                player.getInventory().setBoots(getItem("DIAMOND_BOOTS"));
                player.addPotionEffect(PotionEffectType.NIGHT_VISION.createEffect(20000000,1));
                Variable.kit.replace(player,2);
                break;
            case "Beast":
                player.getInventory().clear();
                Utils.removeEffects(player);
                player.getInventory().setItem(0, getItem("DIAMOND_SWORD"));
                player.getInventory().setHelmet(getItem("DIAMOND_HELMET_P1"));
                player.getInventory().setChestplate(getItem("DIAMOND_CHESTPLATE_P2"));
                player.getInventory().setLeggings(getItem("DIAMOND_LEGGINGS_P2"));
                player.getInventory().setBoots(getItem("DIAMOND_BOOTS_P2"));
                player.addPotionEffect(PotionEffectType.NIGHT_VISION.createEffect(20000000,1));
                Variable.kit.replace(player,3);
                break;
            case "Runner":
                player.getInventory().clear();
                Utils.removeEffects(player);
                player.getInventory().setItem(0, getItem("DIAMOND_SWORD"));
                player.getInventory().setHelmet(getItem("CHAINMAIL_HELMET_P1"));
                player.getInventory().setChestplate(getItem("DIAMOND_CHESTPLATE_P3"));
                player.getInventory().setLeggings(getItem("CHAINMAIL_LEGGINGS_P2"));
                player.getInventory().setBoots(getItem("DIAMOND_BOOTS_P2"));
                player.addPotionEffect(PotionEffectType.NIGHT_VISION.createEffect(20000000,1));
                player.addPotionEffect(PotionEffectType.SPEED.createEffect(20000000,1));
                Variable.kit.replace(player,4);
                break;
        }

    }
}
