package com.example.burgetjointassigment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.burgetjointassigment.mvp.views.BurgerDetailsView

interface BurgerDetailsPresenter : BasePresenter<BurgerDetailsView> {
    fun onBurgerDetailsUiReady(lifecycleOwner: LifecycleOwner, burgerDetailsId: Int)
}