package me.gerpaderp.gabetime.util;

import java.util.concurrent.TimeUnit;

import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;

import net.md_5.bungee.api.ChatColor;

public class GeneralUtil {
	
	private static String commandPrefix = (ChatColor.DARK_PURPLE + "[" + ChatColor.LIGHT_PURPLE + "GabeTime" + ChatColor.DARK_PURPLE
			+ "] ");

	public static String getPrefix() {
		return commandPrefix;
	}
	
	public static String getSuccessMessage(OfflinePlayer user) {
		ChatColor color;
		if (user.isOnline()) {
			color = ChatColor.GREEN;
		} else {
			color = ChatColor.RED;
		}
		return (getPrefix() + ChatColor.GRAY + "User " + color + user.getName() + ChatColor.GRAY + " has played for:\n • " + ChatColor.YELLOW + formatTicks(user.getStatistic(Statistic.PLAY_ONE_MINUTE)));
	}
	
	public static String formatTicks(int ticksPlayed) {
		int totalseconds = ticksPlayed / 20;

		int days = (int) TimeUnit.SECONDS.toDays(totalseconds);
		int hours = (int) (TimeUnit.SECONDS.toHours(totalseconds) - TimeUnit.DAYS.toHours(days));
		int minutes = (int) (TimeUnit.SECONDS.toMinutes(totalseconds) - TimeUnit.DAYS.toMinutes(days)
				- TimeUnit.HOURS.toMinutes(hours));
		int seconds = (int) (totalseconds - TimeUnit.DAYS.toSeconds(days) - TimeUnit.HOURS.toSeconds(hours)
				- TimeUnit.MINUTES.toSeconds(minutes));

		return days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds";
	}
	
}
