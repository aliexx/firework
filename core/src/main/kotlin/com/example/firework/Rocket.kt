package com.example.firework

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.Array

class Rocket (x : Float, y: Float, speedx : Float, speedy : Float, color: Texture) {
    var isLive : Boolean

    private val color : Texture

    private var isFlying : Boolean
    private var time : Float
    private var position : Vector2
    private var speed : Vector2
    private var particles : Array<Particle> = Array()

    init {
        time = MathUtils.random(3f, 4f)  // время полета 3 - 4 секунды
        isLive = true
        isFlying = true
        position = Vector2(x, y)
        speed = Vector2(speedx, speedy)
        this.color = color
        for (i in 1..(MathUtils.random(100) + 200)) {   // 200 - 300 частиц
            particles.add(Particle(0f, 0f, color))
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
            position.add(speed.x * dt, speed.y * dt)
        }
    }

    fun draw(sb : SpriteBatch) {
        if (isFlying) {
            sb.draw(color, position.x, position.y)
            sb.draw(color, position.x + 2f, position.y)
            sb.draw(color, position.x, position.y + 2f)
            sb.draw(color, position.x + 2f, position.y + 2f)
            return
        }

        for (particle in particles)
            particle.draw(position, sb)
    }

}