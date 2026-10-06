package org.example

import java.io.File

fun main(){
    val input: List<String> = File("5_1.txt").readLines()
    val ingredientList: MutableList<Long> = mutableListOf()
    val iList: MutableList<Long> = mutableListOf()
    val rList: MutableList<LongRange> = mutableListOf()


    for(l in 0 until 185){
        iList.addAll(input[l].split('-').map { it.toLong() })
    }
    for(r in iList.chunked(2)){
        rList.add(r[0]..r[1])
    }

    // 1. Ranges mathematisch zusammenführen
    val mergedRanges = mergeRanges(rList)

    val output = mergedRanges.sumOf { r -> r.last - r.first + 1 }

    println(output)

}

// HILFSFUNKTION: Verschmilzt überschneidende oder angrenzende Ranges
fun mergeRanges(ranges: List<LongRange>): List<LongRange> {
    if (ranges.isEmpty()) return emptyList()

    // Nach dem Startwert sortieren
    val sortedRanges = ranges.sortedBy { it.first }
    val merged = mutableListOf<LongRange>()

    var current = sortedRanges[0]

    for (i in 1 until sortedRanges.size) {
        val next = sortedRanges[i]

        // Wenn sich die aktuelle und die nächste Range überschneiden oder aneinandergrenzen
        if (next.first <= current.last + 1) {
            // Aktuelle Range erweitern
            current = current.first..maxOf(current.last, next.last)
        } else {
            // Keine Überschneidung: Aktuelle Range speichern und mit der nächsten fortfahren
            merged.add(current)
            current = next
        }
    }
    // Die letzte verbleibende Range hinzufügen
    merged.add(current)

    return merged
}
