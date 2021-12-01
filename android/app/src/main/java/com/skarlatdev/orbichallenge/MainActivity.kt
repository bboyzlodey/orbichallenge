package com.skarlatdev.orbichallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.skarlatdev.orbichallenge.authentication.Google
import com.skarlatdev.orbichallenge.presentation.SignInComposable
import dagger.hilt.android.AndroidEntryPoint
import me.aartikov.sesame.navigation.NavigationMessage
import me.aartikov.sesame.navigation.NavigationMessageDispatcher
import me.aartikov.sesame.navigation.NavigationMessageHandler
import me.aartikov.sesame.navigation.bind
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationMessageHandler {

    private val navController by lazy { findNavController(R.id.nav_host) }
    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var googleSignInStrategy: Google

    @Inject
    lateinit var navigationDispatcher: NavigationMessageDispatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_ORBIChallenge)
        super.onCreate(savedInstanceState)
        setContent {
            SignInComposable {
                googleSignInStrategy.authenticate(Bundle.EMPTY)
            }
        }
    }

    private fun initNavigation() {
        setContentView(R.layout.activity_main)
        viewModel.navigationMessageQueue.bind(navigationDispatcher, this, this)
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
                    Timber.e("Unknown navigation command ${message::javaClass.name}")
                    return false
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