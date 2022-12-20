package de.monau.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.monau.VerbFragment

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeVerbFragment() : VerbFragment
}