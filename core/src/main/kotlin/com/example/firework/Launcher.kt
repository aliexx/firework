package com.example.firework

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.utils.Array

class Launcher {

    private val colors : Array<Texture> = Array()

    private val palette = listOf (
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

    private val rockets : Array<Rocket> = Array()

    private var launchTimer : Float = 0f

    init {
        val pixmap = Pixmap(2, 2, Pixmap.Format.RGBA8888)       // частицы 2х2

        for (color in palette) {
            pixmap.setColor(color)
            pixmap.drawRectangle(0, 0, 2, 2)
            colors.add(Texture(pixmap))
        }

        pixmap.dispose()
    }

    fun update(dt: Float) {
        nextLaunch(dt)

        if (rockets.count() == 0) return

        for (i in rockets.count() - 1 downTo 0) {
            rockets[i].update(dt)
            if (!rockets[i].isLive) {
                rockets.removeIndex(i)
            }
        }
    }
    
    private fun nextLaunch(dt: Float) {
        launchTimer -= dt
        if (launchTimer <= 0f && rockets.count() < Core.MAX_ROCKETS) {
            rockets.add(Rocket(MathUtils.random(-50f, 50f) + Core.SCREEN_WIDTH / 2, // середина экрана +/-
                    0f,                                                  // земля
                    MathUtils.random(-50f, 50f),                         // скорость x
                    MathUtils.random(150f, 200f),                        // скорость y
                    colors[MathUtils.random.nextInt(colors.count())]))   // случайный цвет

            launchTimer = (MathUtils.random(40) + 20).toFloat() / 20f

        }
    }

    fun draw(sb : SpriteBatch) {
        for (rocket in rockets) {
            rocket.draw(sb)
        }
    }
}