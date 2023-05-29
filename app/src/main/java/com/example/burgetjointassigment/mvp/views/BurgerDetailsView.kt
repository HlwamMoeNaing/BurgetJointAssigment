package com.example.burgetjointassigment.mvp.views

import com.example.burgetjointassigment.data.vos.BurgerVO

interface BurgerDetailsView : BaseView {
    fun displayBurgerDetails(burger : BurgerVO)
}