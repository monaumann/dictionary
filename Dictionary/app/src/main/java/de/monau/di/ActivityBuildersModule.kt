package de.monau.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.monau.DictionaryActivity

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeDictionaryActivity() : DictionaryActivity
}