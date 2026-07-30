package com.abouttime.wearos


import android.service.wallpaper.WallpaperService
import android.view.SurfaceHolder
import java.util.Calendar


class AboutTimeWatchFaceService :
    WallpaperService() {


    override fun onCreateEngine():
        Engine {


        return WatchEngine()

    }



    inner class WatchEngine :
        Engine() {


        override fun onVisibilityChanged(
            visible: Boolean
        ) {

            if (visible) {

                draw()

            }

        }


        private fun draw() {


            val calendar =
                Calendar.getInstance()


            val text =
                TimeFormatter.format(
                    calendar.get(
                        Calendar.HOUR_OF_DAY
                    ),
                    calendar.get(
                        Calendar.MINUTE
                    )
                )


            val canvas =
                surfaceHolder.lockCanvas()


            if (canvas != null) {


                canvas.drawColor(
                    android.graphics.Color.BLACK
                )


                WatchFaceRenderer()
                    .draw(
                        canvas,
                        text
                    )


                surfaceHolder
                    .unlockCanvasAndPost(
                        canvas
                    )
            }

        }
    }
}
