package firstplugin.firstplugin.handlers;

import firstplugin.firstplugin.FirstPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.material.Torch;

public class TorchHandler implements Listener {

    //Constructor
    public TorchHandler(FirstPlugin plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onTorchPlace_Low (BlockPlaceEvent event){
        if(event.getBlock().getType() == Material.TORCH){
            event.getBlock().setType(Material.DIAMOND_BLOCK);
            event.setCancelled(true);
        }
    }

    /*@EventHandler(ignoreCancelled = true)
    public void onTorchPlace_Normal(BlockPlaceEvent event) {


        Block block = event.getBlock();

        if(block.getType() == Material.TORCH)
            Bukkit.getLogger().info("A block was placed");
        else if(block.getType() == Material.GRASS_BLOCK)
            Bukkit.getLogger().info("Grass was placed");
    }*/
}
