package com.example.firework

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class Core : ApplicationAdapter() {

    companion object {
        const val SCREEN_WIDTH = 1024
        const val SCREEN_HEIGHT  = 768

        const val GRAVITY = 10

        const val MAX_ROCKETS = 20
    }

    private lateinit var sb: SpriteBatch
    private lateinit var launcher: Launcher

    override fun create() {
        sb = SpriteBatch()
        launcher = Launcher()
    }

    override fun render() {
        launcher.update(Gdx.graphics.deltaTime)

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        sb.begin()
        launcher.draw(sb)
        sb.end()
    }

    override fun dispose() {
        sb.dispose()
    }
}
