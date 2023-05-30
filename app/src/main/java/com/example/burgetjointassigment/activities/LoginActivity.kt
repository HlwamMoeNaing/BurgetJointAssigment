package com.example.burgetjointassigment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.burgetjointassigment.R
import com.example.burgetjointassigment.mvp.presenters.LoginPresenter
import com.example.burgetjointassigment.mvp.presenters.impl.LoginPresenterImpl
import com.example.burgetjointassigment.mvp.views.LoginView
import com.google.android.material.snackbar.Snackbar

class LoginActivity : BaseActivity(), LoginView {

lateinit var etUserName: AppCompatEditText
lateinit var etPassword:AppCompatEditText
lateinit var btnLogin: AppCompatButton
    private lateinit var mPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etUserName =findViewById(R.id.etUserName)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        setUpPresenter()
        setUpListeners()
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<LoginPresenterImpl, LoginView>()
    }

    private fun setUpListeners() {
        btnLogin.setOnClickListener {
            mPresenter.onTapLogin(etUserName.text.toString(), etPassword.text.toString())
        }
    }

    override fun navigateToMainScreen() {
        startActivity(MainActivity.newIntent(this))
    }

    override fun showErrorMessage(message: String) {
        Snackbar.make(window.decorView, message, Snackbar.LENGTH_LONG).show()
    }
}