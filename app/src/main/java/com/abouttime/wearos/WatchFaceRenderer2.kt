package com.abouttime.wearos


import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.SurfaceHolder
import androidx.wear.watchface.Renderer
import androidx.wear.watchface.WatchState
import java.time.ZonedDateTime



class WatchFaceRenderer2(

    private val context: android.content.Context,

    surfaceHolder: SurfaceHolder,

    watchState: WatchState

) :
    Renderer.CanvasRenderer(

        surfaceHolder,

        watchState,

        CanvasType.SOFTWARE,

        16L

    ) {


    private val paint =
        Paint().apply {

            color = Color.WHITE

            textSize = 60f

            isAntiAlias = true

            textAlign =
                Paint.Align.CENTER

        }



    override fun render(
        canvas: Canvas,
        zonedDateTime: ZonedDateTime
    ) {


        canvas.drawColor(
            Color.BLACK
        )


        val text =
            TimeFormatter.format(

                zonedDateTime.hour,

                zonedDateTime.minute

            )


        canvas.drawText(

            text,

            canvas.width / 2f,

            canvas.height / 2f,

            paint

        )

    }

}
