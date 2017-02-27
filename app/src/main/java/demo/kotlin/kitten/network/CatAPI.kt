package demo.kotlin.kitten.network

import demo.kotlin.kitten.BuildConfig
import demo.kotlin.kitten.model.cats.Cats
import retrofit2.http.GET
import rx.Observable

interface CatAPI {
    @GET("/api/images/get?format=xml&size=full&results_per_page=" + BuildConfig.MAX_IMAGES_PER_REQUEST)
    fun catImages(): Observable<Cats>
}