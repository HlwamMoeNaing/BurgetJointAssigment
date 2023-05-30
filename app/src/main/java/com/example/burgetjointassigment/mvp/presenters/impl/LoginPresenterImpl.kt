package com.example.burgetjointassigment.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.example.burgetjointassigment.mvp.presenters.LoginPresenter
import com.example.burgetjointassigment.mvp.views.LoginView
import com.example.burgetjointassigment.util.EM_LOGIN_FAIL_ERROR_MESSAGE

class LoginPresenterImpl : LoginPresenter, BaseAppPresenterImpl<LoginView>() {
    override fun onUIReady(owner: LifecycleOwner) {}

    override fun onTapLogin(userName: String, password: String) {
        if(userName.isNotEmpty() || password.isNotEmpty()){
            mView.navigateToMainScreen()
        } else {
            mView.showErrorMessage(EM_LOGIN_FAIL_ERROR_MESSAGE)
        }
    }
}