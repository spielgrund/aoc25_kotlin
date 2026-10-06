package org.example

import java.io.File

fun splitInHalf(str: String): Pair<String, String> {
    val mitte = str.length / 2
    return Pair(str.substring(0, mitte), str.substring(mitte))
}

fun main(){
    val input: List<String> = File("2_1.txt").readLines()
    println(input.size)
    val s: String = input[0]
    val inputList = s.split(",")
        .flatMap { str -> str.split("-") }
        .map { str -> str.toLong() }
        .chunked(2)

    val wrongInputs = mutableListOf<Long>()

    for((start,end) in inputList){
        for (i in start..end){
         val j = splitInHalf(i.toString())
            if (j.first == j.second){
                wrongInputs.add(i)
            }

        }
    }

    println(wrongInputs.sum())


}