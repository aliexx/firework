package com.example.firework

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.utils.Array

class Launcher {

    var particles : Array<Texture> = Array()

    private val colors = listOf (
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.CYAN,
            Color.MAGENTA,
            Color.YELLOW,
            Color.ORANGE,
            Color.PINK,
            Color.VIOLET,
            Color.LIME,
            Color.WHITE
            )

    private var rockets : Array<Rocket> = Array()

    init {
        val pixmap = Pixmap(2, 2, Pixmap.Format.RGBA8888)

        for (color in colors) {
            pixmap.setColor(color)
            pixmap.drawRectangle(0, 0, 2, 2)
            particles.add(Texture(pixmap))
        }

        pixmap.dispose()
    }

    fun update(dt: Float) {
        if (MathUtils.random.nextInt(50) == 1 && rockets.count() < Core.MAX_ROCKETS) {
            rockets.add((Rocket(MathUtils.random(-50f, 50f) + Core.SCREEN_WIDTH / 2,
                                0f,
                                MathUtils.random(-50f, 50f),
                                MathUtils.random(150f, 200f),
                                particles[MathUtils.random.nextInt(particles.count())])))
        }
        if (rockets.count() == 0) return

        for (i in rockets.count() - 1 downTo 0) {
            rockets[i].update(dt)
            if (!rockets[i].isLive) {
                rockets.removeIndex(i)
            }
        }
    }

    fun draw(sb : SpriteBatch) {
        for (rocket in rockets) {
            rocket.draw(sb)
        }
    }
}