package com.canhptph44323.hoc_bai1_fpt

import android.os.Bundle
import android.transition.TransitionManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

class MainController : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
    @Composable
    fun MyApp() {
            val navController = rememberNavController()
            AppNavHost(navController =navController)
    }
}
