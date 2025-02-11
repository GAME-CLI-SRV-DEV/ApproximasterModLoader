package com.ddnsgeek.approximasterstudios2004.modloader;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import net.internationalx.api.TranslationManager;


public class main extends JavaPlugin implements SlimefunAddon {

  String ver = "1.20.6-R000-SNAPSHOT";
  String MC = "1.20.6";
  String Cheat = "1.20.6-R0.1-SNAPSHOT"
  
  @Override
  public void onLoad() {
    System.out.println("Loading Approximaster " + ver + "for " + MC + "...");
	  Locale systemLocale = Locale.getDefault();
    TranslationManager translationManager = new TranslationManager(systemLocale);
    System.out.println(TranslationManager.translate("plugin.author", "Approximaster Studios 2004"));
  }
  
	@Override
	public void onEnable() {

  }
	
	@Override
	public void onDisable() {
		// Logic for disabling the plugin...
	}
	
	@Override
	public JavaPlugin getJavaPlugin() {
		// This is a method that links your SlimefunAddon to your Plugin.
		// Just return "this" in this case, so they are linked
		return this;
	}
	
	@Override
	public String getBugTrackerURL() {
		// Here you can return a link to your Bug Tracker.
		// This link will be displayed to Server Owners if there is an issue
		// with this Addon. Return null if you have no bug tracker.
		// Normally you can just use GitHub's Issues tab:
		// https://github.com/YOURNAME/YOURPROJECT/issues
		return "https://github.com/GAME-CLI-SRV-DEV/ApproximasterModLoader/issues";
	}

}
