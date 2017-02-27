package demo.kotlin.kitten.view

import demo.kotlin.kitten.model.cats.Cats
import rx.Observable

interface ImagesAdapter {
    fun observable(observableCats: Observable<Cats>)
    fun unsubscribe()
}
