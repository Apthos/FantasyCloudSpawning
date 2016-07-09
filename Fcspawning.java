package net.apthos.fcspawning;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Fcspawning extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent e){

        Entity entity = e.getEntity();

        boolean found = false;

        Location L = entity.getLocation();
        Location Min = L.clone().subtract( 9, 9, 9 );

        for( int y = 0; y < 18; y++ ){
            for( int x = 0; x < 18; x++ ){
                for( int z = 0; z < 18; z++ ){
                    if( Min.clone().add(x,y,z).getBlock().getType().equals(Material.MOB_SPAWNER ) ){
                        found = true;
                    }
                }// end of z
            }// end of x
        }// end of y

        if( !found ) {
            e.setCancelled( true );
            entity.remove();
        }


        return;
    }


}
