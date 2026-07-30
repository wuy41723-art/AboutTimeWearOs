package com.abouttime.wearos


object TimeFormatter {


    private val chineseHours = arrayOf(
        "十二",
        "一点",
        "两点",
        "三点",
        "四点",
        "五点",
        "六点",
        "七点",
        "八点",
        "九点",
        "十点",
        "十一"
    )


    fun format(
        hour24: Int,
        minute: Int
    ): String {


        val hour =
            hour24 % 12


        val nextHour =
            (hour + 1) % 12


        return when {

            minute <= 10 ->
                chineseHours[hour] + "刚过"


            minute <= 25 ->
                chineseHours[hour] + "多"


            minute <= 40 ->
                chineseHours[hour] + "半左右"


            minute <= 55 ->
                "快" + chineseHours[nextHour]


            else ->
                chineseHours[nextHour] + "左右"
        }
    }
}
