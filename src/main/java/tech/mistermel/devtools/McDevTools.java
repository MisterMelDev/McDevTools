package tech.mistermel.devtools;

import java.util.stream.Stream;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import tech.mistermel.devtools.cmd.CommandHandler;
import tech.mistermel.devtools.cmd.LoadSubCommand;
import tech.mistermel.devtools.cmd.ReloadSubCommand;
import tech.mistermel.devtools.cmd.UnloadSubCommand;

public class McDevTools extends JavaPlugin {
	
	@Override
	public void onEnable() {
		CommandHandler cmdHandler = new CommandHandler();
		cmdHandler.registerSubCommand("load", new LoadSubCommand());
		cmdHandler.registerSubCommand("reload", new ReloadSubCommand());
		cmdHandler.registerSubCommand("unload", new UnloadSubCommand());
		
		this.getCommand("dev").setExecutor(cmdHandler);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public Stream<Player> getNotifyPlayers() {
		return this.getServer().getOnlinePlayers().stream()
				.filter(player -> player.hasPermission("mcdevtools.notify"))
				.map(player -> (Player) player);
	}
	
}
