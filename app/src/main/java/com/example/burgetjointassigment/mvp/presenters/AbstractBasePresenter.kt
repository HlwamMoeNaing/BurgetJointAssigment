package com.example.burgetjointassigment.mvp.presenters

import androidx.lifecycle.ViewModel
import com.example.burgetjointassigment.mvp.views.BaseView

abstract class AbstractBasePresenter<T: BaseView> : BasePresenter<T>, ViewModel() {

    protected lateinit var mView : T

    override fun initPresenter(view: T){
        mView = view
    }
}