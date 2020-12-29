package main.oddfoam.barbarianstaff.listener;

import main.oddfoam.barbarianstaff.player.StaffInventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RandomTeleport implements Listener {

    private StaffInventory staffInventory;

    public RandomTeleport(StaffInventory staffInventory) {
        this.staffInventory = staffInventory;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if (staffInventory.isInStaffMode(player)) {

            if (player.getItemInHand().getType() == Material.EYE_OF_ENDER) {
                if (player.getItemInHand().hasItemMeta()) {
                    if (player.getItemInHand().getItemMeta().hasLore() && player.getItemInHand().getItemMeta().hasDisplayName()) {
                        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK ||
                                event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {

                            player.sendMessage("hello!");
                        }
                    }
                }
            }

        }
    }
}
