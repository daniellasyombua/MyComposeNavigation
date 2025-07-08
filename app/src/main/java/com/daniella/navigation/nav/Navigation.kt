package com.daniella.navigation.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Create
import androidx.compose.material.icons.sharp.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.daniella.navigation.screens.HomeScreen
import com.daniella.navigation.screens.LoginScreen
import com.daniella.navigation.screens.SignUpScreen
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material.icons.sharp.ShoppingCart


sealed class Screen(val route: String){
    object Login:Screen("login")
    object SignUp:Screen("signup")
    object Home:Screen("home")
}

sealed class HomeTab(val route:String, var title:String, var icon: ImageVector){

    object Home: HomeTab("hometab","Home", Icons.Sharp.Home)
    object Products: HomeTab("products","Products", Icons.Sharp.ShoppingCart)
    object Payments: HomeTab("payments","Payments", Icons.Sharp.Create)
    object Settings: HomeTab("settings","Settings", Icons.Sharp.Settings)





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