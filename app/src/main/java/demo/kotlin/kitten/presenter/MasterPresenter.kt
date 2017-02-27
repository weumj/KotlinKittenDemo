package demo.kotlin.kitten.presenter

import demo.kotlin.kitten.view.ImagesAdapter

interface MasterPresenter {
    fun connect(imagesAdapter: ImagesAdapter)
    fun masterRequest()
}
