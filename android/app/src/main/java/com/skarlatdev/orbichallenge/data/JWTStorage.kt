package com.skarlatdev.orbichallenge.data

import android.content.Context
import client.core.IJWTStorage
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class JWTStorage @Inject constructor(@ApplicationContext context: Context) : IJWTStorage {

    private val settings = context.getSharedPreferences("jwt_orbi", Context.MODE_PRIVATE)

    override fun getToken(): String = settings.getString("jwt", "")!!

    override fun clearToken() = settings.edit().clear().apply()

    override fun updateToken(token: String) = settings.edit().putString("jwt", token).apply()
}