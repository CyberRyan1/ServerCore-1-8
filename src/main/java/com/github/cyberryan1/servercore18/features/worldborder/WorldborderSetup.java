package com.github.cyberryan1.servercore18.features.worldborder;

import com.github.cyberryan1.servercore18.utils.yml.YMLUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;

import java.util.ArrayList;
import java.util.List;

public class WorldborderSetup {

    private List<World> worlds = new ArrayList<>();

    public WorldborderSetup() {
        List<String> allKeys = YMLUtils.getConfig().getAllKeys();
        for ( String str : allKeys ) {
            if ( str.toLowerCase().startsWith( "features.worldborder." ) ) {
                String s = str.replaceFirst( "features.worldborder.", "" );
                if ( s.contains( "." ) == false ) {
                    World newWorld = Bukkit.getWorld( s );
                    worlds.add( newWorld );
                    setupWorldFromConfig( newWorld );
                }
            }
        }
    }

    private void setupWorldFromConfig( World world ) {
        double x = YMLUtils.getConfig().getDouble( "features.worldborder." + world.getName() + ".center-x" );
        double z = YMLUtils.getConfig().getDouble( "features.worldborder." + world.getName() + ".center-z" );
        int size = YMLUtils.getConfig().getInt( "features.worldborder." + world.getName() + ".size" );

        WorldBorder worldBorder = world.getWorldBorder();
        worldBorder.setCenter( x, z );
        worldBorder.setSize( size );
    }
}