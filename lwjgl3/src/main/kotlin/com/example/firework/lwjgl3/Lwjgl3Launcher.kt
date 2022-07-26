@file:JvmName("Lwjgl3Launcher")

package com.example.firework.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.example.firework.Core

/** Launches the desktop (LWJGL3) application. */
fun main() {
    Lwjgl3Application(Core(), Lwjgl3ApplicationConfiguration().apply {
        setTitle("Firework")
        setWindowedMode(Core.SCREEN_WIDTH, Core.SCREEN_HEIGHT)
        setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
    })
}
