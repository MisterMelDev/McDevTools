package tech.mistermel.devtools.cmd;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class CommandHandler implements CommandExecutor, TabCompleter {

	private Map<String, SubCommand> subCommands = new HashMap<>();

	public void registerSubCommand(String label, SubCommand subCmd) {
		subCommands.put(label, subCmd);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		SubCommand subCmd = subCommands.get(args[0]);
		if(subCmd == null) {
			sender.sendMessage(ChatColor.RED + "Unknown subcommand '" + args[0] + "'");
			return true;
		}
		
		subCmd.onCommand(sender, args);
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		SubCommand subCmd = subCommands.get(args[0]);
		if(subCmd == null) {
			return Collections.emptyList();
		}
		
		return subCmd.onTabComplete(sender, args);
	}
	
	public interface SubCommand {
		public void onCommand(CommandSender sender, String[] args);
		public List<String> onTabComplete(CommandSender sender, String[] args);
	}

}
