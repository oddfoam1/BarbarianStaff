package main.oddfoam.barbarianstaff.listener.item;

import main.oddfoam.barbarianstaff.player.staff.StaffManager;
import main.oddfoam.barbarianstaff.util.items.StaffItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PushForward implements Listener {

    private StaffManager staffManager;

    public PushForward(StaffManager staffManager) {
        this.staffManager = staffManager;
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (staffManager.isInStaffMode(player)) {

            if (player.getItemInHand().getType() == StaffItems.PUSH_FORWARD_ITEM.getType()) {
                if (player.getItemInHand().hasItemMeta()) {
                    if (player.getItemInHand().getItemMeta().hasLore() && player.getItemInHand().getItemMeta().hasDisplayName()) {
                        if (event.getAction() == Action.RIGHT_CLICK_AIR) {

                        }
                    }
                }
            }
        }
    }
}