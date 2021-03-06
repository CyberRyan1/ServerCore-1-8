package com.github.cyberryan1.servercore18.features.hunger;

import com.github.cyberryan1.servercore18.utils.yml.YMLUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class HungerEvents implements Listener {

    private static boolean HUNGER_ENABLED = YMLUtils.getConfig().getBool( "features.no-hunger" );

    @EventHandler
    public void onHungerChange( FoodLevelChangeEvent event ) {
        if ( HUNGER_ENABLED ) {
            event.setFoodLevel( 20 );
        }
    }
}