package rs.raf.projekat2.marko_gajin_RM8517.data.datasources

import io.reactivex.Observable
import retrofit2.http.GET
import rs.raf.projekat2.marko_gajin_RM8517.data.models.api.LectureResponse

interface ScheduleDataSource {

    @GET("raspored/json.php")
    fun getAll(): Observable<List<LectureResponse>>

}