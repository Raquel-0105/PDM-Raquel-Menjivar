package com.example.ejercicio1

fun main() {
    val pc = Computadora(8, 256, "Windows")

    pc.encender()

    pc.actualizar(16, 512, "Windows 11")

    println(pc.programasDelAnioActual())
}