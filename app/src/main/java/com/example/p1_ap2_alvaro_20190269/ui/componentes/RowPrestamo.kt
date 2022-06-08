package com.example.p1_ap2_alvaro_20190269.ui.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.p1_ap2_alvaro_20190269.model.Prestamo
import com.example.p1_ap2_alvaro_20190269.utils.Screens

@Composable
fun RowPrestamo(
    prestamo: Prestamo,
    navHostController: NavHostController
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(25.dp)
            .clickable {
                navHostController.navigate(Screens.RegistroScreen.route)
            }
    ) {
        Text(prestamo.deudor)
        Text(
            text = prestamo.monto.toString(),
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}