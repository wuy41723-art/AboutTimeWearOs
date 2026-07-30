package com.abouttime.wearos


import android.graphics.Canvas
import android.graphics.Paint


class WatchFaceRenderer {


    private val paint =
        Paint().apply {

            textSize = 64f

            isAntiAlias = true

        }


    fun draw(
        canvas: Canvas,
        text: String
    ) {


        canvas.drawText(
            text,
            100f,
            300f,
            paint
        )
    }
}
