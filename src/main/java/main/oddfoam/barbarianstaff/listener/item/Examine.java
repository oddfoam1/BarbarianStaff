package main.oddfoam.barbarianstaff.listener.item;

import main.oddfoam.barbarianstaff.player.staff.StaffHandler;
import main.oddfoam.barbarianstaff.player.staff.StaffManager;
import main.oddfoam.barbarianstaff.util.CC;
import main.oddfoam.barbarianstaff.util.Mode;
import main.oddfoam.barbarianstaff.util.items.StaffItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class Examine implements Listener {

    private StaffManager staffManager;

    public Examine(StaffManager staffManager) {

        this.staffManager = staffManager;

    }

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent event) {

        Player player = event.getPlayer();

        if (staffManager.isInStaffMode(player)) {

            if (player.getItemInHand().getType() == StaffItems.EXAMINE_ITEM.getType()) {
                if (player.getItemInHand().hasItemMeta()) {
                    if (player.getItemInHand().getItemMeta().hasLore() && player.getItemInHand().getItemMeta().hasDisplayName()) {
                        if (event.getRightClicked() instanceof Player) {

                            Player targetPlayer = (Player) event.getRightClicked();
                            customInventory(player, targetPlayer);
                        }

                    }
                }
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (event.getWhoClicked() instanceof Player) {

            Player player = (Player) event.getWhoClicked();

            UUID uuid = player.getUniqueId();
            if (staffManager.isInStaffMode(player)) {


                if (staffManager.getPlayer(uuid).getMode() == Mode.DEFAULT)
                    return;

                if (staffManager.getPlayer(uuid).getMode() == Mode.STAFF) {


                    if (event.getCurrentItem() != null) {

                        event.setCancelled(true);


                    }
                }

            }
        }

    }

    public Inventory customInventory(Player player, Player targetPlayer) {

        Inventory inventory = Bukkit.createInventory(player, 54, CC.chat("&a" + targetPlayer.getName() + " &7Inventory"));

        ItemStack[] items = targetPlayer.getInventory().getContents();

        for (int i = 0; i < items.length; i++) {

            if (items[i] != null) {

                inventory.setItem(i, items[i]);

            }

        }

        player.openInventory(inventory);

        return inventory;

    }
}
