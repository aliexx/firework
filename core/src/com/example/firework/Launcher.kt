package com.example.firework

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.utils.Array

const val MAX_ROCKETS = 20

class Launcher (graphics: Graphics) {

    var graphics: Graphics

    private var rockets : Array<Rocket> = Array()

    init {
        this.graphics = graphics
    }

    fun update(dt: Float) {
        if (MathUtils.random.nextInt(50) == 1 && rockets.count() < MAX_ROCKETS) {
            rockets.add((Rocket((MathUtils.random.nextInt(100) + Core.SCREEN_WIDTH / 2 - 50).toFloat(),
                                0f,
                                graphics.particles[MathUtils.random.nextInt(graphics.particles.count() -1 ) + 1])))
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