package com.example.burgetjointassigment.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.example.burgetjointassigment.R
import com.example.burgetjointassigment.data.vos.BurgerVO
import com.example.burgetjointassigment.delegates.BurgerViewHolderActionDelegate
import com.google.android.material.button.MaterialButton


class BurgerViewHolder(itemView: View, private val mDelegate: BurgerViewHolderActionDelegate)
    : BaseViewHolder<BurgerVO>(itemView) {
    var tvBurgerName:TextView
    var tvDescription:TextView
    var ivBurger:ImageView


    init {
      val cvBurgerImage = itemView.findViewById<CardView>(R.id.cvBurgerImage)
        val btnAddToCart = itemView.findViewById<MaterialButton>(R.id.btnAddToCart)
        tvBurgerName = itemView.findViewById(R.id.tvBurgerName)
        tvDescription = itemView.findViewById(R.id.tvDescription)
        ivBurger = itemView.findViewById(R.id.ivBurger)
        cvBurgerImage.setOnClickListener {
            mData?.let {
                mDelegate.onTapBurger(it,ivBurger)
            }
        }

        btnAddToCart.setOnClickListener {
            mData?.let {
                mDelegate.onTapAddToCart(it, ivBurger)
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