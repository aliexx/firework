package com.example.firework

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2

class Particle (x : Float, y: Float, color: Texture) {
    var isLive : Boolean

    private var speed : Vector2 = Vector2(MathUtils.random(40f), 0f)
    private var lifetime : Float = MathUtils.random(3f, 5f)
    private var position : Vector2
    private var color : Texture

    init {
        // время жизни частицы 3 - 5 секунд
        // случайная скорость
        speed.rotate(MathUtils.random(360f))        // и направление
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
        if (lifetime < 1.5)                   // затухание
            if ((lifetime * 10) < MathUtils.random(lifetime * 10)) return
        sb.draw(color, offset.x + position.x, offset.y + position.y)
    }
}