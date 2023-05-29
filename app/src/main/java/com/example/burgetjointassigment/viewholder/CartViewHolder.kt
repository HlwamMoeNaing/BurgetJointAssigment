package com.example.burgetjointassigment.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.burgetjointassigment.R
import com.example.burgetjointassigment.data.vos.BurgerVO
import com.example.burgetjointassigment.delegates.CartViewHolderActionDelegate
import com.google.android.material.button.MaterialButton


class CartViewHolder(itemView: View, private val mDelegate: CartViewHolderActionDelegate)
    : BaseViewHolder<BurgerVO>(itemView) {
    var btnRemoveFromCart:MaterialButton
    var tvBurgerName:TextView
    var tvDescription:TextView
    var ivBurger:ImageView

    init {
        btnRemoveFromCart = itemView.findViewById(R.id.btnRemoveFromCart)
        tvBurgerName = itemView.findViewById(R.id.tvBurgerName)
        tvDescription = itemView.findViewById(R.id.tvDescription)
        ivBurger = itemView.findViewById(R.id.ivBurger)
        btnRemoveFromCart.setOnClickListener {
            mData?.let {
                mDelegate.onTapRemoveFromCart(it)
            }
        }
    }

    override fun bindData(data: BurgerVO) {
        mData = data

       tvBurgerName.text = data.burgerName
     tvDescription.text = data.burgerDescription

        Glide.with(ivBurger)
            .load(data.burgerImageUrl)
            .into(ivBurger)
    }
}