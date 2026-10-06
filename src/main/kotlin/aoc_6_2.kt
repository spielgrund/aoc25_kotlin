package org.example

import java.io.File
import java.math.BigInteger
import kotlin.collections.map
import kotlin.text.split

fun main(){
    val input: MutableList<String> = File("6_1.txt").readLines().toMutableList()
    val op: String = input[4]
    val opOnly: List<String> = op.split(Regex("[-,;\\s]+")).filter { it.isNotEmpty() }
    val opInt: MutableList<Int> = mutableListOf()

    var counter = 0
    for (s in op){
        if (s != ' '){
            opInt.add(counter)
            counter = 0
            continue
        }else{
            counter++
        }
    }
    opInt.add(2)
    println(opInt)
    opInt.removeFirst()

    val splitList: MutableList<List<String>> = mutableListOf()
    for (i in opInt){
        val l: MutableList<String> = mutableListOf()
        l.add(input[0].take(i))
        input[0] = input[0].drop(i + 1)
        l.add(input[1].take(i))
        input[1] = input[1].drop(i + 1)
        l.add(input[2].take(i))
        input[2] = input[2].drop(i + 1)
        l.add(input[3].take(i))
        input[3] = input[3].drop(i + 1)
        println(l)
        splitList.add(l)
    }
    val numbersList: MutableList<MutableList<BigInteger>> = mutableListOf()
    for (s in splitList){
        val iList: MutableList<BigInteger> = mutableListOf()
        for (i in 0 until s[0].length){
           iList.add(s.map { it.get(i)}.joinToString("").trim().toBigInteger())
        }
        numbersList.add(iList)
    }

    val bigList: MutableList<BigInteger> = mutableListOf()
    for(i in 0 until numbersList.size){
        if (opOnly[i] == "*"){
            bigList.add(numbersList[i].reduce { acc, num -> acc * num })
        }else{
            bigList.add(numbersList[i].sumOf{ it})
        }
    }

    println(bigList.sumOf { it })

}
