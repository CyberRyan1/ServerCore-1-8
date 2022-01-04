package com.github.cyberryan1.servercore18;

import com.github.cyberryan1.cybercore.CyberCore;
import com.github.cyberryan1.cybercore.utils.VaultUtils;
import com.github.cyberryan1.servercore18.features.broadcast.BroadcastCommand;
import com.github.cyberryan1.servercore18.features.enderchest.EnderchestCommand;
import com.github.cyberryan1.servercore18.features.flight.FlightCommand;
import com.github.cyberryan1.servercore18.features.gamemode.*;
import com.github.cyberryan1.servercore18.features.hunger.HungerEvents;
import com.github.cyberryan1.servercore18.features.invsee.InvseeCommand;
import com.github.cyberryan1.servercore18.features.rules.RulesCommand;
import com.github.cyberryan1.servercore18.features.teleport.*;
import com.github.cyberryan1.servercore18.features.workbench.WorkbenchCommand;
import com.github.cyberryan1.servercore18.features.worldborder.WorldborderSetup;
import com.github.cyberryan1.servercore18.utils.yml.YMLUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerCore18 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Initialize things
        CyberCore.setPlugin( this );
        new VaultUtils();

        // Update or reload config/data files
        YMLUtils.getConfig().getYMLManager().reloadConfig();
        YMLUtils.getConfig().getYMLManager().updateConfig();
        YMLUtils.getData().getYMLManager().reloadConfig();
        YMLUtils.getData().sendPathNotFoundWarns( false );

        // Register commands
        registerAllCommands();
        // Register events
        registerAllEvents();

        // Setup worldborders
        new WorldborderSetup();
    }

    private void registerAllCommands() {
        AdventureCommand adventureCommand = new AdventureCommand();
        this.getCommand( "gma" ).setExecutor( adventureCommand );
        this.getCommand( "gma" ).setTabCompleter( adventureCommand );
        CreativeCommand creativeCommand = new CreativeCommand();
        this.getCommand( "gmc" ).setExecutor( creativeCommand );
        this.getCommand( "gmc" ).setTabCompleter( creativeCommand );
        SpectatorCommand spectatorCommand = new SpectatorCommand();
        this.getCommand( "gmsp" ).setExecutor( spectatorCommand );
        this.getCommand( "gmsp" ).setTabCompleter( spectatorCommand );
        SurvivalCommand survivalCommand = new SurvivalCommand();
        this.getCommand( "gms" ).setExecutor( survivalCommand );
        this.getCommand( "gms" ).setTabCompleter( survivalCommand );

        FlightCommand flightCommand = new FlightCommand();
        this.getCommand( "flight" ).setExecutor( flightCommand );
        this.getCommand( "flight" ).setTabCompleter( flightCommand );

        TeleportCommand teleportCommand = new TeleportCommand();
        this.getCommand( "tp" ).setExecutor( teleportCommand );
        this.getCommand( "tp" ).setTabCompleter( teleportCommand );
        TeleportHereCommand teleportHereCommand = new TeleportHereCommand();
        this.getCommand( "tphere" ).setExecutor( teleportHereCommand );
        this.getCommand( "tphere" ).setTabCompleter( teleportHereCommand );
        TeleportOverrideCommand teleportOverrideCommand = new TeleportOverrideCommand();
        this.getCommand( "tpo" ).setExecutor( teleportOverrideCommand );
        this.getCommand( "tpo" ).setTabCompleter( teleportOverrideCommand );
        TeleportHereOverrideCommand teleportHereOverrideCommand = new TeleportHereOverrideCommand();
        this.getCommand( "tpohere" ).setExecutor( teleportHereOverrideCommand );
        this.getCommand( "tpohere" ).setTabCompleter( teleportHereOverrideCommand );
        TeleportToggleCommand teleportToggleCommand = new TeleportToggleCommand();
        this.getCommand( "tptoggle" ).setExecutor( teleportToggleCommand );
        this.getCommand( "tptoggle" ).setTabCompleter( teleportToggleCommand );

        WorkbenchCommand workbenchCommand = new WorkbenchCommand();
        this.getCommand( "workbench" ).setExecutor( workbenchCommand );
        this.getCommand( "workbench" ).setTabCompleter( workbenchCommand );

        EnderchestCommand enderchestCommand = new EnderchestCommand();
        this.getCommand( "enderchest" ).setExecutor( enderchestCommand );
        this.getCommand( "enderchest" ).setTabCompleter( enderchestCommand );

        InvseeCommand invseeCommand = new InvseeCommand();
        this.getCommand( "invsee" ).setExecutor( invseeCommand );
        this.getCommand( "invsee" ).setTabCompleter( invseeCommand );

        BroadcastCommand broadcastCommand = new BroadcastCommand();
        this.getCommand( "broadcast" ).setExecutor( broadcastCommand );
        this.getCommand( "broadcast" ).setTabCompleter( broadcastCommand );

        RulesCommand rulesCommand = new RulesCommand();
        this.getCommand( "rules" ).setExecutor( rulesCommand );
        this.getCommand( "rules" ).setTabCompleter( rulesCommand );
    }

    private void registerAllEvents() {
        this.getServer().getPluginManager().registerEvents( new HungerEvents(), this );
    }
}
