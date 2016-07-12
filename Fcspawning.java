package net.apthos.fcspawning;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
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
    public void onSpawn(EntitySpawnEvent e) {

        Entity entity = e.getEntity();

        if (entity.getType() == EntityType.BAT || entity.getType() == EntityType.BLAZE ||
                entity.getType() == EntityType.CAVE_SPIDER || entity.getType() == EntityType.CHICKEN ||
                entity.getType() == EntityType.COW || entity.getType() == EntityType.CREEPER ||
                entity.getType() == EntityType.ENDER_DRAGON || entity.getType() == EntityType.ENDERMAN ||
                entity.getType() == EntityType.ENDERMITE || entity.getType() == EntityType.GHAST ||
                entity.getType() == EntityType.GUARDIAN || entity.getType() == EntityType.HORSE ||
                entity.getType() == EntityType.IRON_GOLEM || entity.getType() == EntityType.MAGMA_CUBE ||
                entity.getType() == EntityType.MUSHROOM_COW || entity.getType() == EntityType.OCELOT ||
                entity.getType() == EntityType.PIG || entity.getType() == EntityType.PIG_ZOMBIE ||
                entity.getType() == EntityType.RABBIT || entity.getType() == EntityType.SHEEP ||
                entity.getType() == EntityType.SILVERFISH || entity.getType() == EntityType.SKELETON ||
                entity.getType() == EntityType.SLIME || entity.getType() == EntityType.SNOWMAN ||
                entity.getType() == EntityType.SPIDER || entity.getType() == EntityType.SQUID ||
                entity.getType() == EntityType.VILLAGER || entity.getType() == EntityType.WITCH ||
                entity.getType() == EntityType.WOLF || entity.getType() == EntityType.WITHER ||
                entity.getType() == EntityType.ZOMBIE) {

            boolean found = false;

            Location L = entity.getLocation();
            Location Min = L.clone().subtract(9, 9, 9);

            for (int y = 0; y < 18; y++) {
                for (int x = 0; x < 18; x++) {
                    for (int z = 0; z < 18; z++) {
                        if (Min.clone().add(x, y, z).getBlock().getType().equals(Material.MOB_SPAWNER)) {
                            found = true;
                        }
                    }// end of z
                }// end of x
            }// end of y

            if (!found) {
                e.setCancelled(true);
                entity.remove();
            }

        }
        return;
    }

    public void CB(EntityType e) {

    }


}
