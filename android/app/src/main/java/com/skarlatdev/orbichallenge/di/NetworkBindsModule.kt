package com.skarlatdev.orbichallenge.di

import com.skarlatdev.orbichallenge.data.JWTStorage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NetworkBindsModule {
    @Binds
    fun bindJwtStorage(impl: JWTStorage) : client.core.IJWTStorage
}