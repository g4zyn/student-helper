package rs.raf.projekat2.marko_gajin_RM8517.data.models

data class Lecture(
    val id: Long,
    val name: String,
    val type: String,
    val professor: String,
    val groups: String,
    val day: String,
    val time: String,
    val classroom: String
)