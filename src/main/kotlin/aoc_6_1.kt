package org.example

import java.io.File

fun main(){
    val input: List<List<String>> = File("6_1.txt")
        .readLines()
        .map { s -> s.split(Regex("[-,;\\s]+")).filter { it.isNotEmpty() } }

    var sum = 0L

    for (i in input[0].indices) {
        val iList = input.map { it[i] }
            .dropLast(1)
            .map { it.toLong() }

        if(input.last()[i] == "+"){
            sum += iList.sum()
        }else{
          sum +=  iList.reduce { acc, num -> acc * num }
        }
    }

    println(sum)



}
