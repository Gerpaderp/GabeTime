package me.gerpaderp.gabetime;

import org.bukkit.plugin.java.JavaPlugin;

import me.gerpaderp.gabetime.commands.PlayTime;
import me.gerpaderp.gabetime.util.GeneralUtil;

public class GabeTimeMain extends JavaPlugin {

	public void onEnable() {
		System.out.println(GeneralUtil.getPrefix() + "has been enabled.");
		this.getCommand("playtime").setExecutor(new PlayTime());
	}
}
