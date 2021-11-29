package client.core

import android.content.SharedPreferences

interface IJWTStorage {
    fun getToken() : String
    fun clearToken()
    fun updateToken(token: String): SharedPreferences.Editor?
}