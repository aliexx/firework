package com.example.firework

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.Array

class Rocket (x : Float, y: Float, speedx : Float, speedy : Float, texture: Texture) {
    var isLive : Boolean

    private var isFlying : Boolean
    private var time : Float
    private var x : Float
    private var y : Float
    private var speed : Vector2
    private var texture : Texture
    private var particles : Array<Particle> = Array()

    init {
        time = MathUtils.random(3f, 4f)  // 3 - 4 секунды
        isLive = true
        isFlying = true
        this.x = x
        this.y = y
        speed = Vector2(speedx, speedy)
        this.texture = texture
        for (i in 1..100) {
            particles.add(Particle(0f, 0f, texture))
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
            speed.y -= Core.GRAVITY * dt
            x += speed.x * dt
            y += speed.y * dt
        }
    }

    fun draw(sb : SpriteBatch) {
        for (particle in particles)
            particle.draw(x, y, sb)
    }

}