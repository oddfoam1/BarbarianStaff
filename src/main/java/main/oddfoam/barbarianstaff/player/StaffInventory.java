package main.oddfoam.barbarianstaff.player;

import main.oddfoam.barbarianstaff.util.CC;
import main.oddfoam.barbarianstaff.util.StaffItems;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class StaffInventory {

    private HashMap<UUID, ItemStack[]> playerItems = new HashMap<>();

    public ArrayList<UUID> sm = new ArrayList<>();



    public void staffMode(Player player) {


        if (!playerItems.containsKey(player.getUniqueId())) {
            playerItems.put(player.getUniqueId(), getItems(player));

            addPlayer(player);

            player.getInventory().clear();

            setPlayerItems(player);


            player.setGameMode(GameMode.CREATIVE);

            for (Player p : Bukkit.getOnlinePlayers()) {

                if (p.hasPermission("barbarianstaff.command")) {

                    player.showPlayer(p);

                } else {
                    p.hidePlayer(player);

                }


             }

            player.sendMessage(CC.chat("&ayou have entered staff mode."));


        } else {

            if (isInStaffMode(player)) {

                removePlayer(player);
            }
        }


    }

    public void addPlayer(Player player) {
        sm.add(player.getUniqueId());


    }

    public boolean isInStaffMode(Player player) {

        return sm.contains(player.getUniqueId());
    }

    public void removePlayer(Player player) {
        if (sm.contains(player.getUniqueId())) {
            sm.remove(player.getUniqueId());
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.showPlayer(player);
            }
            ItemStack[] items = playerItems.get(player.getUniqueId());

            player.getInventory().clear();
            for (int i = 0; i < items.length; i++) {

                if (items[i] != null) {

                    player.getInventory().setItem(i, items[i]);

                }

            }
            playerItems.remove(player.getUniqueId());
            player.sendMessage(CC.chat("&cYou have removed staff mode."));

        }

    }

    public ItemStack[] getItems(Player player) {

        ItemStack[] items = player.getInventory().getContents();

        return items;
    }

    public void setPlayerItems(Player player) {

        player.getInventory().setItem(0, StaffItems.RANDOM_TELEPORT_ITEM);
        player.getInventory().setItem(1, StaffItems.EXAMINE_ITEM);
        player.getInventory().setItem(3, StaffItems.FOLLOW_ITEM);
        player.getInventory().setItem(5, StaffItems.FREEZE_ITEM);
        player.getInventory().setItem(7, StaffItems.STAFF_ONLINE_ITEM);
        player.getInventory().setItem(8, StaffItems.PUSH_FORWARD_ITEM);

    }

}
