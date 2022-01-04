package com.github.cyberryan1.servercore18.features.teleport;

import com.github.cyberryan1.cybercore.utils.CoreUtils;
import com.github.cyberryan1.servercore18.features.BaseCommand;
import com.github.cyberryan1.servercore18.lists.PermissionMessages;
import com.github.cyberryan1.servercore18.lists.Permissions;
import com.github.cyberryan1.servercore18.lists.Usages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class TeleportHereOverrideCommand extends BaseCommand {

    public TeleportHereOverrideCommand() {
        super( "tphere", Permissions.TELEPORT_OVERRIDE_HERE, PermissionMessages.TELEPORT_OVERRIDE_HERE, Usages.TELEPORT_OVERRIDE_HERE );
    }


    @Override
    public List<String> onTabComplete( CommandSender sender, Command command, String label, String[] args ) {
        if ( permissionsAllowed( sender ) ) {
            if ( args.length == 0 ) {
                return getAllOnlinePlayerNames();
            }
            else if ( args.length == 1 ) {
                return matchOnlinePlayers( args[0] );
            }
        }
        return null;
    }

    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args ) {

        if ( permissionsAllowed( sender ) == false ) {
            sendPermissionMsg( sender );
            return true;
        }

        else if ( demandPlayer( sender ) ) {
            if ( args.length >= 1 ) {
                if ( CoreUtils.isValidUsername( args[0] ) ) {
                    Player target = Bukkit.getPlayer( args[0] );
                    if ( target != null ) {
                        Player player = ( Player ) sender;
                        target.teleport( player.getLocation() );
                        player.sendMessage( getColorizedStr( "&uForce teleported &y" + target.getName() + "&u to you" ) );
                        TeleportUtils.sendTeleportNotif( player, target, TeleportUtils.TPOHERE_NOTIF );
                    }

                    else {
                        sendInvalidPlayerArg( sender, args[0] );
                    }
                }

                else {
                    sendInvalidPlayerArg( sender, args[0] );
                }
            }

            else {
                sendUsage( sender );
            }
        }

        return true;
    }
}