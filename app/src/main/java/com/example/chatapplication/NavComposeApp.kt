package com.project.flashchat

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.project.flashchat.nav.Action
import com.project.flashchat.nav.Destination.AuthenticationOption
import com.project.flashchat.nav.Destination.Home
import com.project.flashchat.nav.Destination.Login
import com.project.flashchat.nav.Destination.Register
import com.project.flashchat.ui.theme.FlashChatTheme
import com.project.flashchat.view.AuthenticationView
import com.project.flashchat.view.home.HomeView
import com.project.flashchat.view.login.LoginView
import com.project.flashchat.view.register.RegisterView


@Composable
fun NavComposeApp() {
    val navController = rememberNavController()
    val actions = remember(navController) { Action(navController) }
    FlashChatTheme {
        NavHost(
            navController = navController,
            startDestination =
            if (FirebaseAuth.getInstance().currentUser != null)
                Home
            else
                AuthenticationOption
        ) {
            composable(AuthenticationOption) {
                AuthenticationView(
                    register = actions.register,
                    login = actions.login
                )
            }
            composable(Register) {
                RegisterView(
                    home = actions.home,
                    back = actions.navigateBack
                )
            }
            composable(Login) {
                LoginView(
                    home = actions.home,
                    back = actions.navigateBack
                )
            }
            composable(Home) {
                HomeView()
            }
        }
    }
}
