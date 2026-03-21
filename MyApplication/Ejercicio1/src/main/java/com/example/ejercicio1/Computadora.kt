package com.example.ejercicio1

class Computadora(
    var ram: Int,
    var almacenamiento: Int,
    var sistemaOperativo: String
) {

    var programasInstalados = listOf(
        "Notion 2026",
        "Facebook 2024",
        "Android Studio 2026",
        "Spotify 2025"
    )

    fun encender() {
        println("La computadora esta encendida")
    }

    fun apagar() {
        println("La computadora esta apagada")
    }

    fun actualizar(nuevaRam: Int, nuevoAlmacenamiento: Int, nuevoSO: String) {
        ram = nuevaRam
        almacenamiento = nuevoAlmacenamiento
        sistemaOperativo = nuevoSO
        println("Computadora actualizada")
    }

    fun programasDelAnioActual(): List<String> {
        return programasInstalados.filter { it.contains("2026") }
    }
}