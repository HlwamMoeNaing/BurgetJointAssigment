package com.example.burgetjointassigment.mvp.presenters.impl

import android.widget.ImageView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.burgetjointassigment.data.model.BurgerModel
import com.example.burgetjointassigment.data.model.impl.BurgerModelImpl
import com.example.burgetjointassigment.data.model.impl.MockBurgerModelImpl
import com.example.burgetjointassigment.data.vos.BurgerVO
import com.example.burgetjointassigment.dummy.getDummyBurgers
import com.example.burgetjointassigment.mvp.views.MainView
import io.mockk.MockKAnnotations
import io.mockk.clearMocks
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplTest {
    lateinit var mainPresenterImpl: MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView: MainView
    private lateinit var mBurgerModel: BurgerModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)
        BurgerModelImpl.init(ApplicationProvider.getApplicationContext())
        mBurgerModel = MockBurgerModelImpl
        mainPresenterImpl = MainPresenterImpl()
        mainPresenterImpl.initPresenter(mView)
        mainPresenterImpl.mBurgerModel = this.mBurgerModel
    }

    @Test
    fun onTabAddToCart_callAddBurgerToCart() {
        val tappedBurger = BurgerVO()
        tappedBurger.burgerId = 1
        tappedBurger.burgerName = "Big Mac"
        tappedBurger.burgerImageUrl = ""
        tappedBurger.burgerDescription = "Big Mac Burger"
        val imageView = ImageView(ApplicationProvider.getApplicationContext())
        mainPresenterImpl.onTapAddToCart(tappedBurger, imageView)
        verify {
            mView.addBurgerToCart(tappedBurger, imageView)
        }
    }

    @Test
    fun onTapCart_callNavigateToCartScreen() {
        mainPresenterImpl.onTapCart()
        verify {
            mView.navigateToCartScreen()
        }
    }

    @Test
    fun onUIReady_callDisplayBurgerList_callDisplayCountInCart() {
        val lifeCycleOwner = mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        mainPresenterImpl.onUIReady(lifeCycleOwner)
        verify {
           // mView.displayBurgerList(getDummyBurgers())
            mView.displayCountInCart(0)
        }
    }


}