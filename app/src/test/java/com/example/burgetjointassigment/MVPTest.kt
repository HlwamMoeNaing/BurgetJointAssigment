package com.example.burgetjointassigment

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.burgetjointassigment.mvp.presenters.impl.MainPresenterImpl
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MVPTest {
    lateinit var mPresenter:MainPresenterImpl
}