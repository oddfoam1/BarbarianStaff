package main.oddfoam.barbarianstaff;

import main.oddfoam.barbarianstaff.command.FollowCommand;
import main.oddfoam.barbarianstaff.command.StaffCommand;
import main.oddfoam.barbarianstaff.listener.Items;
import main.oddfoam.barbarianstaff.listener.Join;
import main.oddfoam.barbarianstaff.listener.item.Examine;
import main.oddfoam.barbarianstaff.listener.Invincible;
import main.oddfoam.barbarianstaff.listener.item.Follow;
import main.oddfoam.barbarianstaff.listener.item.RandomTeleport;
import main.oddfoam.barbarianstaff.listener.item.StaffOnline;
import main.oddfoam.barbarianstaff.listener.item.manager.FollowManager;
import main.oddfoam.barbarianstaff.player.staff.StaffManager;
import main.oddfoam.barbarianstaff.util.items.StaffItems;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BarbarianStaff extends JavaPlugin {


    private FollowManager followManager;
    private static BarbarianStaff instance;
    private StaffItems items;
    private StaffManager staffManager;
    @Override
    public void onEnable() {

        followManager = new FollowManager();
        items = new StaffItems();

        instance = this;

        staffManager = new StaffManager();

        registerCommands();
        registerListeners();

        getLogger().info(this.getName() + " has enabled. version " + this.getDescription().getVersion());
    }

    public static BarbarianStaff getInstance() {
        return instance;
    }



    private void registerListeners() {

        Bukkit.getPluginManager().registerEvents(new Join(staffManager), this);
        Bukkit.getPluginManager().registerEvents(new Invincible(staffManager), this);
        Bukkit.getPluginManager().registerEvents(new RandomTeleport(staffManager), this);
        Bukkit.getPluginManager().registerEvents(new Examine(staffManager), this);
        Bukkit.getPluginManager().registerEvents(new Items(staffManager), this);
        Bukkit.getPluginManager().registerEvents(new Follow(staffManager, followManager), this);
        Bukkit.getPluginManager().registerEvents(new StaffOnline(staffManager), this);
    }
    private void registerCommands() {

        this.getCommand("staffmode").setExecutor(new StaffCommand(staffManager));
        this.getCommand("unfollow").setExecutor(new FollowCommand(followManager));

    }
    @Override
    public void onDisable() {

    }
}
