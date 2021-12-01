package com.skarlatdev.orbichallenge.authentication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import client.core.IJWTStorage
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

sealed class AuthStrategy(
    private val jwtStorage: IJWTStorage,
    private val errorHandler: (Throwable?) -> Unit
) {
    abstract fun authenticate(bundle: Bundle)

    fun logout() {
        logoutRemote()
        logoutLocal()
    }

    protected abstract fun logoutRemote()

    private fun logoutLocal() {
        jwtStorage.clearToken()
    }
}

class Google @Inject constructor(
    jwtStorage: IJWTStorage,
    errorHandler: (Throwable?) -> Unit,
    activity: AppCompatActivity,
    private val serverApiClient: data.network.ServerApiClient
) : AuthStrategy(jwtStorage, errorHandler) {
    private val clientId =
        "1009427048381-mamgtjis588hcp30jclucilrsasqorpm.apps.googleusercontent.com"

    private val gso
        get() = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestProfile()
            .requestEmail()
            .requestId()
            .requestIdToken(clientId)
            .requestProfile()
            .build()

    private val googleSignInClient by lazy { GoogleSignIn.getClient(activity, gso) }
    private val signInResultApi = activity.registerForActivityResult(
        object : ActivityResultContract<Unit, String?>() {

            override fun createIntent(context: Context, input: Unit): Intent {
                return googleSignInClient.signInIntent
            }

            override fun parseResult(resultCode: Int, intent: Intent?): String? {
                if (Activity.RESULT_OK == resultCode) {
                    try {
                        val task = GoogleSignIn.getSignedInAccountFromIntent(intent)
                        if (!task.isSuccessful) {
                            errorHandler.invoke(task.exception)
                        }
                        return task.result.idToken
                    } catch (e: ApiException) {
                        errorHandler.invoke(e)
                    }
                }
                val task = GoogleSignIn.getSignedInAccountFromIntent(intent)
                errorHandler.invoke(task.exception)
                return null
            }

        }
    ) { result ->
        Timber.d("onActivityResult $result")
        result?.let {
            GlobalScope.launch(client.core.Dispatchers.IO) {
                kotlin.runCatching {
                    val jwtToken = serverApiClient.signInWithGoogle(result)
                    Timber.d("jwt token is ${jwtToken}")
                    withContext(Dispatchers.Main) {
                        jwtStorage.updateToken(jwtToken)
                    }
                }
            }
        }
    }

    override fun authenticate(bundle: Bundle) {
        signInResultApi.launch(Unit)
    }

    override fun logoutRemote() {
        googleSignInClient.signOut()
    }
}