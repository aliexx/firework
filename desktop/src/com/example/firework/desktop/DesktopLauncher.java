package com.example.firework.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.example.firework.Core;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Core.SCREEN_WIDTH;
		config.height = Core.SCREEN_HEIGHT;
		config.title = "Firework";
		new LwjglApplication(new Core(), config);
	}
}
