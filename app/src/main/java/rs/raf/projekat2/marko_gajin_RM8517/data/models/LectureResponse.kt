package rs.raf.projekat2.marko_gajin_RM8517.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LectureResponse(
    @Json(name = "predmet") val name: String,
    @Json(name = "tip") val type: String,
    @Json(name = "nastavnik") val professor: String,
    @Json(name = "grupe") val groups: String,
    @Json(name = "dan") val day: String,
    @Json(name = "termin") val time: String,
    @Json(name = "ucionica") val classroom: String
)