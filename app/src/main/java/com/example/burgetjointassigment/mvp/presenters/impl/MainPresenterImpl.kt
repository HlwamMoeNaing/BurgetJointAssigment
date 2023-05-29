package com.example.burgetjointassigment.mvp.presenters.impl

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.burgetjointassigment.data.model.BurgerModel
import com.example.burgetjointassigment.data.model.impl.BurgerModelImpl
import com.example.burgetjointassigment.data.vos.BurgerVO
import com.example.burgetjointassigment.mvp.presenters.MainPresenter
import com.example.burgetjointassigment.mvp.views.MainView

class MainPresenterImpl : MainPresenter, BaseAppPresenterImpl<MainView>() {

     var mBurgerModel: BurgerModel = BurgerModelImpl

    override fun onTapAddToCart(burger: BurgerVO, burgerImageView: ImageView) {
        mBurgerModel.addItemToCart(burger)
      //  mView.animateAddBurgerToCart(burger, burgerImageView)
        mView.addBurgerToCart(burger, burgerImageView)
    }

    override fun onTapCart() {
        mView.navigateToCartScreen()
    }

    override fun onUIReady(owner: LifecycleOwner) {
        mBurgerModel.getAllBurgers()
            .observe(owner, Observer {
                mView.displayBurgerList(it)
            })

        mBurgerModel.getBurgersInCart()
            .observe(owner, Observer {
                mView.displayCountInCart(it.count())
            })
    }

    override fun onTapBurger(burger: BurgerVO,burgerImageView: ImageView) {
        mView.navigateToBurgerDetailsScreenWithAnimation(burgerId = burger.burgerId, burgerImageView = burgerImageView)
    }
}