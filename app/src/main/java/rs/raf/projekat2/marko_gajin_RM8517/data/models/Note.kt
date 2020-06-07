package rs.raf.projekat2.marko_gajin_RM8517.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Note(
    val id: Long,
    val title: String,
    val body: String
) : Parcelable