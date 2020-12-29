package main.oddfoam.barbarianstaff.listener;

import main.oddfoam.barbarianstaff.BarbarianStaff;
import main.oddfoam.barbarianstaff.player.StaffInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.UUID;

public class Invincible implements Listener {

    private StaffInventory staffInventory;

    public Invincible(StaffInventory staffInventory) {
        this.staffInventory = staffInventory;
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {


        if (e.getEntity() instanceof Player) {

            Player player = (Player) e.getEntity();

            if (staffInventory.isInStaffMode(player)) {

                if (e.getDamager() instanceof Player) {

                    Player damage = (Player) e.getDamager();

                    e.setCancelled(true);

            }
        }

    }
    }

}
