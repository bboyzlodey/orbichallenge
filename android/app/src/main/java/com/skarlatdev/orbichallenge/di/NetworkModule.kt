package com.skarlatdev.orbichallenge.di

import client.core.IJWTStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import data.network.ServerApi
import data.network.ServerApiClient

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideServerApi(tokenStorage: IJWTStorage): ServerApi {
        return ServerApiClient(tokenStorage = tokenStorage)
    }
}