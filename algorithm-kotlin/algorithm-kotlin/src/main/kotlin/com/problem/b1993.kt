package com.problem

import java.io.BufferedReader
import java.io.InputStreamReader

//https://www.acmicpc.net/problem/1251
//단어 나누기
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val word = br.readLine().toString()
  var sortedWord = ""

  for (i in 0 ..< word.lastIndex - 1) {
    for (j in i + 1..< word.lastIndex) {
      val slicedWord = word.slice(0..i).reversed() + word.slice(i + 1..j).reversed() + word.slice(j + 1..word.lastIndex).reversed()
      if (sortedWord.isNotBlank()) {
        sortedWord = minOf(slicedWord, sortedWord)
      } else {
        sortedWord = slicedWord
      }
    }
  }

  println(sortedWord)
}
