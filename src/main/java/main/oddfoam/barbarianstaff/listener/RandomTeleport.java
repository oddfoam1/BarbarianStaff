package main.oddfoam.barbarianstaff.listener;

import main.oddfoam.barbarianstaff.player.StaffInventory;
import main.oddfoam.barbarianstaff.util.CC;
import main.oddfoam.barbarianstaff.util.StaffItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Random;

public class RandomTeleport implements Listener {

    private StaffInventory staffInventory;

    public RandomTeleport(StaffInventory staffInventory) {
        this.staffInventory = staffInventory;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        ArrayList<Player> players = new ArrayList<>();

        Player player = event.getPlayer();

        if (staffInventory.isInStaffMode(player)) {

            if (player.getItemInHand().getType() == StaffItems.RANDOM_TELEPORT_ITEM.getType()) {
                if (player.getItemInHand().hasItemMeta()) {
                    if (player.getItemInHand().getItemMeta().hasLore() && player.getItemInHand().getItemMeta().hasDisplayName()) {
                        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK ||
                                event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {

                            int size = Bukkit.getOnlinePlayers().size();

                            for (Player p : Bukkit.getOnlinePlayers()) {

                                players.add(p);

                                if (players.contains(player)) {

                                    players.remove(player);
                                }

                            }

                            if (3 <= players.size()) {

                                Random r = new Random();

                                int randomInt = r.nextInt(size);

                                Player randomPlayer = players.get(randomInt);

                                player.teleport(randomPlayer);

                                player.sendMessage(CC.chat("&bYou have teleported to &7" + randomPlayer.getName() + "&b!"));


                                return;
                            } else if (players.size() == 1) {

                                player.sendMessage(CC.chat("&7can't use random teleport. need more than &b" + players.size() + " &7player online."));

                                return;

                            } else {
                                player.sendMessage(CC.chat("&7can't use random teleport. need more than &b" + players.size() + " &7players online."));

                                return;

                            }
                        }
                    }
                }
            }

        }
    }
}
