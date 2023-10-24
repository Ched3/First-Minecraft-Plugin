package firstplugin.firstplugin;

import firstplugin.firstplugin.commands.Fly;
import firstplugin.firstplugin.commands.Menu;
import firstplugin.firstplugin.handlers.PlayerHandler;
import firstplugin.firstplugin.handlers.TorchHandler;
import firstplugin.firstplugin.util.ConfigUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class FirstPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getLogger().info("Hello World");

        saveDefaultConfig();

        List<String> kitItems = (List<String>) getConfig().getList("kit");
        for(String itemName: kitItems){
            Bukkit.getLogger().info(itemName);
        }

        ConfigUtil config = new ConfigUtil(this,"test.yml");
        config.getConfig().set("hello","world");
        config.save();


        getCommand("fly").setExecutor(new Fly());
        getCommand("menu").setExecutor(new Menu(this));

        new TorchHandler(this);
        new PlayerHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Shutting down");
    }
}
