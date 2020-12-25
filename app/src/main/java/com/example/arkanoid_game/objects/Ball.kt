package com.example.arkanoid_game.objects

import android.graphics.Bitmap
import kotlin.math.absoluteValue

class Ball(bitmap: Bitmap) : GameObject(bitmap) {

    init {
        reset()
    }

    var horizontalVelocity = 12
    var verticalVelocity = -12

    override fun update() {
        move(horizontalVelocity, verticalVelocity)
        if (this.getTop() <= 0 || this.getBottom() >= screenHeight) verticalReverse()
        if (this.getLeft() <= 0 || this.getRight() >= screenWidth) horizontalReverse()
    }

    override fun increaseVelocity() {
        if (horizontalVelocity.absoluteValue < 12) {
            if (horizontalVelocity < 0) horizontalVelocity--
            else horizontalVelocity++
        }

        if (verticalVelocity.absoluteValue < 12) {
            if (verticalVelocity < 0) verticalVelocity--
            else verticalVelocity++
        }
    }

    override fun reset() {
        x = screenWidth / 2
        y = screenHeight / 2
    }

    fun horizontalReverse() {
        horizontalVelocity = -horizontalVelocity
    }

    fun verticalReverse() {
        verticalVelocity = -verticalVelocity
    }
}