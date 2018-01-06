package moe.txacg.npcmanager;

import cat.nyaa.nyaacore.configuration.PluginConfigure;
import org.bukkit.plugin.java.JavaPlugin;



public class Configuration extends PluginConfigure{

    private final NPCManager plugin;

    /* Basic plugin & database config */
    /* 基礎的插件與資料庫設定 */

    @Serializable
    public String language = "en_US";
    @Serializable
    public Boolean allow_playernpc = false;
    @Serializable
    public Boolean use_mysql = true;





    public Configuration(NPCManager plugin) {
        this.plugin = plugin;
    }

    @Override
    protected JavaPlugin getPlugin() {
        return plugin;
    }
}
