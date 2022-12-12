package de.monau

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import de.monau.di.DaggerAppComponent

class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().application(this).build()
}