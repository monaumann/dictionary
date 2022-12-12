package de.monau.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.monau.PrimaryActivity

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributePrimaryActivity() : PrimaryActivity
}