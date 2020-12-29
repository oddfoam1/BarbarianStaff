package main.oddfoam.barbarianstaff.util;

import main.oddfoam.barbarianstaff.util.CC;
import main.oddfoam.barbarianstaff.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class StaffItems {


    public static final ItemStack RANDOM_TELEPORT_ITEM = new ItemBuilder(Material.PRISMARINE_SHARD)
            .name(CC.chat("&b&lRandom Teleport"))
            .lore(CC.chat("&7Teleport to a random person on the server."))
            .build();

    public static final ItemStack EXAMINE_ITEM = new ItemBuilder(Material.FEATHER)
            .name(CC.chat("&a&lExamine"))
            .lore(CC.chat("&7Examines a player inventory."))
            .build();

    public static final ItemStack FREEZE_ITEM = new ItemBuilder(Material.BLAZE_ROD)
            .name(CC.chat("&6&lFreeze"))
            .lore(CC.chat("&7Freezes the player selected."))
            .build();

    public static final ItemStack FOLLOW_ITEM = new ItemBuilder(Material.LEASH)
            .name(CC.chat("&8&lFollow"))
            .lore(CC.chat("&7Follows a player in radius of 15 blocks."))
            .build();

    public static final ItemStack STAFF_ONLINE_ITEM = new ItemBuilder(Material.SKULL_ITEM)
            .name(CC.chat("&d&lStaff Online"))
            .lore(CC.chat("&7See the staff that are online."))
            .build();

    public static final ItemStack PUSH_FORWARD_ITEM = new ItemBuilder(Material.COMPASS)
            .name(CC.chat("&2&lPush Forward"))
            .lore(CC.chat("&7Pushes a player forward"))
            .build();




}
