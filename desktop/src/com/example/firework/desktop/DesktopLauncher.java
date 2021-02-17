package com.example.firework.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.example.firework.Core;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		config.setWindowedMode(Core.SCREEN_WIDTH, Core.SCREEN_HEIGHT);
		config.setTitle("Firework");
		new Lwjgl3Application(new Core(), config);
	}
}
