package org.example

import java.io.File

fun rotations(rotations: Int): List<Int> {
    var zeroes = 0
    var r = rotations
    if(r > 100) {
        while (r > 100) {
            r -= 100
            zeroes++
        }

    }
    if (r < 0){
        while (r < 0) {
            r += 100
            zeroes++
        }
    }
    return listOf(r, zeroes)
}

fun main(){
    // Liest die gesamte Datei in einen einzigen String
    val zeilen: List<String> = File("1_1.txt").readLines()
    var i = 50
    var j = 50
    var z = 0
    var count = 0
    var listR = listOf<Int>(0)
    for (zeile in zeilen) {

       i += zeile.replace("R", "").replace("L","-").toInt()
        i = (i + 100) % 100

        if (i == 0) {z++}

    }
        println(z)

    for (zeile in zeilen) {
        z = zeile.replace("R", "").replace("L","-").toInt()


    }
    println(count)



}