package main.oddfoam.barbarianstaff.listener.item;

import main.oddfoam.barbarianstaff.listener.item.manager.FollowManager;
import main.oddfoam.barbarianstaff.player.staff.StaffManager;
import main.oddfoam.barbarianstaff.util.CC;
import main.oddfoam.barbarianstaff.util.items.StaffItems;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Follow implements Listener {


    private StaffManager staffManager;
    private FollowManager followManager;
    public Follow(StaffManager staffManager, FollowManager followManager) {
        this.staffManager = staffManager;
        this.followManager = followManager;

    }



    // Select a Player, and when there out of a radius cancel.

    @EventHandler
    public void selectPlayer(PlayerInteractAtEntityEvent event) {

        Player player = event.getPlayer();

        if (staffManager.isInStaffMode(player)) {
            if (event.getRightClicked() instanceof Player) {
                Player rightClickedPlayer = (Player) event.getRightClicked();

                if (player.getItemInHand().getType() == StaffItems.FOLLOW_ITEM.getType()) {
                    if (player.getItemInHand().hasItemMeta()) {
                        if (player.getItemInHand().getItemMeta().hasLore() && player.getItemInHand().getItemMeta().hasDisplayName()) {

                            followManager.locations.put(rightClickedPlayer.getUniqueId(), rightClickedPlayer.getLocation());
                            followManager.selected.put(rightClickedPlayer.getUniqueId(), player.getUniqueId());
                            player.sendMessage(CC.chat("&7You are now following &6" + rightClickedPlayer.getName()));


                        }
                    }

                }
            }
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        if (followManager.locations.containsKey(player.getUniqueId())) {


            Location location =  followManager.locations.get(player.getUniqueId());

            if (player.getLocation().distanceSquared(location) > 15 * 15) {
                if (followManager.selected.containsKey(player.getUniqueId())) {


                    UUID uuid =   followManager.selected.get(player.getUniqueId());

                    Player p = Bukkit.getPlayer(uuid);

                    p.teleport(player);
                    p.sendMessage(CC.chat("&aPlayer has walked out of the radius. teleported."));
                    p.sendMessage(CC.chat("&7To stop following this player type &6/unfollow"));

                    followManager.locations.remove(player.getUniqueId());
                    followManager.locations.put(player.getUniqueId(), p.getLocation());



                }
            }


        }


    }


}
