package rs.raf.projekat2.marko_gajin_RM8517.data.datasources

import io.reactivex.Observable
import retrofit2.http.GET
import rs.raf.projekat2.marko_gajin_RM8517.data.models.api.ScheduleResponse

interface ScheduleDataSource {

    @GET("")
    fun getAll(): Observable<ScheduleResponse>

}