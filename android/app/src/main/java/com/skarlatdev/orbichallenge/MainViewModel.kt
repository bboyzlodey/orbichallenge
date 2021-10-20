package com.skarlatdev.orbichallenge

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import me.aartikov.sesame.navigation.NavigationMessageQueue
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val navigationMessageQueue: NavigationMessageQueue) : ViewModel() {
}