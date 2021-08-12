package com.skarlatdev.orbichallenge.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.aartikov.sesame.navigation.NavigationMessageDispatcher
import me.aartikov.sesame.navigation.NavigationMessageQueue
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NavigationModule {

    @Provides
    @Singleton
    fun provideNavigationDispatcher() : NavigationMessageDispatcher {
        return NavigationMessageDispatcher()
    }

    @Provides
    @Singleton
    fun navigationMessageQueue() : NavigationMessageQueue {
        return NavigationMessageQueue()
    }
}