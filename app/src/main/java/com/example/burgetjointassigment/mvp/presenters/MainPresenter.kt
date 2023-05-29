package com.example.burgetjointassigment.mvp.presenters

import com.example.burgetjointassigment.delegates.BurgerViewHolderActionDelegate
import com.example.burgetjointassigment.mvp.views.MainView

interface MainPresenter :  BasePresenter<MainView>, BurgerViewHolderActionDelegate {
    fun onTapCart()
}