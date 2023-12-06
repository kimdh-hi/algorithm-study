package com.problem

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger
import java.util.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val input = br.readLine()
  val st = StringTokenizer(input, " ")
  val money = BigInteger(st.nextToken())
  val peopleCount = BigInteger(st.nextToken())


  val sharedMoney = money / peopleCount
  val leftMoney = money % peopleCount

  println(sharedMoney)
  println(leftMoney)
}