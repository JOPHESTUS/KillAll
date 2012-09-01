package us.jophest.killall;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class KillAll extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	PluginDescriptionFile pdfFile;
	public static KillAll plugin;

	public void onEnable() {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		// TODO Auto-generated method stub

		if (command.getName().equalsIgnoreCase("killallp")) {
			if (sender.hasPermission("killall.all")) {
				for (Player plr : Bukkit.getServer().getOnlinePlayers())
					if (!plr.hasPermission("killall.immune")){
						plr.setHealth(0);
					}
				sender.sendMessage(ChatColor.GREEN + "Killed all players");
				return true;
			}
		}
				

		return super.onCommand(sender, command, label, args);

	}

	public void onDisable() {

		pdfFile = this.getDescription();
		this.log.info(pdfFile.getName() + " is now disabled!");
	}
}