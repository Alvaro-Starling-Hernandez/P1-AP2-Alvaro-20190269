package com.example.p1_ap2_alvaro_20190269.ui.Consulta

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.p1_ap2_alvaro_20190269.utils.Screens

@Composable
fun ConsultaScreen(navHostController: NavHostController) {
    Scaffold(

        topBar = {
                 TopAppBar(
                     title = {
                         Text("Consulta")
                     }
                 )
        },
        floatingActionButton = {

            FloatingActionButton(
                onClick = { navHostController.navigate(Screens.RegistroScreen.route)}
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }

        },
        floatingActionButtonPosition = FabPosition.End

    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .absolutePadding(16.dp, 16.dp, 16.dp, 16.dp)
        ) {

        }
    }
}