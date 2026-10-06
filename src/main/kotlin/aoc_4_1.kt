package org.example

import java.io.File

fun main(){
    val input: List<String> = File("4_1.txt").readLines()
    val listList: List<List<String>> = input.map { str -> str.chunked(1) }
    val xSize = listList[0].size
    val ySize = listList.size
    var count = 0
    for (y in 0 until xSize){
        var listall: MutableList<String?> = mutableListOf()
        for (x in 0 until ySize){
            listall.add(listList.getOrNull(y-1)?.getOrNull(x-1))
            listall.add(listList.getOrNull(y-1)?.getOrNull(x))
            listall.add(listList.getOrNull(y-1)?.getOrNull(x+1))
            listall.add(listList.getOrNull(y)?.getOrNull(x-1))
            listall.add(listList.getOrNull(y)?.getOrNull(x+1))
            listall.add(listList.getOrNull(y+1)?.getOrNull(x-1))
            listall.add(listList.getOrNull(y+1)?.getOrNull(x))
            listall.add(listList.getOrNull(y+1)?.getOrNull(x+1))
            if(listall.count { s -> s == "@" } < 4
                && listList.getOrNull(y)?.getOrNull(x) == "@"){
                count++
            }
            listall.clear()
        }
    }
    print(count)

}