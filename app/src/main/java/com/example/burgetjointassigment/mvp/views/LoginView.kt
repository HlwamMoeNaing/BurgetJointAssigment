package com.example.burgetjointassigment.mvp.views

interface LoginView : BaseView {
    fun navigateToMainScreen()
    fun showErrorMessage(message: String)
}