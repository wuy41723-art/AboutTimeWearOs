package com.abouttime.wearos


import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.service.wallpaper.WallpaperService
import android.view.SurfaceHolder
import java.util.Calendar


class AboutTimeWatchFaceService :
    WallpaperService() {


    override fun onCreateEngine(): Engine {

        return AboutTimeEngine()

    }



    inner class AboutTimeEngine :
        Engine() {


        private val paint =
            Paint().apply {

                color = Color.WHITE

                textSize = 60f

                textAlign =
                    Paint.Align.CENTER

                isAntiAlias = true
            }



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
                    Color.BLACK
                )


                canvas.drawText(

                    text,

                    canvas.width / 2f,

                    canvas.height / 2f,

                    paint

                )


                surfaceHolder
                    .unlockCanvasAndPost(
                        canvas
                    )

            }

        }

    }

}
