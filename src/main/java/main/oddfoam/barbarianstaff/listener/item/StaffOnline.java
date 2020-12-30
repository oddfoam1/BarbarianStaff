package main.oddfoam.barbarianstaff.listener.item;

import main.oddfoam.barbarianstaff.player.staff.StaffHandler;
import main.oddfoam.barbarianstaff.player.staff.StaffManager;
import main.oddfoam.barbarianstaff.util.CC;
import main.oddfoam.barbarianstaff.util.items.StaffItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.UUID;


public class StaffOnline implements Listener {

    private StaffManager staffManager;

    public StaffOnline(StaffManager staffManager) {
        this.staffManager = staffManager;
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if (staffManager.isInStaffMode(player)) {
            if (player.getItemInHand().getType() == StaffItems.STAFF_ONLINE_ITEM.getType()) {
                if (player.getItemInHand().hasItemMeta()) {
                    if (player.getItemInHand().getItemMeta().hasLore() && player.getItemInHand().getItemMeta().hasDisplayName()) {
                        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK ||
                                event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {

                            createInventory(player);

                        }
                    }

                }
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        if (e.getWhoClicked() instanceof Player) {
            Player player = (Player) e.getWhoClicked();

            if (e.getClickedInventory().getTitle().equalsIgnoreCase(CC.chat("&3Staff Online"))) {
                if (e.getCurrentItem() != null) {

                    String playerName = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());

                    player.sendMessage("h");

                    player.teleport( Bukkit.getPlayer(playerName));
                    player.sendMessage(CC.chat("&aYou have teleported to player " + playerName));

                    e.setCancelled(true);
                }
            }
        }

    }

    private void createInventory(Player player) {

        Inventory inventory = Bukkit.createInventory(player, 54, CC.chat("&3Staff Online"));


        for (UUID uuid : staffManager.getStaff().keySet()) {

            StaffHandler staffHandler = staffManager.getPlayer(uuid);

            if (staffHandler != null) {

                ArrayList<String> lore = new ArrayList<>();

                lore.add(CC.chat("&7StaffMode: &a" + staffHandler.isStaffMode()));
                lore.add(" ");
                lore.add(CC.chat("&eClick to teleport to player."));

                    Player p = Bukkit.getPlayer(staffHandler.getUuid());


                    ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);

                    SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();

                    skullMeta.setDisplayName(CC.chat("&b" + p.getName()));
                    skullMeta.setOwner(p.getName());

                    skullMeta.setLore(lore);
                    itemStack.setItemMeta(skullMeta);

                    inventory.addItem(itemStack);


                player.openInventory(inventory);

            }

        }
    }
}