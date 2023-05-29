package com.example.burgetjointassigment.mvp.views

import com.example.burgetjointassigment.data.vos.BurgerVO

interface CartView : BaseView {
    fun displayItemsInCart(burgers : List<BurgerVO>)
    fun displayThankYouMessage()
    fun hideThankYouMessage()
}