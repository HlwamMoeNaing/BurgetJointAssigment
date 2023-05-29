package com.example.burgetjointassigment.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.burgetjointassigment.R
import com.example.burgetjointassigment.data.vos.BurgerVO
import com.example.burgetjointassigment.mvp.presenters.BurgerDetailsPresenter
import com.example.burgetjointassigment.mvp.presenters.impl.BurgerDetailsPresenterImpl
import com.example.burgetjointassigment.mvp.views.BurgerDetailsView


class BurgerDetailsActivity : BaseActivity(), BurgerDetailsView {
    lateinit var ivBurger:ImageView
    lateinit var tvBurgerName:TextView
lateinit var tvDescription:TextView
    companion object{

        private const val EXTRA_BURGER_ID = "Burger Id Extra"

        fun newIntent(context: Context, burgerId : Int): Intent {
            val intent = Intent(context, BurgerDetailsActivity::class.java)
            intent.putExtra(EXTRA_BURGER_ID,burgerId)
            return intent
        }
    }

    private lateinit var mPresenter : BurgerDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_burger_details)
        ivBurger = findViewById(R.id.ivDetailBurger)
        tvBurgerName = findViewById(R.id.tvDetailBurgerName)
        tvDescription  = findViewById(R.id.tvDetailDescription)

        setUpPresenter()
        setUpListeners()
        val burgerId = intent.getIntExtra(EXTRA_BURGER_ID, 0)

        mPresenter.onBurgerDetailsUiReady(this, burgerId)
    }

    private fun setUpListeners(){
        ivBurger.setOnClickListener {
            val animation =  AnimationUtils.loadAnimation(applicationContext, R.anim.rotate)
            ivBurger.startAnimation(animation)
        }
    }

    private fun setUpPresenter(){
        mPresenter = getPresenter<BurgerDetailsPresenterImpl,BurgerDetailsView>()
    }

    override fun displayBurgerDetails(burger : BurgerVO) {
        tvBurgerName.text = burger.burgerName
        tvDescription.text = burger.burgerDescription
        Glide.with(ivBurger)
            .load(burger.burgerImageUrl)
            .into(ivBurger)
    }

}