package org.example

import java.io.File

fun main(){
    val input: List<String> = File("3_1.txt").readLines()
    val output = mutableListOf<Int>()
    for (s in input){
        val l = s.chunked(1).map { it.toInt() }
        val first = l.dropLast(1).max()
        val second = l.subList(l.indexOf(first)+1, l.size).max()
        println("$first $second")
        output.add(first * 10 + second)
    }
println(output)
    println(output.sum())

}