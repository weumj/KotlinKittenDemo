package demo.kotlin.kitten.network

import demo.kotlin.kitten.model.cats.Cats
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class CatAPINetwork {
    fun exec(): Observable<Cats> {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://thecatapi.com")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        val catAPI: CatAPI = retrofit.create(CatAPI::class.java)

        return catAPI.catImages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}