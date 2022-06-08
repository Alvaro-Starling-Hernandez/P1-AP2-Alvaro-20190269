package com.example.p1_ap2_alvaro_20190269.ui.Consulta

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.p1_ap2_alvaro_20190269.ui.Prestamo.PrestamoViewModel
import com.example.p1_ap2_alvaro_20190269.ui.componentes.RowPrestamo
import com.example.p1_ap2_alvaro_20190269.utils.Screens

@Composable
fun ConsultaScreen(
    viewModel: PrestamoViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    Scaffold(

        topBar = {
                 TopAppBar(
                     title = {
                         Text("Lista de Prestamos")
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
            val listaPrestamos = viewModel.prestamos.collectAsState(initial = emptyList())

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(listaPrestamos.value){prestamo ->
                    RowPrestamo(prestamo = prestamo, navHostController = navHostController)
                    Divider(
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(1.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}