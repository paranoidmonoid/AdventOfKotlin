package AoC2015

import java.io.File


fun main(args: Array<String>) {
    val testStrings = File("C:\\Users\\kotat\\input.txt").readLines()
    println(testStrings.asSequence().filter(::isNice).count())
    println(testStrings.asSequence().filter(::isEvenNicer).count())
}

fun isNice(str: String): Boolean {
    val vowels = "[aeiou].*?[aeiou].*?[aeiou]".toRegex() //bad regex I think
    val doubles = "(\\w)\\1".toRegex()
    val bads = "(ab)|(cd)|(pq)|(xy)".toRegex()
    return !str.contains(bads) && str.contains(vowels) && str.contains(doubles)
}

fun isEvenNicer(str: String): Boolean{
    val pair = "(\\w{2}).*\\1".toRegex()
    val letterBetween = "(\\w)\\w\\1".toRegex()
    return str.contains(pair) && str.contains(letterBetween)
}