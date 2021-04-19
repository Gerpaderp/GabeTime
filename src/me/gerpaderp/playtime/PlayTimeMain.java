package me.gerpaderp.playtime;

import org.bukkit.plugin.java.JavaPlugin;

import me.gerpaderp.playtime.commands.PlayTime;
import me.gerpaderp.playtime.util.GeneralUtil;

public class PlayTimeMain extends JavaPlugin {

	public void onEnable() {
		System.out.println(GeneralUtil.getPrefix() + "has been enabled.");
		this.getCommand("playtime").setExecutor(new PlayTime());
	}
}
