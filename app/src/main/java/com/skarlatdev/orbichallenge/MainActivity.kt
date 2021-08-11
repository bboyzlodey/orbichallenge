package com.skarlatdev.orbichallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import me.aartikov.sesame.navigation.NavigationMessage
import me.aartikov.sesame.navigation.NavigationMessageDispatcher
import me.aartikov.sesame.navigation.NavigationMessageHandler
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NavigationMessageHandler {

    private val navController by lazy { findNavController(R.id.nav_host) }

    @Inject
    lateinit var navigationDispatcher: NavigationMessageDispatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun handleNavigationMessage(message: NavigationMessage): Boolean {
        kotlin.runCatching {
            when (message) {
                is com.skarlatdev.orbichallenge.navigation.NavigationMessage.NavigateTo -> navController.navigate(
                    message.direction
                )
                is com.skarlatdev.orbichallenge.navigation.NavigationMessage.Back -> {
                    if (!navController.popBackStack()) finish()
                }
                is com.skarlatdev.orbichallenge.navigation.NavigationMessage.ShowMessage -> showMessage(
                    message.message
                )
                else -> {
                    return false
                    Timber.e("Unknown navigation command ${message::javaClass.name}")
                }
            }
        }.getOrElse { Timber.e(it) }
        return true
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationDispatcher.resume()
    }

    override fun onPause() {
        navigationDispatcher.pause()
        super.onPause()
    }

    private fun showMessage(message: String) {

    }
}