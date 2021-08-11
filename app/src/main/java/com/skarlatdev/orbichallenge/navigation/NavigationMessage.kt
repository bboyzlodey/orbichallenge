package com.skarlatdev.orbichallenge.navigation

import androidx.navigation.NavDirections

sealed interface NavigationMessage : me.aartikov.sesame.navigation.NavigationMessage {
    object Back : NavigationMessage
    class NavigateTo(val direction: NavDirections) : NavigationMessage
    class ShowMessage(val message: String) : NavigationMessage
}