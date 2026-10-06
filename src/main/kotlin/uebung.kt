package org.example


fun main() {

    var i = -831
    var rot = 50
    var count = 0

    if (i > 0){
        while (i > 0){
            i--
            rot++
            if (rot == 100){
                rot = 0
                count++
            }

        }
    }
    if (i < 0)
    {
        while (i < 0){
            i++
            rot--
            if (rot == 0){
                rot = 100
                count++
            }
        }
    }

    println(count)
    println(rot)

}
