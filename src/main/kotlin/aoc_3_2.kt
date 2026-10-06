package org.example

import java.io.File

fun main(){
    val input: List<String> = File("3_1t.txt").readLines()
    var vorne = mutableListOf<Int>()
    for (s in input){
        val l = s.chunked(1).map { it.toInt() }
        val first = l.dropLast(12).max()
        vorne.add(first)
         var hinten = l.subList(l.indexOf(first)+1, l.size) as MutableList<Int>
        while(vorne.size + hinten.size > 12 && hinten.size > 1){
            vorne.add(hinten[0])
            hinten = hinten.subList(1,hinten.size)
        }
        println("$vorne $hinten")
        vorne.clear()
        hinten.clear()

    }
}