package rs.raf.projekat2.marko_gajin_RM8517.data.models.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ScheduleResponse(
    val status: String,
    val data: List<LectureResponse>,
    val message: String?
)