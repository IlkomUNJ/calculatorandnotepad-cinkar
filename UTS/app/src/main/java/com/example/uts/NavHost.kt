package com.example.uts

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "LoginScreen") {
        composable(route = "LoginScreen") {
            LoginScreen(navController)
        }
        composable(route = "DashboardScreen") {
            DashboardScreen(navController)
        }
        composable(route = "AddStudentScreen") {
            AddStudentScreen(navController)
        }
    }
}