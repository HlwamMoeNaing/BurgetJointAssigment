package com.example.burgetjointassigment.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.Fade
import android.view.View
import android.view.Window
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.burgetjointassigment.R
import com.example.burgetjointassigment.adapters.BurgerAdapter
import com.example.burgetjointassigment.data.vos.BurgerVO
import com.example.burgetjointassigment.mvp.presenters.MainPresenter
import com.example.burgetjointassigment.mvp.presenters.impl.MainPresenterImpl
import com.example.burgetjointassigment.mvp.views.MainView


class MainActivity : BaseActivity(), MainView{
//
    private lateinit var mBurgerAdapter: BurgerAdapter
    private lateinit var mPresenter: MainPresenter
    lateinit var rvBurgerList:RecyclerView
   lateinit var mToolbar:Toolbar
    lateinit var tvCartCount:TextView
    lateinit var flContainer:FrameLayout
lateinit var ivCart:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpAnimations()
        setContentView(R.layout.activity_main)
       mToolbar = findViewById(R.id.mTbar)
        ivCart = findViewById(R.id.ivCart)
        rvBurgerList = findViewById(R.id.rvBurgerList)
        tvCartCount = findViewById(R.id.tvCartCount)
        flContainer = findViewById(R.id.flContainer)


        setSupportActionBar(mToolbar)
        setUpPresenter()
        setUpListeners()
        setUpRecycler()
        mPresenter.onUIReady(this)
    }

    private fun setUpAnimations() {
        with(window) {
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            val fade = Fade()
            fade.duration = 600
            exitTransition = fade
        }
    }

    private fun setUpListeners() {
        ivCart.setOnClickListener {
            mPresenter.onTapCart()
        }
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<MainPresenterImpl, MainView>()
    }

    private fun setUpRecycler() {
        mBurgerAdapter = BurgerAdapter(mPresenter)
        rvBurgerList.adapter = mBurgerAdapter
        rvBurgerList.layoutManager = GridLayoutManager(applicationContext, 1)
    }

    override fun navigateToBurgerDetailsScreenWithAnimation(
        burgerId: Int,
        burgerImageView: ImageView
    ) {
        val imagePair = Pair.create(burgerImageView as View, "tBurgerImage")
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imagePair)
        ActivityCompat.startActivity(
            this,
            BurgerDetailsActivity.newIntent(this, burgerId),
            options.toBundle()
        )
    }

    override fun navigateToCartScreen() {
        startActivity(
            CartActivity.newIntent(this),
            ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle()
        )
    }

    override fun displayBurgerList(burgerList: List<BurgerVO>) {
        mBurgerAdapter.setNewData(burgerList)
    }

    override fun displayCountInCart(burgersInCartCount: Int) {
        tvCartCount.text = burgersInCartCount.toString()
    }

    override fun addBurgerToCart(burger: BurgerVO, burgerImageView: ImageView) {
        //Play Animation
        val burgerPosition = getPositionOf(burgerImageView)
        val cartPosition = getPositionOf(ivCart)

        val imageSize = 80
        val viewToAnimate = setUpViewToAnimate(
            burger,
            burgerImageView, imageSize
        )

        flContainer.addView(viewToAnimate)

        val xAnimator = ObjectAnimator.ofFloat(
            viewToAnimate,
            View.TRANSLATION_X, burgerPosition[0].toFloat()
            , (cartPosition[0] - (imageSize * 2)).toFloat()
        )
        xAnimator.duration = 500

        val yAnimator = ObjectAnimator.ofFloat(
            viewToAnimate,
            View.TRANSLATION_Y, burgerPosition[1].toFloat()
            , (cartPosition[1] - (4 * imageSize)).toFloat()
        )
        yAnimator.duration = 500

        val alphaAnimator = ObjectAnimator.ofFloat(
            viewToAnimate,
            View.ALPHA, 0f, 1f
        )
        alphaAnimator.duration = 500

        val scaleXAnimator = ObjectAnimator.ofFloat(
            viewToAnimate,
            View.SCALE_X, 1f, 0.25f
        )

        val scaleYAnimator = ObjectAnimator.ofFloat(
            viewToAnimate,
            View.SCALE_Y, 1f, 0.25f
        )

        AnimatorSet().apply {
            play(xAnimator).with(yAnimator)
                .with(alphaAnimator).with(scaleXAnimator).with(scaleYAnimator)
            addListener(object : AnimatorListenerAdapter() {
//                override fun onAnimationEnd(animation: Animator?) {
//                    flRoot.removeView(viewToAnimate)
//                }
            })
            start()
        }
    }

    override fun animateAddBurgerToCart(burger: BurgerVO, burgerImageView: ImageView) {
        //Play Animation
        val burgerPosition = getPositionOf(burgerImageView)
        val cartPosition = getPositionOf(ivCart)

        val foodImageSize = 80
        val viewToAnimate = setUpViewToAnimate(burger, burgerImageView, foodImageSize)
        flContainer.addView(viewToAnimate)

        val xAnimator = ObjectAnimator.ofFloat(
            viewToAnimate, View.TRANSLATION_X,
            burgerPosition[0].toFloat(), cartPosition[0].toFloat() - foodImageSize * 2
        )
        xAnimator.duration = 500
        val yAnimator = ObjectAnimator.ofFloat(
            viewToAnimate, View.TRANSLATION_Y,
            burgerPosition[1].toFloat(), cartPosition[1].toFloat() - foodImageSize * 3
        )
        yAnimator.duration = 500
        val alphaAnimator = ObjectAnimator.ofFloat(
            viewToAnimate, View.ALPHA,
            0f, 1f
        )
        val scaleXAnimator = ObjectAnimator.ofFloat(
            viewToAnimate, View.SCALE_X,
            1f, 0.25f
        )
        scaleXAnimator.duration = 500
        val scaleYAnimator = ObjectAnimator.ofFloat(
            viewToAnimate, View.SCALE_Y,
            1f, 0.25f
        )
        scaleYAnimator.duration = 500
        AnimatorSet().apply {
            play(xAnimator).with(yAnimator)
                .with(alphaAnimator).with(scaleXAnimator).with(scaleYAnimator)
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    flContainer.removeView(viewToAnimate)
                }
            })
            start()
        }
    }

    private fun getPositionOf(view: View?): IntArray {
        val position = intArrayOf(0, 0)
        view?.getLocationOnScreen(position)
        return position
    }

    private fun setUpViewToAnimate(
        item: BurgerVO,
        imageView: ImageView,
        imageSize: Int
    ): ImageView {
        val viewToAnimate = ImageView(applicationContext)
        Glide.with(this)
            .load(item.burgerImageUrl)
            .into(viewToAnimate)
        val layoutParams = imageView.layoutParams
        layoutParams.height = imageView.height
        layoutParams.width = imageView.width
        viewToAnimate.layoutParams = layoutParams
        viewToAnimate.alpha = 0f
        return viewToAnimate
    }
}