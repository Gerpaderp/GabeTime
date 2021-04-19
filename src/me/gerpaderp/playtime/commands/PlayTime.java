package me.gerpaderp.playtime.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.gerpaderp.playtime.util.GeneralUtil;
import net.md_5.bungee.api.ChatColor;

public class PlayTime implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		String prefix = GeneralUtil.getPrefix();

		if (!(sender.hasPermission("gabetime.playtime"))) {
			sender.sendMessage(ChatColor.RED + "You lack permission to run this command.");
			return true;
		}

		if (!(sender instanceof Player) && args.length == 0) {
			sender.sendMessage(prefix + ChatColor.RED + "You must specify a target player");
			return true;
		}

		OfflinePlayer target = args.length == 0 ? (OfflinePlayer) sender : Bukkit.getOfflinePlayer(args[0]);

		if (target == null) {
			sender.sendMessage(prefix + ChatColor.RED + "Could not find the player: " + args[0]);
			return true;
		}

		// Player exists

		if (!(target.hasPlayedBefore())) {
			sender.sendMessage(prefix + ChatColor.RED + target.getName() + " has not yet joined this server");
			return true;
		}

		ChatColor nameColor = target.isOnline() ? ChatColor.GREEN : ChatColor.RED;
		
		String message = prefix + ChatColor.GRAY + "User " + nameColor + target.getName() + ChatColor.GRAY
				+ " has played for:\n • " + ChatColor.YELLOW
				+ GeneralUtil.formatTicksToTime(target.getStatistic(Statistic.PLAY_ONE_MINUTE));

		sender.sendMessage(message);
		return true;
	}
}
