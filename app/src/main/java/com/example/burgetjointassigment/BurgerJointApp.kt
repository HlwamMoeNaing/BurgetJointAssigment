package com.example.burgetjointassigment

import android.app.Application
import com.example.burgetjointassigment.data.model.impl.BurgerModelImpl
import com.example.burgetjointassigment.dummy.getDummyBurgers
import com.example.burgetjointassigment.persistance.BurgerJointDatabase

class BurgerJointApp : Application() {
    override fun onCreate() {
        super.onCreate()
        BurgerModelImpl.init(applicationContext)
        deleteAllBurgers()
        prepopulateBurgers()
    }

    private fun deleteAllBurgers(){
        BurgerJointDatabase.getInstance(applicationContext)
            .getBurgerDao()
            .deleteAllBurgers()
    }

    private fun prepopulateBurgers(){
        BurgerJointDatabase.getInstance(applicationContext)
            .getBurgerDao()
            .insertBurgers(getDummyBurgers())
    }
}