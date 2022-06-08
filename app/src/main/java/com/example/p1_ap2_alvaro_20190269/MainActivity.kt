package com.example.p1_ap2_alvaro_20190269

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.p1_ap2_alvaro_20190269.ui.Consulta.ConsultaScreen
import com.example.p1_ap2_alvaro_20190269.ui.Registro.RegistroScreen
import com.example.p1_ap2_alvaro_20190269.ui.theme.P1AP2Alvaro20190269Theme
import com.example.p1_ap2_alvaro_20190269.utils.Screens
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            P1AP2Alvaro20190269Theme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val navHostController = rememberNavController()

        NavHost(
            navController = navHostController,
            startDestination = Screens.ConsultaScreen.route
        ) {
            composable(Screens.ConsultaScreen.route){
                ConsultaScreen(navHostController = navHostController)
            }
            composable(Screens.RegistroScreen.route){
                RegistroScreen(navHostController = navHostController)
            }
        }

    }
}