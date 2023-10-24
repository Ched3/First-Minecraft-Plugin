package firstplugin.firstplugin.handlers;

import firstplugin.firstplugin.FirstPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerHandler implements Listener {

    public PlayerHandler(FirstPlugin plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    /*@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ItemStack item = new ItemStack(Material.ENDER_PEARL,64);
        Inventory inv = player.getInventory();

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Testing");
        meta.addEnchant(Enchantment.KNOCKBACK,100,true);

        item.setItemMeta(meta);

        inv.addItem(item);



    }*/

}
