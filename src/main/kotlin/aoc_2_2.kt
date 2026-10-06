package org.example

import java.io.File

fun splits(str: String): String {
    val mitte = str.length / 2
    for (i in 1..mitte){
        val l = str.chunked(i).toSet()
        if (l.size == 1){
            return str
        }
    }
    return ""
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
            if(splits(i.toString()) != ""){
                wrongInputs.add(i)
            }

        }
    }

    println(wrongInputs.sum())


}