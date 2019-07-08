package com.example.firework

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.utils.Array

class Rocket (x : Float, y: Float, texture: Texture) {
    var isLive : Boolean

    private var isFlying : Boolean
    private var time : Float
    private var x : Float
    private var y : Float
    private var texture : Texture
    private var particles : Array<Particle> = Array()

    init {
        time = MathUtils.random(2f * 1000, 3f * 1000)  // 2 - 3 секунды
        isLive = true
        isFlying = true
        this.x = x
        this.y = y
        this.texture = texture
        for (i in 1..100) {
            particles.add(Particle(x, y, texture))
        }
    }

    fun update(dt : Float) {
        time -= dt
        if (time < 0) {
            if (isFlying) {
                isFlying = false
            } else {
                isLive = false
                for (particle in particles) {
                    particle.update(dt)
                    if (particle.isLive) isLive = true
                }
            }
        } else {
            // физика полета
        }
    }

    fun draw(sb : SpriteBatch) {
        for (particle in particles)
            particle.draw(sb)
    }

}