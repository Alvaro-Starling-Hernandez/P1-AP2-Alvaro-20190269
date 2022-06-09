package com.example.p1_ap2_alvaro_20190269.ui.Registro

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.p1_ap2_alvaro_20190269.ui.Prestamo.PrestamoViewModel
import com.example.p1_ap2_alvaro_20190269.ui.componentes.TextObligatorio

@Composable
fun RegistroScreen(
    navHostController: NavHostController,
    viewModel: PrestamoViewModel = hiltViewModel()
) {

    var deudorError by rememberSaveable { mutableStateOf(false) }
    var conceptoError by rememberSaveable { mutableStateOf(false) }
    var montoError by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current

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
                    deudorError = viewModel.deudor.isBlank()
                    conceptoError = viewModel.concepto.isBlank()
                    montoError = viewModel.monto.isBlank()
                    if(!deudorError && !conceptoError && !montoError){
                        if(viewModel.monto.toFloat() > 0){
                            viewModel.Guardar()
                            navHostController.navigateUp()
                        }else{
                            Toast.makeText(context, "El monto no puede ser menor o igual a cero", Toast.LENGTH_SHORT).show()
                        }
                    }

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
                onValueChange = {
                    viewModel.deudor = it
                    deudorError = false
                },
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
                ),
                isError = deudorError
            )

            TextObligatorio(error = deudorError)

            Spacer(modifier = Modifier.height(25.dp))

            OutlinedTextField(
                value = viewModel.concepto,
                onValueChange = {
                    viewModel.concepto = it
                    conceptoError = false
                },
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
                ),
                isError = conceptoError
            )

            TextObligatorio(error = conceptoError)

            Spacer(modifier = Modifier.height(25.dp))

            OutlinedTextField(
                value = viewModel.monto,
                onValueChange = {
                    viewModel.monto = it
                    montoError = false
                },
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
                ),
                isError = montoError
            )

            TextObligatorio(error = montoError)

            Spacer(modifier = Modifier.height(25.dp))
        }

    }
}