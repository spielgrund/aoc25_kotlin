package org.example

import java.io.File

fun main(){
    // Liest die gesamte Datei in einen einzigen String
    val zeilen: List<String> = File("1_1.txt").readLines()

    var rot = 50
    var count = 0
    var i = 0

    for (zeile in zeilen) {
        i = zeile.replace("R", "").replace("L","-").toInt()
        println("z: " + i)
        if (i > 0){
            while (i > 0){
                i--
                rot++
                if (rot == 100){
                    rot = 0
                    count++
                }
            }
        }

        if (i < 0)
        {
            if (rot == 0){
                rot = 100
            }
            while (i < 0){
                i++
                rot--
                if (rot == 0){
                    rot = 100
                    count++
                }
            }
        }
        if (rot == 100){
            rot = 0
        }
        println(rot)
    }

    println(count)


}