package com.github.cyberryan1.servercore18.features.gamemode;

import com.github.cyberryan1.cybercore.utils.CoreUtils;
import com.github.cyberryan1.servercore18.features.BaseCommand;
import com.github.cyberryan1.servercore18.lists.PermissionMessages;
import com.github.cyberryan1.servercore18.lists.Permissions;
import com.github.cyberryan1.servercore18.lists.Usages;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class SurvivalCommand extends BaseCommand {

    public SurvivalCommand() {
        super( "gms", Permissions.GAMEMODE_SURVIVAL, PermissionMessages.GAMEMODE_SURVIVAL, Usages.GAMEMODE_SURVIVAL );
    }

    @Override
    public List<String> onTabComplete( CommandSender sender, Command command, String label, String[] args ) {
        if ( args.length <= 1 ) {
            if ( args.length == 0 ) { return getAllOnlinePlayerNames(); }
            return matchOnlinePlayers( args[0] );
        }
        return null;
    }

    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args ) {

        if ( permissionsAllowed( sender ) == false ) {
            sendPermissionMsg( sender );
            return true;
        }

        else if ( args.length == 0 ) { // /gmc
            if ( demandPlayer( sender ) == false ) {
                return true;
            }

            Player player = ( Player ) sender;
            player.setGameMode( GameMode.SURVIVAL );
            sender.sendMessage( getColorizedStr( "&uYour gamemode has been set to &ySURVIVAL" ) );
        }

        else { // /gmc [player]
            if ( CoreUtils.isValidUsername( args[0] ) ) {
                Player target = Bukkit.getPlayer( args[0] );
                if ( target != null ) {
                    target.setGameMode( GameMode.SURVIVAL );
                    sender.sendMessage( getColorizedStr( "&uSet &y" + target.getName() + "&u's gamemode to &ySURVIVAL" ) );
                }

                else {
                    sendInvalidPlayerArg( sender, args[0] );
                }
            }

            else {
                sendInvalidPlayerArg( sender, args[0] );
            }
        }

        return true;
    }
}