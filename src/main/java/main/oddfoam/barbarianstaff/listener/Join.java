package main.oddfoam.barbarianstaff.listener;

import main.oddfoam.barbarianstaff.player.staff.StaffManager;
import main.oddfoam.barbarianstaff.util.Mode;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;
import java.util.UUID;

public class Join implements Listener {

    private StaffManager staffManager;

    public Join(StaffManager staffManager) {
        this.staffManager = staffManager;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (staffManager.isInStaffMode(player)) {

            for (Player p : Bukkit.getOnlinePlayers()) {

                if (staffManager.isInStaffMode(p)) {
                    if (staffManager.getPlayer(p.getUniqueId()).getMode() == Mode.STAFF || staffManager.getPlayer(p.getUniqueId()).getMode() == Mode.ADMIN) {

                        player.showPlayer(p);


                    } else {
                        p.hidePlayer(player);

                    }
                }
            }
        }
    }

}

