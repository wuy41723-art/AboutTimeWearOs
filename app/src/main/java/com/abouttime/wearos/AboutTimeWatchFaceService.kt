package com.abouttime.wearos

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.SurfaceHolder
import androidx.wear.watchface.WatchFace
import androidx.wear.watchface.WatchFaceService
import androidx.wear.watchface.Renderer
import androidx.wear.watchface.WatchState
import androidx.wear.watchface.CanvasType
import androidx.wear.watchface.style.CurrentUserStyleRepository
import java.time.ZonedDateTime


class AboutTimeWatchFaceService :
    WatchFaceService() {


    override suspend fun createWatchFace(
        surfaceHolder: SurfaceHolder,
        watchState: WatchState,
        complicationSlotsManager:
        androidx.wear.watchface.complications.ComplicationSlotsManager,
        currentUserStyleRepository:
        CurrentUserStyleRepository

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

    surfaceHolder: SurfaceHolder,

    watchState: WatchState,

    styleRepository:
    CurrentUserStyleRepository

) : Renderer.CanvasRenderer(

    surfaceHolder,
    styleRepository,
    watchState,
    CanvasType.SOFTWARE,
    1000L

) {


    private val paint =
        Paint().apply {

            color = Color.WHITE

            textSize = 60f

            textAlign =
                Paint.Align.CENTER

            isAntiAlias = true
        }
