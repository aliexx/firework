package com.example.firework

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2

class Particle (x : Float, y: Float, texture: Texture) {

    var isLive : Boolean
    var speed : Vector2
    private var time : Float
    private var x : Float
    private var y : Float
    private var texture : Texture

    init {
        time = MathUtils.random(4f, 5f)  // 2 - 3 секунды
        speed = Vector2(MathUtils.random(-20f, 20f), MathUtils.random(-20f, 20f))
        speed.rotate(MathUtils.random(360f))
        isLive = true
        this.x = x
        this.y = y
        this.texture = texture
    }

    fun update(dt : Float) {
        time -= dt
        if (time < 0) isLive = false

        speed.y -= Core.GRAVITY * dt
        x += speed.x * dt
        y += speed.y * dt

    }

    fun draw(offsetx : Float, offsety : Float, sb : SpriteBatch) {
        sb.draw(texture, offsetx + x, offsety + y)
    }
}