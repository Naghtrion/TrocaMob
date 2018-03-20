package com.naghtrion.trocamob.listener;

import com.naghtrion.trocamob.TrocaMob;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SpawnEvent implements Listener
{
    public TrocaMob main;

    public SpawnEvent(TrocaMob main)
    {
        this.main = main;
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e)
    {
        if (main.getConfig().getStringList("spawnreason").contains(e.getSpawnReason().toString()))
        {
            if (main.getConfig().getStringList("mundos").contains(e.getLocation().getWorld().getName()))
            {
                for (String mob : main.getConfig().getStringList("mobs"))
                {
                    String[] mob_part = mob.split(":");
                    if (e.getEntityType().equals(EntityType.valueOf(mob_part[0])))
                    {
                        e.setCancelled(true);
                        EntityType type = EntityType.valueOf(mob_part[1]);
                        if (type != null && type.isSpawnable())
                        {
                            e.getLocation().getWorld().spawnEntity(e.getLocation(), type);
                        }
                        break;
                    }
                }
            }
        }
    }
}
