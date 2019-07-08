package com.example.firework

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.utils.Array

class Graphics {
    var particles : Array<Texture> = Array()

    private val colors = listOf(
        Color.BLACK,
        Color.RED,
        Color.GREEN,
        Color.BLUE,
        Color.CYAN,
        Color.MAGENTA,
        Color.YELLOW)

    init {
        val pixmap = Pixmap(2, 2, Pixmap.Format.RGBA8888)

        for (color in colors) {
            pixmap.setColor(color)
            pixmap.drawRectangle(0, 0, 2, 2)
            particles.add(Texture(pixmap))
        }

        pixmap.dispose()
    }
}
