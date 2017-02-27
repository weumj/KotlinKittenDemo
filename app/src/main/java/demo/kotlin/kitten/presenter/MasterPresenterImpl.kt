package demo.kotlin.kitten.presenter

import demo.kotlin.kitten.model.cats.Cats
import demo.kotlin.kitten.network.CatAPINetwork
import demo.kotlin.kitten.view.ImagesAdapter
import rx.Observable

class MasterPresenterImpl : MasterPresenter {
    lateinit private var imagesAdapter: ImagesAdapter

    override fun connect(imagesAdapter: ImagesAdapter) {
        this.imagesAdapter = imagesAdapter
    }

    override fun masterRequest() {
        imagesAdapter.observable(getObservableMasterRequest(CatAPINetwork()))
    }

    private fun getObservableMasterRequest(catAPINetwork: CatAPINetwork): Observable<Cats> {
        return catAPINetwork.exec()
    }
}