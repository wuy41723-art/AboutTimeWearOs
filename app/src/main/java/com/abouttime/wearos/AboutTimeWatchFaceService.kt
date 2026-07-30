package com.abouttime.wearos


import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.wear.watchface.CanvasType
import androidx.wear.watchface.WatchFace
import androidx.wear.watchface.WatchFaceService
import androidx.wear.watchface.WatchFaceType
import androidx.wear.watchface.Renderer
import androidx.wear.watchface.WatchState
import androidx.wear.watchface.style.CurrentUserStyleRepository
import androidx.wear.watchface.complications.ComplicationSlotsManager
import java.time.ZonedDateTime



class AboutTimeWatchFaceService :
    WatchFaceService() {


    override suspend fun createWatchFace(
        surfaceHolder:
        android.view.SurfaceHolder,

        watchState:
        WatchState,

        complicationSlotsManager:
        ComplicationSlotsManager,

        currentUserStyleRepository:
        CurrentUserStyleRepository

    ): WatchFace {


        return WatchFace(
            watchFaceType =
            WatchFaceType.DIGITAL,

            renderer =
            AboutTimeRenderer(
                surfaceHolder,
                watchState,
                currentUserStyleRepository
            )
        )

    }

}



class AboutTimeRenderer(

    surfaceHolder:
    android.view.SurfaceHolder,

    watchState:
    WatchState,

    styleRepository:
    CurrentUserStyleRepository

) : Renderer.CanvasRenderer(

    surfaceHolder,

    styleRepository,

    watchState,

    CanvasType.SOFTWARE,

    16,

    1000L

) {


    private val paint =
        Paint().apply {

            color =
            Color.WHITE

            textSize =
            60f

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


        canvas.drawText(

            TimeFormatter.format(
                zonedDateTime.hour,
                zonedDateTime.minute
            ),

            canvas.width / 2f,

            canvas.height / 2f,

            paint
        )

    }

}
