package com.example.burgetjointassigment.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.burgetjointassigment.data.model.impl.BurgerModelImpl
import com.example.burgetjointassigment.mvp.presenters.BurgerDetailsPresenter
import com.example.burgetjointassigment.mvp.views.BurgerDetailsView


class BurgerDetailsPresenterImpl : BurgerDetailsPresenter,
    BaseAppPresenterImpl<BurgerDetailsView>() {

    private val mBurgerModel = BurgerModelImpl

    override fun onBurgerDetailsUiReady(lifecycleOwner: LifecycleOwner, burgerDetailsId: Int) {
        mBurgerModel.findBurgerById(burgerDetailsId)
            .observe(lifecycleOwner, Observer {
                mView.displayBurgerDetails(it)
            })
    }

    override fun onUIReady(owner: LifecycleOwner) {

    }
}