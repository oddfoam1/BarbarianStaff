package main.oddfoam.barbarianstaff.player.staff;

import main.oddfoam.barbarianstaff.util.Mode;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.security.PrivateKey;
import java.util.UUID;

public class StaffHandler {

    private UUID uuid;

    private boolean isStaffMode;

    private Mode mode;


    public StaffHandler(UUID uuid, boolean isStaffMode) {

        this.isStaffMode = isStaffMode;

        this.uuid = uuid;

    }

    public Mode getMode() {

        Player p = Bukkit.getPlayer(uuid);
        if (p.hasPermission("barbarianadmin.command")) {

            return Mode.ADMIN;
        } else  if (p.hasPermission("barbarianstaff.command")) {

            return Mode.STAFF;
        }

        return Mode.DEFAULT;
    }

    public boolean isStaffMode() {
        return isStaffMode;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setStaffMode(boolean staffMode) {
        isStaffMode = staffMode;
    }


}
