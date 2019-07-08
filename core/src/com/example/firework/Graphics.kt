package com.example.firework

import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.utils.Array

class Graphics {
    var particles : Array<Texture> = Array()

    init {
        var pixmap = Pixmap(1, 1, Pixmap.Format.RGBA8888)
        pixmap.setColor(0f, 1f, 0f, 0.75f)
        pixmap.fillCircle(32, 32, 32)
        val pixmaptex = Texture(pixmap)
        pixmap.dispose()
    }
}
