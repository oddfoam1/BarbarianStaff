package main.oddfoam.barbarianstaff.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {
    private final ItemStack is;

    private final ItemMeta itemMeta;

    public ItemBuilder(final Material mat) {

        is = new ItemStack(mat);
        itemMeta = is.getItemMeta();
    }

    public ItemBuilder name(final String name) {
        itemMeta.setDisplayName(name);
        return this;
    }

    public ItemBuilder lore(final String name) {
        List<String> lore = itemMeta.getLore();
        if (lore == null) {
            lore = new ArrayList<String>();
        }
        lore.add(" ");
        lore.add(name);
        itemMeta.setLore(lore);
        return this;
    }

    public ItemBuilder skull(final String name) {

        if (is.getType() == Material.SKULL_ITEM) {

            SkullMeta skullMeta = (SkullMeta) is;

            skullMeta.setOwner(name);

            is.setItemMeta(skullMeta);
        }

        return this;
    }

    public ItemStack build() {
        is.setItemMeta(itemMeta);
        return is;
    }
}
