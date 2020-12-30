package main.oddfoam.barbarianstaff.listener;

import main.oddfoam.barbarianstaff.player.staff.StaffManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Invincible implements Listener {

    private StaffManager staffManager;

    public Invincible(StaffManager staffManager) {
        this.staffManager = staffManager;
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {


        if (e.getEntity() instanceof Player) {

            Player player = (Player) e.getEntity();

            if (staffManager.isInStaffMode(player)) {

                if (e.getDamager() instanceof Player) {

                    Player damage = (Player) e.getDamager();

                    e.setCancelled(true);

            }
        }

    }
    }

}
