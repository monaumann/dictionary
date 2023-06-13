package de.monau.di

import android.content.Context
import dagger.Module
import dagger.Provides
import de.monau.BaseApplication
import javax.inject.Named

@Module
class AppModule {

    @Provides
    fun provideAppContext(application: BaseApplication): Context =
        application.applicationContext
}