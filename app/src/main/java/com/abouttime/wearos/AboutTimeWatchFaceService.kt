package com.abouttime.wearos

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.wear.watchface.WatchFaceService
import androidx.wear.watchface.WatchState
import androidx.wear.watchface.style.CurrentUserStyleRepository
import androidx.wear.watchface.complications.ComplicationSlotsManager
import androidx.wear.watchface.WatchFace
import androidx.wear.watchface.CanvasType
import androidx.wear.watchface.Renderer
import java.time.ZonedDateTime


class AboutTimeWatchFaceService :
    WatchFaceService() {


    override suspend fun createWatchFace(
        surfaceHolder: android.view.SurfaceHolder,
        watchState: WatchState,
        complicationSlotsManager: ComplicationSlotsManager,
        currentUserStyleRepository: CurrentUserStyleRepository
    ): WatchFace {


        return WatchFace(
            CanvasType.SOFTWARE,
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

    userStyleRepository:
    CurrentUserStyleRepository

) : Renderer.CanvasRenderer(

    surfaceHolder,
    userStyleRepository,
    watchState,
    CanvasType.SOFTWARE,
    16L

) {


    private val paint =
        Paint().apply {

            color = Color.WHITE

            textSize = 60f

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
