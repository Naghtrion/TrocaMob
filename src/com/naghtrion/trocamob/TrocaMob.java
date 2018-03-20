package com.naghtrion.trocamob;

import com.naghtrion.trocamob.listener.SpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import org.bukkit.event.Listener;

public class TrocaMob extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents((Listener) new SpawnEvent(this), this);
        getLogger().log(Level.INFO, "Plugin iniciado com sucesso!");
    }

    @Override
    public void onDisable()
    {
        getLogger().log(Level.INFO, "Plugin desligado com sucesso!");
    }
}
