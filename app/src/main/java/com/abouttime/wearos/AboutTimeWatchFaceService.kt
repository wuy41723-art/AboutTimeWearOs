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



        private var ambient =
            false



        override fun onAmbientModeChanged(
            inAmbientMode: Boolean
        ) {

            ambient =
                inAmbientMode

            draw()

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



            val time =
                TimeFormatter.format(

                    calendar.get(
                        Calendar.HOUR_OF_DAY
                    ),

                    calendar.get(
                        Calendar.MINUTE
                    )

                )



            val holder:
                    SurfaceHolder =
                surfaceHolder



            val canvas =
                holder.lockCanvas()



            if (canvas != null) {


                WatchFaceRenderer()
                    .draw(

                        canvas,

                        time,

                        ambient

                    )


                holder.unlockCanvasAndPost(
                    canvas
                )

            }

        }

    }

}
