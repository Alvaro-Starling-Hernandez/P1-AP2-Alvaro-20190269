package com.example.p1_ap2_alvaro_20190269.ui.Registro

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.p1_ap2_alvaro_20190269.ui.Prestamo.PrestamoViewModel

@Composable
fun RegistroScreen(
    navHostController: NavHostController,
    viewModel: PrestamoViewModel = hiltViewModel()
) {
    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Registro De Prestamos")
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "ArrowBack",
                        modifier = Modifier.clickable {
                            navHostController.popBackStack()
                        }
                    )
                }
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.Guardar()
                    navHostController.navigateUp()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = null
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End

    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .absolutePadding(16.dp, 16.dp, 16.dp, 16.dp)
        ) {

            OutlinedTextField(
                value = viewModel.deudor,
                onValueChange = { viewModel.deudor = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Deudor")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Text
                )
            )

            Spacer(modifier = Modifier.height(25.dp))

            OutlinedTextField(
                value = viewModel.concepto,
                onValueChange = { viewModel.concepto = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Concepto")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Description,
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    keyboardType = KeyboardType.Text
                )
            )

            Spacer(modifier = Modifier.height(25.dp))

            OutlinedTextField(
                value = viewModel.monto,
                onValueChange = { viewModel.monto = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Monto")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AttachMoney,
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Number
                )
            )

            Spacer(modifier = Modifier.height(25.dp))
        }

    }
}