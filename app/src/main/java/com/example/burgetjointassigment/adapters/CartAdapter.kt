package com.example.burgetjointassigment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.burgetjointassigment.R
import com.example.burgetjointassigment.data.vos.BurgerVO
import com.example.burgetjointassigment.delegates.CartViewHolderActionDelegate
import com.example.burgetjointassigment.viewholder.CartViewHolder


class CartAdapter(private val mDelegate : CartViewHolderActionDelegate) : BaseRecyclerAdapter<CartViewHolder, BurgerVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_cart,parent,false)
        return CartViewHolder(view, mDelegate)
    }
}