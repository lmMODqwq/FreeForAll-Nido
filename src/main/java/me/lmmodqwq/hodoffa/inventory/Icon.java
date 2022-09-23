package me.lmmodqwq.hodoffa.inventory;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Icon {

    public final ItemStack itemStack;
    public final List<ClickAction> clickActions;

    public Icon(ItemStack itemStack) {
        this.clickActions = new ArrayList<>();
        this.itemStack = itemStack;
    }

    public Icon addClickAction(ClickAction clickAction) {
        this.clickActions.add(clickAction);
        return this;
    }

    public List<ClickAction> getClickActions() {
        return this.clickActions;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }
}
