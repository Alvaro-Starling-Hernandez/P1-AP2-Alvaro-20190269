package com.example.p1_ap2_alvaro_20190269.utils

sealed class Screens(val route:String) {
    object ConsultaScreen: Screens("ConsultaScreen")
    object RegistroScreen: Screens("RegistroScreen")
}