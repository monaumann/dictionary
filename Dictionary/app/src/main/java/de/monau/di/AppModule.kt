package de.monau.di

import dagger.Module
import dagger.Provides
import de.monau.BaseApplication
import javax.inject.Named

@Module
class AppModule {

    @Provides
    @Named("AppModule")
    fun provideString(): String = "AppModule"

    @Provides
    @Named("Blub")
    fun provideBlub(): String = "Blub"
}