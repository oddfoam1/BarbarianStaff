package main.oddfoam.barbarianstaff.command;

import main.oddfoam.barbarianstaff.player.staff.StaffManager;
import main.oddfoam.barbarianstaff.util.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffCommand implements CommandExecutor {

    private StaffManager staffManager;

    public StaffCommand(StaffManager staffManager) {
        this.staffManager = staffManager;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("staffmode")) {
                if (args.length == 0) {
                    if (player.hasPermission("barbarianstaff.command") || player.isOp()) {
                        staffManager.staffMode(player);
                        return true;
                    } else {

                        player.sendMessage(CC.chat("&cYou do not have permission to use this command."));
                    }
                }
            }


        } else {

            sender.sendMessage(CC.chat("&cYou can not use this command."));

        }


        return false;
    }
}