package com.example.burgetjointassigment.delegates

import com.example.burgetjointassigment.data.vos.BurgerVO

interface CartViewHolderActionDelegate {
    fun onTapRemoveFromCart(burger : BurgerVO)
}