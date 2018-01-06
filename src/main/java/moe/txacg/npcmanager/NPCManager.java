package moe.txacg.npcmanager;

import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.HandlerList;


public class NPCManager extends JavaPlugin{

    public static NPCManager instance = null;
    public Configuration cfg = null;
    public I18n i18n;
    public CommandHandler commandHandler;

    @Override
    public void onEnable(){

        instance = this;

        cfg = new Configuration(this);
        cfg.load();

        i18n = new I18n(this, cfg.language);

        commandHandler = new CommandHandler(this, i18n);
        getCommand("npcmanager").setExecutor(commandHandler);
        getCommand("npcmanager").setTabCompleter((TabCompleter) commandHandler);
    }

    @Override
    public void onDisable(){

        HandlerList.unregisterAll(this);
        getServer().getScheduler().cancelTasks(this);

        getCommand("npcmanager").setExecutor(null);
        getCommand("npcmanager").setTabCompleter(null);

        cfg.save();
    }

    public void doReload(){

        HandlerList.unregisterAll(this);
        getServer().getScheduler().cancelTasks(this);

        getCommand("npcmanager").setExecutor(null);
        getCommand("npcmanager").setTabCompleter(null);

        i18n.load();

        onEnable();
    }

}
