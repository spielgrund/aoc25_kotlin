package org.example

import java.io.File

fun main(){
    val input: Array<CharArray> = File("inputs/aoc_7_1t.txt")
        .readLines()
        .map { it.toCharArray() }.toTypedArray()

    var count = 0

    for (y in input.indices) {
        for (x in input[0].indices){
            if (input[y][x] == 'S') {
                input[y+1][x] = '|'
            }
            if (y < input.size - 1 && input[y][x] == '|' && input[y+1][x] == '^') {
                if (x > 0){
                    input[y+1][x-1] = '|'
                }
                if (x < input[0].size){
                    input[y+1][x+1] = '|'
                }
                count++
            }
            if (input[y][x] == '|' && y < input.size-1 && input[y+1][x] == '.') {
                input[y+1][x] = '|'
            }
        }
    }
    input.map { println(it) }
    println(count)
}