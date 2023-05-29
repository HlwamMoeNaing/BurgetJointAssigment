package com.example.burgetjointassigment.mvp.presenters

import com.example.burgetjointassigment.delegates.CartViewHolderActionDelegate
import com.example.burgetjointassigment.mvp.views.CartView

interface CartPresenter : BasePresenter<CartView>, CartViewHolderActionDelegate {
    fun onTapCheckout()
    fun onTapCancelThankYouMessage()
}