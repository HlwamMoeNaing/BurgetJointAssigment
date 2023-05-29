package com.example.burgetjointassigment.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.burgetjointassigment.data.model.impl.BurgerModelImpl
import com.example.burgetjointassigment.data.vos.BurgerVO
import com.example.burgetjointassigment.mvp.presenters.CartPresenter
import com.example.burgetjointassigment.mvp.views.CartView

class CartPresenterImpl : CartPresenter, BaseAppPresenterImpl<CartView>() {


    private val mBurgerModel = BurgerModelImpl

    override fun onUIReady(owner: LifecycleOwner) {
        mBurgerModel
            .getBurgersInCart()
            .observe(owner, Observer {
                mView.displayItemsInCart(it)
            })
    }

    override fun onTapRemoveFromCart(burger: BurgerVO) {
        mBurgerModel
            .removeItemFromCart(burger)
    }

    override fun onTapCheckout() {
        mView.displayThankYouMessage()
    }

    override fun onTapCancelThankYouMessage() {
        mView.hideThankYouMessage()
    }
}