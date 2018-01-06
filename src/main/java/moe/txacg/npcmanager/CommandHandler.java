package moe.txacg.npcmanager;

import moe.txacg.npcmanager.edit.EditCommands;
import moe.txacg.npcmanager.me.MeCommands;

import cat.nyaa.nyaacore.CommandReceiver;
import cat.nyaa.nyaacore.LanguageRepository;
import org.bukkit.command.CommandSender;


public class CommandHandler extends CommandReceiver {

    @SubCommand("edit")
    public EditCommands editCommands;

    @SubCommand("me")
    public MeCommands meCommands;


    private final NPCManager plugin;

    public CommandHandler(NPCManager plugin, LanguageRepository i18n){

        super(plugin, i18n);
        this.plugin = plugin;
    }

    @Override
    public String getHelpPrefix() {
        return "";
    }

    @SubCommand(value = "spawn", permission = "nm.spawn")
    public void commandSpawn(CommandSender sender, Arguments args){

    }

    @SubCommand(value = "info", permission = "nm.info")
    public void commandInfo(CommandSender sender, Arguments args){

    }

    @SubCommand(value = "remove", permission = "nm.remove")
    public void commandRemove(CommandSender sender, Arguments args){

    }

    @SubCommand(value = "import", permission = "nm.import")
    public void commandImport(CommandSender sender, Arguments args){

    }

    /* Reload the plugin */

    @SubCommand(value = "reload", permission = "nm.reload")
    public void commandReload(CommandSender sender, Arguments args){

        plugin.doReload();
    }

    @SubCommand(value = "version", permission = "nm.version")
    public void commandVersion(CommandSender sender, Arguments args){


        sender.sendMessage(plugin.getDescription().getVersion());
    }

}
