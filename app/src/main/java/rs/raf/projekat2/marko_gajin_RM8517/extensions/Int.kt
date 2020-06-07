package rs.raf.projekat2.marko_gajin_RM8517.extensions

import android.content.res.Resources

fun Int.toPx() : Int = (this * Resources.getSystem().displayMetrics.density).toInt()