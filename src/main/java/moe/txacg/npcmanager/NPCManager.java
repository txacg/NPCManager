package moe.txacg.npcmanager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.HandlerList;


public class NPCManager extends JavaPlugin{

    public static NPCManager instance = null;
    public Configuration cfg = null;

    @Override
    public void onEnable(){

        instance = this;
        cfg = new Configuration(this);
        cfg.load();
    }

    @Override
    public void onDisable(){

        HandlerList.unregisterAll(this);
        getServer().getScheduler().cancelTasks(this);
        cfg.save();
    }

    public void doReload(){

        HandlerList.unregisterAll(this);
        getServer().getScheduler().cancelTasks(this);
        onEnable();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if (command.getName().equalsIgnoreCase("npcmanager") && sender instanceof Player){
            Player player = (Player) sender;
            player.sendRawMessage("Hi!" + player.getName() + "~");

            return true;
        }


        return false;
    }
}
