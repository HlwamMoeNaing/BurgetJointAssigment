package com.example.burgetjointassigment.mvp.views

import android.widget.ImageView
import com.example.burgetjointassigment.data.vos.BurgerVO

interface MainView : BaseView{
    fun displayBurgerList(burgerList : List<BurgerVO>)
    fun navigateToBurgerDetailsScreenWithAnimation(burgerId : Int, burgerImageView: ImageView)
    fun navigateToCartScreen()
    fun animateAddBurgerToCart(burger : BurgerVO, burgerImageView : ImageView)
    fun displayCountInCart(burgersInCartCount : Int)
    fun addBurgerToCart(burger : BurgerVO, burgerImageView : ImageView)

}