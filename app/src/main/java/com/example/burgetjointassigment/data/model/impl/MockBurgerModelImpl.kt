package com.example.burgetjointassigment.data.model.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.burgetjointassigment.data.model.BurgerModel
import com.example.burgetjointassigment.data.vos.BurgerVO
import com.example.burgetjointassigment.dummy.getDummyBurgers

object MockBurgerModelImpl : BurgerModel {

    var burgersInOrder: MutableList<BurgerVO> = arrayListOf()
    var burgersInOrderLiveData = MutableLiveData<List<BurgerVO>>()

    override fun getAllBurgers(): LiveData<List<BurgerVO>> {
        val liveData = MutableLiveData<List<BurgerVO>>()
        liveData.postValue(getDummyBurgers())
        return liveData
    }

    override fun findBurgerById(burgerId: Int): LiveData<BurgerVO> {
        val liveData = MutableLiveData<BurgerVO>()
        liveData.postValue(getDummyBurgers().first { it.burgerId == burgerId })
        return liveData
    }

    override fun getBurgersInCart(): LiveData<List<BurgerVO>> {
        burgersInOrderLiveData.postValue(burgersInOrder)
        return burgersInOrderLiveData
    }

    override fun removeItemFromCart(burger: BurgerVO) {
        burgersInOrder.remove(burger)
        burgersInOrderLiveData.postValue(burgersInOrder)
    }

    override fun addItemToCart(burger: BurgerVO) {
        burgersInOrder.add(burger)
        burgersInOrderLiveData.postValue(burgersInOrder)
    }
}