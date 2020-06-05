package rs.raf.projekat2.marko_gajin_RM8517.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.LectureDao
import rs.raf.projekat2.marko_gajin_RM8517.data.models.entity.LectureEntity

@Database(
    entities = [LectureEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ScheduleDatabase: RoomDatabase() {

    abstract fun getLectureDao(): LectureDao

}