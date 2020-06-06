package rs.raf.projekat2.marko_gajin_RM8517.data.datasources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import rs.raf.projekat2.marko_gajin_RM8517.data.models.LectureEntity
import rs.raf.projekat2.marko_gajin_RM8517.data.models.NoteEntity

@Database(
    entities = [LectureEntity::class, NoteEntity::class],
    version = 1,
    exportSchema = false
)
//TODO type converters
abstract class Database: RoomDatabase() {
    abstract fun getLectureDao(): LectureDao
    abstract fun getNoteDao(): NoteDao
}