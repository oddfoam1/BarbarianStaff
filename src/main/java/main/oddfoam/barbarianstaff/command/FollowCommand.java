package main.oddfoam.barbarianstaff.command;

import main.oddfoam.barbarianstaff.listener.item.Follow;
import main.oddfoam.barbarianstaff.listener.item.manager.FollowManager;
import main.oddfoam.barbarianstaff.util.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class FollowCommand implements CommandExecutor {

    private FollowManager follow;
    public FollowCommand(FollowManager follow) {
        this.follow = follow;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            UUID uuid = player.getUniqueId();
            if (cmd.getName().equalsIgnoreCase("unfollow")) {
                if (args.length == 0) {
                    if (player.hasPermission("barbarianstaff.command") || player.isOp()) {
                        if (follow.selected.containsValue(uuid)) {

                            for (UUID uuid1 : follow.locations.keySet()) {

                                follow.selected.remove(uuid1, uuid);
                            }

                            player.sendMessage(CC.chat("&aYou are no longer following this player!"));


                        } else {

                            player.sendMessage(CC.chat("&6You are not following a player!"));

                        }
                        return true;
                    } else {
                        return false;
                    }
                }

            }
        }

        return false;
    }
}