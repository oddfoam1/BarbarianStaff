package main.oddfoam.barbarianstaff.listener;

import com.sun.corba.se.impl.protocol.giopmsgheaders.CancelRequestMessage;
import main.oddfoam.barbarianstaff.player.staff.StaffHandler;
import main.oddfoam.barbarianstaff.player.staff.StaffManager;
import main.oddfoam.barbarianstaff.util.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class Items implements Listener {

    private StaffManager staffManager;

    public Items(StaffManager staffManager) {

        this.staffManager = staffManager;

    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {

        Player player = event.getPlayer();

        if (staffManager.isInStaffMode(player)) {

            if (event.getItemDrop() != null) {

                player.sendMessage(CC.chat("&aYou can not drop this item."));
                event.setCancelled(true);



            }
        }


    }

    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {

        Player player = event.getPlayer();

        if (staffManager.isInStaffMode(player)) {


            event.setCancelled(true);

        }
    }

}
