package main.oddfoam.barbarianstaff;

import main.oddfoam.barbarianstaff.command.StaffCommand;
import main.oddfoam.barbarianstaff.listener.Invincible;
import main.oddfoam.barbarianstaff.listener.RandomTeleport;
import main.oddfoam.barbarianstaff.player.StaffInventory;
import main.oddfoam.barbarianstaff.util.StaffItems;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BarbarianStaff extends JavaPlugin {

    private static BarbarianStaff instance;
    private StaffItems items;
    private StaffInventory staffInventory;
    @Override
    public void onEnable() {

        items = new StaffItems();

        instance = this;

        staffInventory = new StaffInventory();

        registerCommands();
        registerListeners();

        getLogger().info(this.getName() + " has enabled. version " + this.getDescription().getVersion());
    }

    public static BarbarianStaff getInstance() {
        return instance;
    }



    private void registerListeners() {

        Bukkit.getPluginManager().registerEvents(new Invincible(staffInventory), this);
        Bukkit.getPluginManager().registerEvents(new RandomTeleport(staffInventory), this);
    }
    private void registerCommands() {

        this.getCommand("staffmode").setExecutor(new StaffCommand(staffInventory));

    }
    @Override
    public void onDisable() {

    }
}
