package com.example.burgetjointassigment.delegates

import android.widget.ImageView
import com.example.burgetjointassigment.data.vos.BurgerVO

interface BurgerViewHolderActionDelegate {
    fun onTapBurger(burger : BurgerVO, burgerImageView: ImageView)
    fun onTapAddToCart(burger : BurgerVO, burgerImageView: ImageView)
}