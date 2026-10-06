package org.example

import java.io.File

fun main(){
    val input: List<String> = File("5_1.txt").readLines()
    val ingredientList: MutableList<Long> = mutableListOf()
    val iList: MutableList<Long> = mutableListOf()
    val rList: MutableList<LongRange> = mutableListOf()
    var count = 0

    for (i in 186 until input.size) {
        ingredientList.add(input[i].toLong())
    }
    for(l in 0 until 185){
        iList.addAll(input[l].split('-').map { it.toLong() })
    }
    for(r in iList.chunked(2)){
        rList.add(r[0]..r[1])
    }
    for (i in ingredientList){
        if (rList.any {i in it}){
            count++
        }
    }
    println(count)



}
