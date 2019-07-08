package com.example.firework

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2

class Particle (x : Float, y: Float, texture: Texture) {

    var isLive : Boolean
    var speed : Vector2
    private var lifetime : Float
    private var x : Float
    private var y : Float
    private var texture : Texture

    init {
        lifetime = MathUtils.random(3f, 5f)  // время жизни частицы 3 - 5 секунд
        speed = Vector2(MathUtils.random(40f), 0f)
        speed.rotate(MathUtils.random(360f))
        isLive = true
        this.x = x
        this.y = y
        this.texture = texture
    }

    fun update(dt : Float) {
        lifetime -= dt
        if (lifetime < 0) isLive = false

        speed.y -= Core.GRAVITY * dt
        x += speed.x * dt
        y += speed.y * dt

    }

    fun draw(offsetx : Float, offsety : Float, sb : SpriteBatch) {
        if (lifetime < 1.5)
            if ((lifetime * 10) < MathUtils.random(lifetime * 10)) return
        sb.draw(texture, offsetx + x, offsety + y)
    }
}