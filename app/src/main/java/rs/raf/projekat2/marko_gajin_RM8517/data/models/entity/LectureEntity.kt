package rs.raf.projekat2.marko_gajin_RM8517.data.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lectures")
data class LectureEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val type: String,
    val professor: String,
     val groups: String,
    val day: String,
    val time: String,
    val classroom: String
)