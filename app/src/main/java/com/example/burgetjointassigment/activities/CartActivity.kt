package com.example.burgetjointassigment.activities

import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.burgetjointassigment.R
import com.example.burgetjointassigment.adapters.CartAdapter
import com.example.burgetjointassigment.data.vos.BurgerVO
import com.example.burgetjointassigment.mvp.presenters.CartPresenter
import com.example.burgetjointassigment.mvp.presenters.impl.CartPresenterImpl
import com.example.burgetjointassigment.mvp.views.CartView


class CartActivity : BaseActivity(), CartView {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CartActivity::class.java)
        }
    }

    private lateinit var mBurgerAdapter: CartAdapter
    private lateinit var mPresenter: CartPresenter
    lateinit var btnCheckOut:TextView
    lateinit var toolbar: Toolbar
    lateinit var ivCancel:ImageView
    lateinit var rvCart:RecyclerView
    lateinit var rlThankYouMessage:RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpAnimations()
        setContentView(R.layout.activity_cart)
        btnCheckOut = findViewById(R.id.btnCheckOut)
        toolbar = findViewById(R.id.toolbar)
        ivCancel = findViewById(R.id.ivCancel)
        rvCart = findViewById(R.id.rvCart)
        rlThankYouMessage = findViewById(R.id.rlThankYouMessage)

        setSupportActionBar(toolbar)
        setUpPresenter()
        setUpListeners()
        setUpRecycler()
        mPresenter.onUIReady(this)
    }

    private fun setUpAnimations(){
        with(window){
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            val slide = Slide()
            slide.slideEdge = Gravity.RIGHT
            slide.interpolator = AccelerateDecelerateInterpolator()
            slide.duration = 500

            enterTransition = slide
            exitTransition = slide
        }
    }

    private fun setUpListeners() {
        btnCheckOut.setOnClickListener { mPresenter.onTapCheckout() }
        ivCancel.setOnClickListener { mPresenter.onTapCancelThankYouMessage() }
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<CartPresenterImpl, CartView>()
    }

    private fun setUpRecycler() {
        mBurgerAdapter = CartAdapter(mPresenter)
        rvCart.adapter = mBurgerAdapter
        rvCart.layoutManager = GridLayoutManager(applicationContext, 1)
    }

    override fun displayItemsInCart(burgers: List<BurgerVO>) {
        mBurgerAdapter.setNewData(burgers)
    }

    override fun displayThankYouMessage() {
        rlThankYouMessage.visibility = View.VISIBLE

        val animator = ObjectAnimator.ofFloat(rlThankYouMessage,
            View.TRANSLATION_Y, rlThankYouMessage.height.toFloat(), 0f)
        animator.duration = 500
        animator.start()
    }

    override fun hideThankYouMessage() {
        val animator = ObjectAnimator.ofFloat(rlThankYouMessage,
            View.TRANSLATION_Y, 0f, rlThankYouMessage.height.toFloat())
        animator.duration = 500
        animator.start()
    }
}