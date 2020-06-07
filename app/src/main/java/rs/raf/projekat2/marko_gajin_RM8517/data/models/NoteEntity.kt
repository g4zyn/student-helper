package rs.raf.projekat2.marko_gajin_RM8517.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val body: String,
    val archived: Boolean
)