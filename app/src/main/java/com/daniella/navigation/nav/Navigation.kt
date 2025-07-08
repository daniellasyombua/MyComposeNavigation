package com.daniella.navigation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.daniella.navigation.screens.HomeScreen
import com.daniella.navigation.screens.LoginScreen
import com.daniella.navigation.screens.SignUpScreen

sealed class Screen(val route: String){
    object Login:Screen("login")
    object SignUp:Screen("signup")
    object Home:Screen("home")
}

@Composable
fun AppNavigation(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = Screen.Login.route
    )
    {
        composable(Screen.Login.route){
            LoginScreen(
                onClickLogin = {navController.navigate(Screen.Home.route)},
                onClickSignUp = {navController.navigate(Screen.SignUp.route)}
            )
        }
        composable(Screen.SignUp.route){
            SignUpScreen(
                onClickLogin = {navController.navigate(Screen.Login.route)},
                onClickSignUp = {navController.navigate(Screen.Login.route)}
            )
    }
        composable(Screen.Home.route){
            HomeScreen(

            )

}
    }
}