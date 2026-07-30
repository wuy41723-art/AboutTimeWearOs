package com.abouttime.wearos

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface


class WatchFaceRenderer {


    private val paint = Paint().apply {

        color = Color.WHITE

        textSize = 60f

        typeface = Typeface.DEFAULT

        isAntiAlias = true

        textAlign = Paint.Align.CENTER
    }


    fun draw(
        canvas: Canvas,
        text: String,
        ambient: Boolean = false
    ) {


        val width =
            canvas.width / 2f


        val height =
            canvas.height / 2f


        canvas.drawColor(Color.BLACK)


        if (ambient) {

            // AOD 模式降低亮度
            paint.alpha = 120

            paint.textSize = 48f

        } else {

            paint.alpha = 255

            paint.textSize = 60f

        }


        canvas.drawText(

            text,

            width,

            height,

            paint

        )
    }
}
