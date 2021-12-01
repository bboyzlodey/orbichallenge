package client.core

interface IJWTStorage {
    fun getToken() : String
    fun clearToken()
    fun updateToken(token: String)
}