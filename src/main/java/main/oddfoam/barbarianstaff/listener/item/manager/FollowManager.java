package main.oddfoam.barbarianstaff.listener.item.manager;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.UUID;

public class FollowManager {


    public HashMap<UUID, Location> locations = new HashMap<>();
    public HashMap<UUID, UUID> selected = new HashMap<>();

    public HashMap<UUID, Location> getLocations() {
        return locations;
    }


    public HashMap<UUID, UUID> getSelected() {
        return selected;
    }
}
