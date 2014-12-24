package io.github.minixc.allleafsdecay;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class AllLeafsDecay extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("onEnable has been invoked!");
    }

    @EventHandler
    public void leafPlaced(BlockPlaceEvent event) {
        Block block = event.getBlock();
        if (block.getType() == Material.LEAVES) {
            getLogger().info(block.getData() + "");
        }
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll((Plugin) this);
        getLogger().info("onDisable has been invoked!");
    }
}
