package com.example.firework

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils

class Particle (x : Float, y: Float, sb: SpriteBatch, texture: Texture) {

    var isLive : Boolean

    private var time : Float
    private var x : Float
    private var y : Float
    private var texture : Texture
    private var sb : SpriteBatch

    init {
        time = MathUtils.random(2f * 1000, 3f * 1000)  // 2 - 3 секунды
        isLive = true
        this.x = x
        this.y = y
        this.texture = texture
        this.sb = sb
    }

    fun update(dt : Float) {
        time -= dt
        if (time < 0) isLive = false
    }

    fun draw(sb : SpriteBatch) {
        sb.draw(texture, x, y)
    }
}