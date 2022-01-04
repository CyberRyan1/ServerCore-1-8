package com.github.cyberryan1.servercore18.features.rules;

import com.github.cyberryan1.servercore18.features.BaseCommand;
import com.github.cyberryan1.servercore18.utils.yml.YMLUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class RulesCommand extends BaseCommand {

    public RulesCommand() {
        super( "rules", null, null, null );
    }

    @Override
    public List<String> onTabComplete( CommandSender sender, Command command, String label, String[] args ) {
        return null;
    }

    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args ) {

        String rules[] = YMLUtils.getConfig().getColoredStrList( "commands.rules.rules-message" );
        sender.sendMessage( rules );

        return true;
    }
}