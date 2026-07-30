package com.abouttime.wearos

import android.graphics.Canvas
import androidx.wear.watchface.CanvasType
import androidx.wear.watchface.WatchFace
import androidx.wear.watchface.WatchFaceService
import androidx.wear.watchface.complications.ComplicationSlot
import androidx.wear.watchface.complications.ComplicationSlotsManager
import androidx.wear.watchface.style.CurrentUserStyleRepository
import androidx.wear.watchface.WatchState


class AboutTimeWatchFaceService : WatchFaceService() {


    override suspend fun createWatchFace(
        surfaceHolder: android.view.SurfaceHolder,
        watchState: WatchState,
        complicationSlotsManager: ComplicationSlotsManager,
        currentUserStyleRepository: CurrentUserStyleRepository
    ): WatchFace {


        val renderer = AboutTimeRenderer(
            surfaceHolder,
            watchState
        )


        return WatchFace(
            CanvasType.SOFTWARE,
            renderer
        )
    }
}
