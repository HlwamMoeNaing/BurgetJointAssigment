package com.example.burgetjointassigment.mvp.presenters.impl

import com.example.burgetjointassigment.mvp.presenters.AbstractBasePresenter
import com.example.burgetjointassigment.mvp.presenters.BasePresenter
import com.example.burgetjointassigment.mvp.views.BaseView

abstract class BaseAppPresenterImpl<V : BaseView> : AbstractBasePresenter<V>(), BasePresenter<V>
