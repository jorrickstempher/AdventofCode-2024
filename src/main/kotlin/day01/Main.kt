package org.example.day01
import java.io.File
import java.io.InputStream
import kotlin.math.abs

fun main() {
    val inputStream: InputStream = File("/Users/jorrickstempher/Library/Mobile Documents/com~apple~CloudDocs/Repos/AdventofCode-2024/src/main/kotlin/day01/input.txt").inputStream()

    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { lineList.add(it) }

    val leftList = mutableListOf<Int>()
    val rightList = mutableListOf<Int>()

    lineList.forEach {
        val numbers = it.split("  ").map { num -> num.trim() }
        leftList.add(numbers[0].toInt())
        rightList.add(numbers[1].toInt())
        if(numbers[1].isEmpty()){ println("Empty")}
    }

    leftList.sort()
    rightList.sort()

    partOne(leftList, rightList)
    partTwo(leftList, rightList)
}

fun partOne(leftList: List<Int>, rightList: List<Int>){
    println("Part one:")
    var answer = 0
    for (i in 0 until leftList.size) {
        answer += abs(leftList[i] - rightList[i])
    }
    println("Answer: $answer\n===============\n" )
}

fun partTwo(leftList: List<Int>, rightList: List<Int>){
    println("Part two:")
    var answer = 0
    leftList.forEach { left ->
        val matchingRight = rightList.find { right -> left == right }
        if (matchingRight != null) {
            rightList.count(matchingRight::equals)
            .also { answer += it * left }
        }
    }
    println("Answer: $answer\n===============\n")
}