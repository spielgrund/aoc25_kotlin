package org.example

import java.io.File

fun main(){
    val input: List<String> = File("4_1.txt").readLines()
    val listList: MutableList<MutableList<String>> = input.map { str -> str.chunked(1) } as MutableList<MutableList<String>>
    val xSize = listList[0].size
    val ySize = listList.size
    val listP : MutableList<Pair<Int,Int>> = mutableListOf()
    var count = 0
    while (true) {
        for (y in 0 until xSize) {
            var listall: MutableList<String?> = mutableListOf()
            for (x in 0 until ySize) {
                listall.add(listList.getOrNull(y - 1)?.getOrNull(x - 1))
                listall.add(listList.getOrNull(y - 1)?.getOrNull(x))
                listall.add(listList.getOrNull(y - 1)?.getOrNull(x + 1))
                listall.add(listList.getOrNull(y)?.getOrNull(x - 1))
                listall.add(listList.getOrNull(y)?.getOrNull(x + 1))
                listall.add(listList.getOrNull(y + 1)?.getOrNull(x - 1))
                listall.add(listList.getOrNull(y + 1)?.getOrNull(x))
                listall.add(listList.getOrNull(y + 1)?.getOrNull(x + 1))
                if (listall.count { s -> s == "@" } < 4
                    && listList.getOrNull(y)?.getOrNull(x) == "@") {
                    listP.add(Pair(y, x))
                    count++
                }
                listall.clear()
            }
        }
        for (e in listP) {
            listList[e.first][e.second] = "x"
        }
        if (listP.isEmpty()) {
            break
        } else {
            listP.clear()
        }
    }
    println(count)
    println(listList)

}