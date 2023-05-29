package com.example.burgetjointassigment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.burgetjointassigment.R
import com.example.burgetjointassigment.data.vos.BurgerVO
import com.example.burgetjointassigment.delegates.BurgerViewHolderActionDelegate
import com.example.burgetjointassigment.viewholder.BurgerViewHolder

class BurgerAdapter(private val mDelegate : BurgerViewHolderActionDelegate) : BaseRecyclerAdapter<BurgerViewHolder, BurgerVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BurgerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_burger,parent,false)
        return BurgerViewHolder(view, mDelegate)
    }
}