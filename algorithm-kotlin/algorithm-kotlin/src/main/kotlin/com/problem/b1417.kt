package com.problem

fun main() {
  val count = readln().toInt()
  var result = 0

  var dasom = readln().toInt()
  val others = IntArray(count - 1) { readln().toInt() }.sortedArrayDescending()

  if (count > 1) {
    while (others[0] >= dasom) {
      others[0]--
      dasom++
      result++
      others.sortDescending()
    }
  }

  println(result)
}

