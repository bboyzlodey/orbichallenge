package com.skarlatdev.orbichallenge.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.skarlatdev.orbichallenge.authentication.Google
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import timber.log.Timber

@Module
@InstallIn(ActivityComponent::class)
class AuthModule {

    @Provides
    fun provideGoogleSignInStrategy(
        @ActivityContext context: Context,
        jwtStorage: client.core.IJWTStorage
    ): Google {
        return Google(
            jwtStorage,
            { it?.let { error -> Timber.e(error) } },
            context as AppCompatActivity
        )
    }
}