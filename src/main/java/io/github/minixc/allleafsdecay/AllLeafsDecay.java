package io.github.minixc.allleafsdecay;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class AllLeafsDecay extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("onEnable has been invoked!");
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void leafPlaced(BlockPhysicsEvent event) {
        Block block = event.getBlock();
        getLogger().info("Changing leave data from " + block.getData() + " to " + getCheckDecayFromData(block.getData(), block.getType()));
        block.setData(getCheckDecayFromData(block.getData(), block.getType()));
    }

    private byte getCheckDecayFromData(byte data, Material blockMaterial) {
        if (blockMaterial == Material.LEAVES || blockMaterial == Material.LEAVES_2) {
            //explanation at http://minecraft.gamepedia.com/Leaves
            if (data <= 7) {
                data += 4;
                if (data <= 3) {
                    data += 4;
                }
            } else if (data >= 12) {
                data -= 4;
            }
        }
        return data;
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll((Plugin) this);
        getLogger().info("onDisable has been invoked!");
    }
}
