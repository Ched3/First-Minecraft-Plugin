package firstplugin.firstplugin.commands;

import firstplugin.firstplugin.FirstPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Listener, CommandExecutor {

    public Menu(FirstPlugin plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onIntentoryClick(InventoryClickEvent event){
        if(!event.getView().getTitle().equals(invName)){
            return;
        }

        Player player = (Player) event.getWhoClicked();

        if(event.getSlot() == 11){
            Inventory inv = player.getInventory();

            if(inv.containsAtLeast(new ItemStack(Material.DIAMOND), 5)) {
                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                inv.removeItem(diamond);

                ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
                ItemMeta meta = item.getItemMeta();
                meta.addEnchant(Enchantment.KNOCKBACK, 15, true);
                item.setItemMeta(meta);

                inv.addItem(item);
            }
            else{
                player.sendMessage("You don't have enough diamonds.");
            }
        }
        event.setCancelled(true);
    }
    private String invName = "Server Selector";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Only players can run this command");
            return true;
        }

        Player player = (Player) sender;

        Inventory inv = Bukkit.createInventory(player, 9 * 3, invName);

        inv.setItem(11, getItem(new ItemStack(Material.BLAZE_ROD),"&eKnockback 15 Blaze Rod","&bCost:", "&b5 Diamonds"));
        inv.setItem(13, getItem(new ItemStack(Material.BEACON),"&9Beacon","&aClick to Join", "&aWeekly build Competition"));
        inv.setItem(15, getItem(new ItemStack(Material.GRASS_BLOCK),"&9Skyblock","&aClick to Join", "&aSkeeblook"));

        player.openInventory(inv);

        return true;
    }

    private ItemStack getItem(ItemStack item, String name, String ... lore){
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        List<String> lores = new ArrayList<>();
        for(String s: lore){
            lores.add(ChatColor.translateAlternateColorCodes('&',s));
        }
        meta.setLore(lores);

        item.setItemMeta(meta);
        return item;
    }

}
