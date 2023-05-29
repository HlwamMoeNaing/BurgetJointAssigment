package com.example.burgetjointassigment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.burgetjointassigment.mvp.views.BaseView

interface BasePresenter<V: BaseView> {
    fun onUIReady(owner: LifecycleOwner)
    fun initPresenter(view: V)
}