package com.example.ejercicio3

fun main() {
    val Ciclo01 = listOf(
        Estudiante("Ana", "001", "Programacion de Dispositivos Moviles"),
        Estudiante("Luis", "002", "Programacion de Dispositivos Moviles"),
        Estudiante("Carlos", "003", "Programacion de Dispositivos Mviles"),
        Estudiante("Maria", "004", "Analisis Numerico"),
        Estudiante("Pedro", "005", "Analisis Numerico"),
        Estudiante("Sofia", "006", "Analisis Numerico"),
        Estudiante("Juan", "007", "Analisis Numerico")
    )

// Filtrar solo moviles
    val moviles = Ciclo01.filter {
        it.asignatura == "Programacion de Dispositivos Moviles"
    }

// Mostrar resultados
    for (est in moviles) {
        println(est.nombre)
    }
}