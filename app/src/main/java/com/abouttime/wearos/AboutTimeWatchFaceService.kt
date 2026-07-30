package com.abouttime.wearos


import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.SurfaceHolder
import androidx.wear.watchface.Renderer
import androidx.wear.watchface.WatchFace
import androidx.wear.watchface.WatchFaceService
import androidx.wear.watchface.WatchState
import androidx.wear.watchface.style.CurrentUserStyleRepository
import java.time.ZonedDateTime


class AboutTimeWatchFaceService :
    WatchFaceService() {


    override suspend fun createWatchFace(
        surfaceHolder: SurfaceHolder,
        watchState: WatchState,
        currentUserStyleRepository:
        CurrentUserStyleRepository

    ): WatchFace {


        return WatchFace(
            AboutTimeRenderer(
                surfaceHolder,
                watchState
            )
        )
    }

}



class AboutTimeRenderer(

    surfaceHolder: SurfaceHolder,

    watchState: WatchState

) : Renderer.CanvasRenderer(

    surfaceHolder,
    watchState,
    16,
    false

) {


    private val paint =
        Paint().apply {

            color =
                Color.WHITE

            textSize =
                60f

            textAlign =
                Paint.Align.CENTER

            isAntiAlias = true
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
