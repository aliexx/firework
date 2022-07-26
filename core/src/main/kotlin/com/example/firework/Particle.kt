package com.example.firework

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2

class Particle (x : Float, y: Float, color: Texture) {

    var isLive : Boolean

    private val color : Texture

    private var speed : Vector2
    private var lifetime : Float
    private var position : Vector2

    init {
        lifetime = MathUtils.random(3f, 5f)  // время жизни частицы 3 - 5 секунд
        speed = Vector2(MathUtils.random(50f), 0f)  // случайная скорость
        speed.rotateDeg(MathUtils.random(360f))     // и направление
        isLive = true
        position = Vector2(x, y)
        this.color = color
    }

    fun update(dt : Float) {
        lifetime -= dt
        if (lifetime < 0) isLive = false

        speed.y -= Core.GRAVITY * dt
        position.add(speed.x * dt, speed.y * dt)

    }

    fun draw(offset :Vector2, sb : SpriteBatch) {
        if (isLive) sb.draw(color, offset.x + position.x, offset.y + position.y)
    }
}