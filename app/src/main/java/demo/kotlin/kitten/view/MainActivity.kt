package demo.kotlin.kitten.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import demo.kotlin.kitten.presenter.MasterPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

import demo.kotlin.kitten.R
import demo.kotlin.kitten.presenter.MasterPresenter

class MainActivity : AppCompatActivity() {
    private val imagesAdapterImpl: ImagesAdapterImpl by lazy { ImagesAdapterImpl() }

    private val masterPresenter: MasterPresenter
            by lazy {
                MasterPresenterImpl()
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        connectingToMasterPresenter()
        getURLs()
    }

    override fun onDestroy() {
        imagesAdapterImpl.unsubscribe()
        super.onDestroy()
    }

    private fun initRecyclerView() {
        containerRecyclerView.layoutManager = GridLayoutManager(this, 1)
        containerRecyclerView.adapter = imagesAdapterImpl
    }

    private fun connectingToMasterPresenter() {
        masterPresenter.connect(imagesAdapterImpl)
    }

    private fun getURLs() {
        masterPresenter.masterRequest()
    }
}
