package com.abouttime.wearos


import android.content.Context
import androidx.wear.watchface.CanvasType
import androidx.wear.watchface.WatchFace
import androidx.wear.watchface.WatchFaceService
import androidx.wear.watchface.style.CurrentUserStyleRepository


class AboutTimeWatchFaceService :
    WatchFaceService() {


    override suspend fun createWatchFace(
        surfaceHolder: android.view.SurfaceHolder,
        watchState: androidx.wear.watchface.WatchState,
        complicationSlotsManager:
        androidx.wear.watchface.complications.ComplicationSlotsManager,
        currentUserStyleRepository:
        CurrentUserStyleRepository
    ): WatchFace {


        return WatchFace(

            CanvasType.SOFTWARE,

            WatchFaceRenderer2(

                this,

                surfaceHolder,

                watchState

            )

        )

    }

}
