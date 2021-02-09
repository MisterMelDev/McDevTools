package tech.mistermel.devtools.cmd;

import java.util.List;

import org.bukkit.command.CommandSender;

import tech.mistermel.devtools.cmd.CommandHandler.SubCommand;

public class LoadSubCommand implements SubCommand {

	@Override
	public void onCommand(CommandSender sender, String[] args) {
		
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, String[] args) {
		return null;
	}

}